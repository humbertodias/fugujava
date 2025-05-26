package com.technicat.globject;

import com.technicat.jogl.*;

import java.awt.*;

/**
 * Command for setting an object color
 * @author Phil Chu
 */
public class ObjectColorCommand extends GLColorCommand {

    GLObject object;

    public ObjectColorCommand(Component parent, GLApplication app, GLObject object) {
	super(parent, app);
	setName("Object Color");
	setHelp("Choose an object color");
	this.object = object;
    }

    protected void applyColor() {
	object.setColor(getColor());
	super.applyColor();
    }

}
