package com.technicat.desktopinternal;

import com.technicat.swing.*;

import java.awt.*;


/**
 * Command for setting the background color
 * @author Phil Chu
 */
public class BackgroundColorCommand extends ColorCommand {

    public BackgroundColorCommand(Component parent) {
	super(parent);
	setName("Background Color");
	setHelp("Choose background color for desktop");
    }

    protected void applyColor() {
	getParent().setBackground(getColor());
    }
}

