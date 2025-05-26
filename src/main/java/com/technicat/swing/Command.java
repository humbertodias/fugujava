package com.technicat.swing;

import javax.swing.*;


/**
 * a user interface operation
 * TODO - add acclerators?
 * TODO - add icons?
 * @author Phil Chu
 */
public abstract class Command extends AbstractAction {

    public Command() {
	super();
    }

    public void setKey(int key) {
	putValue(MNEMONIC_KEY,new Integer(key));
    }

    public void setName(String name) {
	putValue(NAME,name);
    }

    public String getName() {
	return (String)getValue(NAME);
    };

    public void setHelp(String name) {
	putValue(SHORT_DESCRIPTION,name);
    }

    public String getHelp() {
	return (String)getValue(SHORT_DESCRIPTION);
    };

}
