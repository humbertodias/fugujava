package com.technicat.swing;

import java.awt.*;

/**
 * Command that shows a popup with the application description
 * @author Phil Chu
 */
public class AboutCommand extends PopupCommand {

    private String appname;

    public AboutCommand(String name,Component parent) {
	super(parent);
	appname = name;
	setName("About");
	setHelp("Information about this Application");
    }

    protected String getTitle() {
	return "About "+appname;
    }

    protected String getMessage() {
	return "<html>Copyright &copy; <a href=&quote;http://www.technicat.com/&quote;>Technicat, LLC</a> 2003-2006.<br>All Rights Reserved.</html>";
    }

}

