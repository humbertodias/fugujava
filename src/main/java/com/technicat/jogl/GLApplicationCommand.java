package com.technicat.jogl;

import com.technicat.swing.*;

import java.awt.event.*;

/**
 * Command in a JOGL application
 * @author Phil Chu
 */
abstract public class GLApplicationCommand extends Command {

    GLApplication application;

    public GLApplicationCommand(GLApplication app) {
	this.application = app;
    }

    protected GLApplication getApplication() {
	return application;
    }

    /**
     * Command usually require re-rendering
     */
    public void actionPerformed(ActionEvent event) {
	application.redraw();
    }

}
