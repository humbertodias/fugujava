package com.technicat.desktop;

import com.technicat.swing.Command;

import java.awt.*;
import java.awt.event.*;

/**
 * @author Philip Chu
 */
public class FullScreenCommand extends Command {

    private Window window;

    public FullScreenCommand(Window window) {
	super();
	this.window = window;
	setName("Full Screen");
	setHelp("Full screen mode");
    }

    public boolean isEnabled() {
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = ge.getDefaultScreenDevice();
	return device.isFullScreenSupported();
    }

    public void actionPerformed(ActionEvent event) {
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = ge.getDefaultScreenDevice();
	device.setFullScreenWindow(window);
    }
}

