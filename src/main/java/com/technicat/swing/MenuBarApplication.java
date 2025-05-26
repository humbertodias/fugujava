package com.technicat.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Application with a menu bar
 * @author Phil Chu
 */
abstract public class MenuBarApplication extends Application {

    public MenuBarApplication() {
	super();
    }

    /**
     * Wrap container around desktop pane
     */
    public void setContainer(ApplicationContainer frame) {
	super.setContainer(frame);
	createMenuBar();
	getContainer().setJMenuBar(getMenuBar());
    }

    /**
     */
    //    protected void createActions() {
    //	super.createActions();
	//	addCommand(new BackgroundColorCommand(getRootPane().getContentPane()));
    //    }

    private JMenuBar bar = new JMenuBar();

    protected JMenuBar getMenuBar() {
	return bar;
    }

    /**
     * Add a menu to the menubar
     * Todo: accessor to retrieve the menu
     */
    protected void addMenu(JMenu menu) {
	bar.add(menu);
    }

    /**
     * Install menus on menubar
     * Assumes menubar as been created and installed.
     */
    protected void createMenuBar() {
	//createFileMenu();
	createViewMenu();
	createHelpMenu();
    }

    private JMenu helpmenu;

    protected JMenu getHelpMenu() {
	return helpmenu;
    }

    // private JMenu filemenu;

    /*
    protected JMenu getFileMenu() {
	return filemenu;
	} */

    /*    protected void addFileCommand(String name) {
	addFileCommand(getCommand(name));
    }

    protected void addFileCommand(Command command) {
	getFileMenu().add(command);
	} */

    /**
     * Creates a File menu and adds it to the menu bar
     */
    /*
    protected void createFileMenu() {
	filemenu = new JMenu("File");
	// invoke with Alt-F
	filemenu.setMnemonic(KeyEvent.VK_F);
	//addFileCommand("New");
	// add menu to menubar
	addMenu(filemenu);
	} */

    private JMenu viewmenu;

    protected JMenu getViewMenu() {
	return viewmenu;
    }

    protected void addViewCommand(String name) {
	addViewCommand(getCommand(name));
    }

    protected void addViewCommand(Command command) {
	getViewMenu().add(command);
    }

    /**
     */
    protected void createViewMenu() {
	viewmenu = new JMenu("View");
	viewmenu.setMnemonic(KeyEvent.VK_V);
	addMenu(viewmenu);

	JMenu landfmenu = new JMenu("Look and Feel");
	createLandFCommands(landfmenu);
	viewmenu.add(landfmenu);
	// 	getViewMenu().addSeparator();
	//	getViewMenu().add(getCommand("Background Color"));
	//	getHelpMenu().add(addCommand(new FullScreenCommand(getContainer())));

    }

    protected void createHelpMenu() {
	helpmenu = new JMenu("Help");
	helpmenu.setMnemonic(KeyEvent.VK_H);
	addMenu(helpmenu);
	getHelpMenu().add(addCommand(new AboutCommand(getName(),(Component)getContainer())));

	getHelpMenu().add(addCommand(new SystemCommand((Component)getContainer())));
	getHelpMenu().add(addCommand(new GraphicsInfoCommand((Component)getContainer())));
    }
    /*
    private void createLandFCommands() {
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

    private void createLandFCommands(JMenu menu) {
	ButtonGroup group = new ButtonGroup();
	UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
	for (int i=0; i<infos.length; ++i) {
	    Command command = new LAndFCommand((Component)getContainer(),infos[i]);
	    JRadioButtonMenuItem item = new JRadioButtonMenuItem(command);
	    item.setSelected(UIManager.getLookAndFeel().getName().equals(infos[i].getName()));

	    menu.add(item);
	    group.add(item);
	}
    }

}
