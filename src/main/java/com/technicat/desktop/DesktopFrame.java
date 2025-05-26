package com.technicat.desktop;

import com.technicat.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Run an Application in a frame.
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Philip Chu
 */
public class DesktopFrame extends JFrame implements ApplicationContainer, WindowListener {

    /**
     * Entry point.
     * @param args - required first command line argument is an Application class name
     */
    static public void main(String[] args) {
	if (args.length==0) {
	    errorDialog("You need to supply an Application class name.");
	    System.exit(0);
	} else {
	    // otherwise, instantiate the application
	    try {
		Application app = (Application)Class.forName(args[0]).newInstance();
		DesktopFrame frame = new DesktopFrame(app);
	    } catch (Exception exception) {
		errorDialog(exception.getMessage());
		exception.printStackTrace();
	    }
	}
    }

    public DesktopFrame(Application app) {
	addWindowListener(this);
	app.setContainer(this);
	setResizable(true);
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	setTitle(app.getName());	
	setSize(new Dimension(640,480));
	setVisible(true);
    }

    /**
     * Put this somewhere else
     */
    static public void errorDialog(String message) {
	JOptionPane.showMessageDialog(null,
				      message,
				      "FrameStarter Error",
				      JOptionPane.ERROR_MESSAGE);
    }

    public void showStatus(String text) {}

    public void windowDeactivated(WindowEvent event) {}
    public void windowActivated(WindowEvent event) {}
    public void windowDeiconified(WindowEvent event) {}
    public void windowIconified(WindowEvent event) {}
    public void windowClosed(WindowEvent event) {}
    public void windowClosing(WindowEvent event) {
	if (JOptionPane.showConfirmDialog(this,"Do you want to quit?")==JOptionPane.YES_OPTION) {
	    System.exit(0);
	}
    }
    public void windowOpened(WindowEvent event) {}
}
