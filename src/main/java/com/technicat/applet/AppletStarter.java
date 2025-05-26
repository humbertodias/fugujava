package com.technicat.applet;

import com.technicat.swing.*;

import javax.swing.*;

/**
 * Applet container for Application
 * Takes class name as first parameter
 * @author Phil Chu
 */
public class AppletStarter extends JApplet implements ApplicationContainer {

    public void init() {
	try {
	    Application app = (Application)Class.forName(getParameter("class")).newInstance();
	    app.setContainer(this);
	} catch (Exception exception) {
	}
    }

    public void showStatus(String string) {};
}
