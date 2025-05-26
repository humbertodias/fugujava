package com.technicat.desktopinternal;

import com.technicat.swing.*;

import javax.swing.*;


/**
 * JInternalFrame container for an Application in a JDesktopPane
 * @author Phil Chu
 */
public class DesktopInternalFrame extends JInternalFrame implements ApplicationContainer {

    private Application app;
    /**
     */
    public DesktopInternalFrame(Application app) {
	super();
	this.app = app;
	app.setContainer(this);
	pack();
	setIconifiable(true);
	setResizable(false);
	setClosable(true);
	showStatus("");
	show();
    }


    public void showStatus(String string) {
	if (string.length() == 0) {
	    setTitle(app.getName());
	} else {
	    setTitle(app.getName()+" - "+string);
	}
    }
}
