package com.technicat.jogl;

import com.technicat.swing.*;

import java.awt.event.*;

/**
 * Command for setting an object color
 * @author Phil Chu
 */
public class DepthBufferCommand extends GLApplicationCommand {

    public DepthBufferCommand(GLApplication app) {
	super(app);
	setName("Depth Test");
	setHelp("Toggle Depth Test");
    }

    public void actionPerformed(ActionEvent event) {
	getApplication().setDepthTest(!getApplication().hasDepthTest());
	super.actionPerformed(event);
    }

}
