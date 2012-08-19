package com.technicat.desktop;

import javax.swing.*;

/**
 * @author Phil Chu
 */
public class FileOpenCommand extends FileCommand {

	public FileOpenCommand() {
	    super();
	    setName("Open");
	    setHelp("Open a file.");
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
	    chooser = new JFileChooser();
	    status = chooser.showOpenDialog(null);
	    super.actionPerformed(event);
	}
    }

