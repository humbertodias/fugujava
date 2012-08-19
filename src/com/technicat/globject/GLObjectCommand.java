package com.technicat.globject;

import com.technicat.jogl.*;

/**
 * Command operating on a GLObject
 * @author Phil Chu
 */
abstract public class GLObjectCommand extends GLApplicationCommand {

    GLObject object;

    public GLObjectCommand(GLApplication app, GLObject object) {
	super(app);
	this.object = object;
    }

    protected GLObject getObject() {
	return object;
    }

}
