package com.technicat.desktop;

import javax.swing.*;
import java.awt.event.*;

/**
 * @author Phil Chu
 */
public class FileSaveCommand extends FileCommand {

	public FileSaveCommand() {
	    super();
	    setName("Save");
	    setHelp("Save a file.");
	    setKey(KeyEvent.VK_S);
	}

	public void actionPerformed(java.awt.event.ActionEvent event) {
	    chooser = new JFileChooser();
	    status = chooser.showSaveDialog(null);
	    super.actionPerformed(event);
	}
    }

