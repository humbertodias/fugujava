package com.technicat.desktop;

import com.technicat.swing.Command;

import java.awt.event.*;

public class QuitCommand extends Command {

    /**
     *
     */
	public QuitCommand() {
	    super();
	    setKey(KeyEvent.VK_Q);
	    setName("Quit");
	    setHelp("Exit this application.");
	}

    /**
     * Exits application (exits Java)
     */
	public void actionPerformed(java.awt.event.ActionEvent event) {
	    System.exit(0);
	}
    }

