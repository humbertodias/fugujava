package com.technicat.desktopinternal;

import com.technicat.swing.*;

import javax.swing.*;
import java.awt.*;

/**
 * Application that has a desktop window.
 * Copyright 2003-2006 Technicat, LLC
 * @author Phil Chu
 */
abstract public class DesktopApplication extends MenuBarApplication {

    public DesktopApplication() {
	super();
	desktop = new JDesktopPane();
	//	getRootPane().setContentPane(desktop);
    }

    private JDesktopPane desktop;

    public JDesktopPane getDesktop() {
	return desktop;
    }

    /**
     * Wrap container around desktop pane
     */
    public void setContainer(ApplicationContainer frame) {
	super.setContainer(frame);
	getRootPane().setContentPane(desktop);
    }

    /**
     */
    //        protected void createActions() {
    //    	super.createActions();
    //	addCommand(new AboutCommand(getName(),(Component)getContainer()));
    //        }

    /**
     */
    protected void createViewMenu() {
	super.createViewMenu();
	//	createLandFCommands();
	// 	getViewMenu().addSeparator();
	//	getViewMenu().add(getCommand("Background Color"));
    	getViewMenu().add(addCommand(new BackgroundColorCommand(getDesktop())));
	//	getHelpMenu().add(addCommand(new FullScreenCommand(getContainer())));

	}

    /*    protected void createHelpMenu() {
	super.createHelpMenu();
	getHelpMenu().add(getCommand("About"));
	getHelpMenu().add(addCommand(new SystemCommand((Component)getContainer())));
	getHelpMenu().add(addCommand(new GraphicsInfoCommand((Component)getContainer())));
	} */

    /**
     * Add look-and-feel commands to the View menu
     */
    /*    private void createLandFCommands() {
	ButtonGroup group = new ButtonGroup();
	UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
	for (int i=0; i<infos.length; ++i) {
	    Command command = new LAndFCommand((Component)getContainer(),infos[i]);
	    JRadioButtonMenuItem item = new JRadioButtonMenuItem(command);
	    item.setSelected(UIManager.getLookAndFeel().getName().equals(infos[i].getName()));

	    getViewMenu().add(item);
	    group.add(item);
	}
	} */

    /**
     * Add look-and-feel commands to the View menu
     */
    /*
    private void createDisplayModeCommands() {
	ButtonGroup group = new ButtonGroup();
	GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	GraphicsDevice device = ge.getDefaultScreenDevice();
	DisplayMode[] modes = device.getDisplayModes();
	for (int i=0; i<modes.length; ++i) {
	    Command command = new DisplayModeCommand(device,modes[i]);
	    JRadioButtonMenuItem item = new JRadioButtonMenuItem(command);
	    getViewMenu().add(item);
	    group.add(item);
	}
	}*/

}
