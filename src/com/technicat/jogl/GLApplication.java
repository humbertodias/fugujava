package com.technicat.jogl;

import com.technicat.swing.*;
import com.technicat.view3d.*;

import javax.vecmath.*;
import javax.media.opengl.*;
import javax.swing.*;
import java.awt.*;

import java.util.Vector;

/**
 * A JOGL Application
 * Copyright 2006 Technicat, LLC
 * @author Phil Chu
 */
abstract public class GLApplication extends MenuBarApplication implements GLEventListener {

    private Color clearColor;
    private boolean depthTest;
    private boolean lighting;

    private GLCanvas canvas;

    private String vendor;
    private String version;
    private String renderer;

    public GLApplication() {
	canvas = new GLCanvas();
	clearColor = Color.white;
	depthTest = true;
    }

    public String getVersion() {
	return version;
    }

    public String getVendor() {
	return vendor;
    }

    public String getRenderer() {
	return renderer;
    }

    public void redraw() {
	canvas.display();
    }

    public boolean hasDepthTest() {
	return depthTest;
    }

    public void setDepthTest(boolean test) {
	depthTest = test;
    }

    public boolean hasLighting() {
	return lighting;
    }

    public void setLighting(boolean on) {
	lighting = on;
    }

    public Color getClearColor() {
	return clearColor;
    }

    public void setClearColor(Color color) {
	clearColor = color;
    }

    /**
     * Wrap container around desktop pane
     */
    public void setContainer(ApplicationContainer frame) {
	super.setContainer(frame);
	canvas.addGLEventListener(this);
	getRootPane().getContentPane().setLayout(new BorderLayout());
	getRootPane().getContentPane().add(canvas, BorderLayout.CENTER);
    }

    /**
     */
    protected void createViewMenu() {
	super.createViewMenu();
	getViewMenu().add(new ClearColorCommand(canvas,this));
	addViewMenuCheckBox(new DepthBufferCommand(this),depthTest);
	addViewMenuCheckBox(new LightingCommand(this),lighting);
    }

    protected void addViewMenuCheckBox(Command command, boolean selected) {
	JCheckBoxMenuItem item = new JCheckBoxMenuItem(command);
	item.setSelected(selected);
	getViewMenu().add(item);
    }

    protected void createHelpMenu() {
	super.createHelpMenu();
	getHelpMenu().add(new GLInfoCommand(canvas,this));
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void display(GLAutoDrawable drawable) {
	GL gl = drawable.getGL();
	gl.glLoadIdentity();
	gl.glClearColor(clearColor.getRed()/255.0f,
			clearColor.getGreen()/255.0f,
			clearColor.getBlue()/255.0f,
			clearColor.getAlpha()/255.0f);
	gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
	if (depthTest) {
	    gl.glDisable(GL.GL_DEPTH_TEST);
	} else {
	    gl.glClear(GL.GL_COLOR_BUFFER_BIT);
	    gl.glEnable(GL.GL_DEPTH_TEST);
	}
	if (lighting) {
	    gl.glEnable(GL.GL_LIGHTING);
	} else {
	    gl.glDisable(GL.GL_LIGHTING);
	}
	gl.glDisable(GL.GL_CULL_FACE);
    }

    public void init(GLAutoDrawable drawable) {
	GL gl = drawable.getGL();
	gl.setSwapInterval(1); // sync
	vendor = gl.glGetString(GL.GL_VENDOR);
	renderer = gl.glGetString(GL.GL_RENDERER);
	version = gl.glGetString(GL.GL_VERSION);
    }

}
