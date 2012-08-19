package com.technicat.globject;

import com.technicat.swing.*;

import javax.media.opengl.*;
import java.awt.*;

/**
 * A 3D object with a JOGL renderer
 * Copyright 2006 Technicat, LLC
 * @author Phil Chu
 */
abstract public class GLObject {

    private Color color;
    private boolean visible;
    private String name;

    public GLObject() {
	color = Color.black;
	visible = true;
	name = "unnamed object";
    }
    
    public void render(GL gl) {
	useColor(gl);
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public Color getColor() {
	return color;
    }

    public void setColor(Color color) {
	this.color = color;
    }

    protected void useColor(GL gl) {
	gl.glColor4i(color.getRed(),color.getGreen(),color.getBlue(),color.getAlpha());
    }

    public boolean isVisible() {
	return visible;
    }

    public void setVisible(boolean visible) {
	this.visible = visible;
    }

}
