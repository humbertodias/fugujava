package com.technicat.swing;

import javax.swing.*;
import java.awt.*;

/**
 * Show graphics information
 * @author Phil Chu
 */
public class GraphicsInfoCommand extends PopupCommand {

    public GraphicsInfoCommand(Component parent) {
	super(parent);
	setName("Display Info");
	setHelp("Display hardware information");
    }

    protected String getMessage() {
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = ge.getDefaultScreenDevice();
	DisplayMode mode = device.getDisplayMode();
	return "<html>"+
	    //				      device.getIDstring()+
	    //				      "VRAM "+device.getAvailableAcceleratedMemory()+"bytes"+
	    //				      "<br>"+
	    mode.getWidth()+"x"+mode.getHeight()+
	    "@"+mode.getRefreshRate()+"Hz "+
	    mode.getBitDepth()+"bpp"+
	    "</html>";
    }

    protected String getTitle() {
	return "Graphics Info";
    }

}

