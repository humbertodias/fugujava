package com.technicat.micro;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

abstract public class Application extends MIDlet implements CommandListener {

    private Command exitCommand;
    private Command aboutCommand;
    private Display display;
    
    protected Display getDisplay() {
	return display;
    }

    protected Command getExitCommand() {
	return exitCommand;
    }

    protected Command getHelpCommand() {
	return aboutCommand;
    }

    public void startApp() {
	if (display == null) {
	    initApp();
	}
    }

    protected void initApp() {
	display = Display.getDisplay(this);
	exitCommand = new Command("Quit",Command.EXIT,1);
	aboutCommand = new Command("About",Command.HELP,1);
    }

    public void destroyApp(boolean b) {
    }

    public void pauseApp() {
    }

    public void commandAction(Command c,Displayable s) {
	if (c == exitCommand) {
	    destroyApp(false);
	    notifyDestroyed();
	}
	if (c == aboutCommand) {
	    Alert alert = new Alert("About",
				    "Copyright (c) 2005 Technicat, LLC",
				    null,null);
	    alert.setTimeout(Alert.FOREVER);
	    getDisplay().setCurrent(alert,s);
	}
    }

}
