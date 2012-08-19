package com.technicat.net;

import com.technicat.desktopinternal.*;

/**
 * A multiple-document browser desktop
 * @author Philip Chu
 */
public class BrowserDesktop extends DesktopApplication {

    public BrowserDesktop() {
	super();
    }

    public String getName() {
	return "Browser Desktop";
    }

    /**
    public void initContainer(Container container) {
	super.initContainer(container);
	setNewAction(new NewAction() { public void action() { newFrame(); } });
	} **/

    protected void newFrame() {
	Browser browser = new Browser();
	browser.setSize(200,200);
	browser.setVisible(true);
	browser.setResizable(true);
	getDesktop().add(browser,new Integer(1));
    }
}
