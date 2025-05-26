package com.technicat.jogl;

import com.technicat.swing.*;

import java.awt.event.*;

/**
 * Command for setting an object color
 * @author Phil Chu
 */
public class LightingCommand extends GLApplicationCommand {

    public LightingCommand(GLApplication app) {
	super(app);
	setName("Lighting");
	setHelp("Toggle Lighting");
    }

    public void actionPerformed(ActionEvent event) {
	getApplication().setLighting(!getApplication().hasLighting());
	super.actionPerformed(event);
    }

}
