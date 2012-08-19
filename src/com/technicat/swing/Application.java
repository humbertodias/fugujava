package com.technicat.swing;

import javax.swing.*;
import java.awt.event.*;

import java.util.*;

/**
 * Swing application wrapper
 * for embedding within an applet or desktop application
 */
abstract public class Application {

    private ApplicationContainer parent;

    public Application() {
	super();
    }

    public void start() {}

    protected ApplicationContainer getContainer() {
	return parent;
    }

    protected RootPaneContainer getRootPane() {
	return (RootPaneContainer)parent;
    }

    /**
     * @return The application name
     */
    public abstract String getName();

    /**
     * Initialize container properties
     */
    public void setContainer(ApplicationContainer container) {
	parent = container;
	createActions();
    }

    public void showMessage(String message) {
	JOptionPane.showMessageDialog((JComponent)parent,
				      message,
				      "Message",
				      JOptionPane.INFORMATION_MESSAGE);
				      }

    /**
     *
     */
    public void showStatus(String message) {
	parent.showStatus(message);
    }

        /**
     * table of all Commands in this application
     * keyed by name
     */
    private Hashtable actions = new Hashtable();

    /**
     * Add a Command to the the command table
     * @param command
     */
    public Command addCommand(Command command) {
	actions.put(command.getName(),command);
	return command;
    }

    /**
     * Retrieve command from the command table
     * @param name - name of the command
     */
    public Command getCommand(String name) {
	return (Command)actions.get(name);
    }

    /**
     * Create commands
     */
    protected void createActions() {
	addCommand(new NewCommand());
    }

    /**
     * Set action for New command
     * Assumes New command has been added to the command table.
     */
    protected void setNewAction(NewAction action) {
	((NewCommand)getCommand("New")).setAction(action);
    }
	
}
