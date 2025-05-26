package com.technicat.jogl;

import com.technicat.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * Command for setting a GL color
 * @author Phil Chu
 */
public class GLColorCommand extends ColorCommand {

    GLApplication application;

    public GLColorCommand(Component parent, GLApplication app) {
	super(parent);
	application = app;
    }

    protected void applyColor() {
	application.redraw();
    }

}
