package com.technicat.swing;

import java.awt.event.*;

/**
 * Command to create a New something
 * @author Phil Chu
 */
public class NewCommand extends Command {

    public NewCommand() {
	    super();
	    setName("New");
	    setKey(KeyEvent.VK_N);
	}

    //    private Class cl;
    //private Object obj;

    //public void setClass(Class cl) {
    //this.cl = cl;
    //}

    /**
     * New action to execute
     */
    private NewAction action;

    /**
     * Set New action
     */
    public void setAction(NewAction action) {
	this.action = action;
    }

    /**
     * Invokes New action.
     * NOOP if setAction was never called.
     */
    public void actionPerformed(java.awt.event.ActionEvent event) {
	if (action!=null) {
	    action.action();
	}

	/*try {
	    obj = cl.newInstance();
	} catch (InstantiationException exception) {
	}
	catch (IllegalAccessException exception) {
	} */
    }
}

