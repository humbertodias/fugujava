package com.technicat.net;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Little web browser based on Swing HTML component.
 * Copyright 2000 Phil Chu
 */
public class Browser extends JInternalFrame {

    private JTextField urlfield;
    private JEditorPane editor;

    public Browser() {
	super();

	// URL entry field
	urlfield = new JTextField();
	urlfield.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent event) {
		    setURL(urlfield.getText());
		}
	    }
				   );
	urlfield.setToolTipText("Enter URL");

	editor = new JEditorPane();
	editor.setEditable(false);
	editor.setSize(500,500);

	// link click action
	editor.addHyperlinkListener(new HyperlinkListener() {
		public void hyperlinkUpdate(HyperlinkEvent event) {
		    setURL(event.getURL().toString());
		}
	    }
				    );

	JScrollPane scroll = new JScrollPane(editor);

	Container container = getContentPane();
	container.setLayout(new BorderLayout());
	// top
	JPanel toppanel = new JPanel();

	JToolBar toolbar = new JToolBar();

	toppanel.setLayout(new BorderLayout());
	toppanel.add(urlfield,BorderLayout.NORTH);
	toppanel.add(toolbar,BorderLayout.CENTER);

	container.add(toppanel,BorderLayout.NORTH);
	container.add(scroll,BorderLayout.CENTER);
    }

    /**
     *
     */
    public void setURL(String url) {
	try {
	    editor.setPage(url);
	}
	catch (Exception exception) {
	    JOptionPane.showMessageDialog(null,exception.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
	}
	urlfield.setText(url);
    }

}
