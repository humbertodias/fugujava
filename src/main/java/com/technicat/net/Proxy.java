/**
 * This is a simple HTTP proxy server useful for testing
 * basic proxy connectivity and tracing http requests and responses.
 * This code  is subject to the
 * Artistic License at
 * http://www.opensource.org/licenses/artistic-license.html.
 * Copyright 2000 Phil Chu
 * philipchu@technicat.com
 * http://www.technicat.com/
 */

package com.technicat.net;

import java.io.*;
import java.net.*;
import java.util.*;

public class Proxy implements Runnable {

    static public void main(String[] args) throws IOException {
	int port = 8000;
	if (args.length>0) {
	    port = Integer.parseInt(args[0]);
	}
	System.out.println("Starting proxy on port "+port+"....");
	ServerSocket server = new ServerSocket(port);
	while (true) {
	    Socket sock = server.accept();
	    Thread thread = new Thread(new Proxy(sock));
	    thread.start();
	}
    }

    private Socket sock;
    private boolean on = true;
    private int contentlength = 0;
    private String contentType="";
    
    public Proxy(Socket sock) {
	this.sock = sock;
	on = true;
    }

    public void run() {
	try {
	    Socket target = null;
	    while (on) {
		System.out.println("Reading client request line...");
		InputStream in = sock.getInputStream();
		String reqline = readLine(in);
		System.out.println(reqline);
		StringTokenizer toke = new StringTokenizer(reqline);
		String method = toke.nextToken();
		URL url = new URL(toke.nextToken());
		String version = toke.nextToken();
		int port = url.getPort();
		if (port==-1) {
		    port= 80;
		}
		// connection is not persistent if http 1.0
		if (version.equalsIgnoreCase("HTTP/1.0")) {
		    on = false;
		}
		if (target == null) {
		    target = new Socket(url.getHost(),port);
		}
		OutputStream out = target.getOutputStream();
		// pass through modified req-line
		System.out.println("Sending client request line...");
		send(out,method+" "+url.getPath()+" "+version);
		// send(writer,"Host: "+url.getHost()+":"+port);
		// pass through rest of request
		System.out.println("Sending client headers and data...");
		passMessage(in,out);
		// read and pass through reponse
		System.out.println("Sending response headers and data...");
		passMessage(target.getInputStream(),sock.getOutputStream());
	    }
	    // close client connection
	    sock.close();
	    target.close();
	    System.out.println("connection closed");
	}
	catch (IOException exception) {
	    exception.printStackTrace();
	}
    }

    /**
     * Send string to output stream
     * terminate with CRLF
     * Also print to console.
     */
    private void send(OutputStream writer,String msg) throws IOException {
	writer.write(msg.getBytes(),0,msg.length());
	writer.write('\r');
	writer.write('\n');
	System.out.println(msg);
    }

    /**
     * read line from input stream
     * terminating with CRLF or LF
     * consumes terminating CRLF or LF.
     * @return line as String
     */
    private String readLine(InputStream in) throws IOException {
	byte[] bytes = new byte[300];
	int i=0;
	int b = in.read();
	while (b!='\r' && b!='\n') {
	    bytes[i++]=(byte)b;
	    b = in.read();
	}
	// if read CR, then consume LF
	if (b=='\r') {
	    b = in.read();
	}
	return new String(bytes,0,i);
    }

    /**
     * Pass message (headers and data) through.
     */
    private void passMessage(InputStream in,OutputStream out) throws IOException {
	passHeaders(in,out);
	if (contentlength>0) {
	    passData(in,out);
	}
    }

    /**
     * Pass headers through.
     * Print on console.
     */
    private void passHeaders(InputStream in, OutputStream out) throws IOException {
	System.out.println("Sending headers...");
	contentlength=0;
	String reqline = readLine(in);
	while (reqline.length()!=0) {
	    send(out,reqline);
	    StringTokenizer toke = new StringTokenizer(reqline);
	    String field = toke.nextToken();
	    // save connection type
	    if (field.equalsIgnoreCase("Connection:")) {
		if (toke.nextToken().equalsIgnoreCase("Close")) {
		    on = false;
		}
	    }
	    // save content type
	    if (field.equalsIgnoreCase("Content-Type:")) {
		contentType=toke.nextToken();
	    }
	    // save content length
	    if (field.equalsIgnoreCase("Content-Length:")) {
		contentlength=Integer.parseInt(toke.nextToken());
	    }
	    reqline = readLine(in);
	}
	// terminate headers
	send(out,"");
    }

    /**
     * Pass message body through.
     */
    private void passData(InputStream in, OutputStream out) throws IOException {
	System.out.println("Sending data...");
	byte[] data =new byte[1000];
	int totalread = 0;
	int bytes = 1;
	while (bytes>0 && totalread<contentlength) {
	    bytes = in.read(data);
	    if (bytes>0) {
		totalread+=bytes;
		if (contentType.startsWith("text")) {
		    System.out.print(new String(data,0,bytes));
		}
		out.write(data,0,bytes);
	    } else {
		on = false;
		System.out.println("premature end of data");
	    }
	}
	out.flush();
	System.out.println("Send "+totalread+" bytes");
    }
}
