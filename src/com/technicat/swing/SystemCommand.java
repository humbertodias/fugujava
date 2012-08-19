package com.technicat.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Command that displays Java and OS information
 * @author Phil Chu
 */
public class SystemCommand extends PopupCommand {

    public SystemCommand(Component parent) {
	super(parent);
	setName("System");
	setHelp("Information about Java");
    }

    protected String getMessage() {
	return "<html>"+
	    "JRE "+System.getProperty("java.version")+
	    " "+System.getProperty("java.vendor")+
	    " "+System.getProperty("java.vendor.url")+
	    //    "<br/>"+System.getProperty("java.home")+
	    //   "<br/>"+System.getProperty("java.class.path")+
	    "<br>"+System.getProperty("os.name")+
	    " "+System.getProperty("os.version")+
	    " "+System.getProperty("os.arch")+
	    "</html>";
    }

    protected String getTitle() {
	return "System Info";
    }

}

