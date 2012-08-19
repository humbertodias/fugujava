package com.technicat.jogl;

import com.technicat.swing.*;
import java.awt.*;

/**
 * Show GL information
 * @author Phil Chu
 */
public class GLInfoCommand extends PopupCommand {

    GLApplication application;

    public GLInfoCommand(Component parent, GLApplication app) {
	super(parent);
	setName("GL Info");
	setHelp("Display GL information");
	application = app;
    }

    protected String getMessage() {
	return "<html>"+
	    application.getVendor()+"<br>"+
	    application.getRenderer()+"<br>"+
	    application.getVersion()+
	    "</html>";
    }

    protected String getTitle() {
	return "GL Info";
    }

}

