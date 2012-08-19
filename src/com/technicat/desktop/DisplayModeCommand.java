package com.technicat.desktop;

import com.technicat.swing.*;

import java.awt.*;

/**
 * command for setting a look and feel
 */
public class DisplayModeCommand extends Command {

    private GraphicsDevice device;
    private DisplayMode mode;

    public DisplayModeCommand(GraphicsDevice device,DisplayMode mode) {
	    super();
	    setName("Mode: "+mode.getWidth()+"x"+mode.getHeight()+"@"+mode.getRefreshRate()+"Hz "+mode.getBitDepth()+"bpp");
	    setHelp("Set display mode");
	    this.device = device;
	    this.mode = mode;
    }

    public boolean isEnabled() {
	return device.isDisplayChangeSupported();
    }

    /**
     * 
     */
    public void actionPerformed(java.awt.event.ActionEvent event) {
		device.setDisplayMode(mode);
	}
    }

