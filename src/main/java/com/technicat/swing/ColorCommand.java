package com.technicat.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Command that involves choosing a color.
 * @author Phil Chu
 */
abstract public class ColorCommand extends Command {

    private Component parent;

    private Color color = Color.BLACK;

    public ColorCommand(Component parent) {
	super();
	setName("Color");
	setHelp("Choose a color");
	this.parent = parent;
    }

    /**
     * @return currently-selected color
     */
    public Color getColor() {
	return color;
    }

    public Component getParent() {
	return parent;
    }

    public void actionPerformed(ActionEvent event) {
	color = JColorChooser.showDialog(parent,"Choose a color",color);
	if (color != null) {
	    applyColor();
	}
    }

    abstract protected void applyColor();

}

