package com.technicat.globject;

import com.technicat.jogl.*;

import java.awt.event.*;

/**
 * Command for setting an object color
 * @author Phil Chu
 */
public class ObjectVisibilityCommand extends GLObjectCommand {

    public ObjectVisibilityCommand(GLApplication app, GLObject object) {
	super(app,object);
	setName(object.getName());
	setHelp("Toggle "+object.getName()+" Visibility");
    }

    public void actionPerformed(ActionEvent event) {
	object.setVisible(!object.isVisible());
	super.actionPerformed(event);
    }

}
