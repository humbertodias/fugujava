package com.technicat.jogl;

import java.awt.*;

/**
 * Command for setting the background color
 * @author Phil Chu
 */
public class ClearColorCommand extends GLColorCommand {

    public ClearColorCommand(Component parent, GLApplication app) {
	super(parent,app);
	setName("Background Color");
	setHelp("Choose a background color");
    }

    protected void applyColor() {
	application.setClearColor(getColor());
	super.applyColor();
    }

}
