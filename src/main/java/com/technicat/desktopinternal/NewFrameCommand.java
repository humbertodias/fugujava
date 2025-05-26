package com.technicat.desktopinternal;

import com.technicat.swing.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * Command to create a new DesktopFrame application in a JDesktopPane
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
public class NewFrameCommand extends Command {

    private Class cl;
    private JDesktopPane desktop;
    private Application app;

    public NewFrameCommand(Class cl,String name,JDesktopPane desktop) {
	super();
	this.cl = cl;
	this.desktop = desktop;
	setName(name);
	setHelp("Start new "+name+" game");
    }

    protected Application getApplication() {
	return app;
    }

    public void actionPerformed(ActionEvent event) {
	try {
	    app = (Application)cl.newInstance();
	    JInternalFrame frame = new DesktopInternalFrame(app);
	    desktop.add(frame, new Integer(1));
	} catch (InstantiationException exception) {
	}
	catch (IllegalAccessException exception) {
	}
    }
}

