package com.technicat.desktop;

import com.technicat.swing.*;

import javax.swing.*;

import java.io.*;

/**
 * @author Phil Chu
 */
public abstract class FileCommand extends Command {

    private File file;
    protected JFileChooser chooser;
    protected int status;

    public void actionPerformed(java.awt.event.ActionEvent event) {
	if (status == JFileChooser.APPROVE_OPTION) {
	    setFile(chooser.getSelectedFile());
	} else {
	    setFile(null);
	}
	}


    public File getFile() {
	return file;
    }

    public void setFile(File file) {
	this.file = file;
    }
}

