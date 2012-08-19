package com.technicat.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Command that presents a modal popup message
 * @author Phil Chu
 */
abstract public class PopupCommand extends Command {

    private Component parent;

    public PopupCommand(Component parent) {
	super();
	this.parent = parent;
    }

    abstract protected String getMessage();

    abstract protected String getTitle();

    public void actionPerformed(ActionEvent event) {
	JOptionPane.showMessageDialog(parent, getMessage(), getTitle(),
				      JOptionPane.INFORMATION_MESSAGE);
    }
}

