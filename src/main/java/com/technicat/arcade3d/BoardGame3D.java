package com.technicat.arcade3d;

import com.technicat.swing.*;

import javax.swing.*;
import java.awt.*;

/**
 * Application that has a desktop window.
 * @author Phil Chu
 */
public class BoardGame3D extends MenuBarApplication {

    private Board3D board;

    public BoardGame3D()
 {
	super();
	board = new Board3D();
    }

    public void setContainer(ApplicationContainer container) {
	super.setContainer(container);
	getRootPane().getContentPane().add(board,BorderLayout.CENTER);
    }

    public String getName() {
	return "3D";
    }

}
