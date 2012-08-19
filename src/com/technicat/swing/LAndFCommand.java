package com.technicat.swing;

import javax.swing.*;
import java.awt.*;

/**
 * command for setting a look and feel
 */
public class LAndFCommand extends Command {

    /**
     * Root component
     */
    private Component parent;

    /**
     * Look and Feel to apply
     */
    private UIManager.LookAndFeelInfo info;

    public LAndFCommand(Component parent,UIManager.LookAndFeelInfo info) {
	    super();
	    this.parent = parent;
	    this.info = info;
	    setName(info.getName());
	    setHelp("Set look-and-feel to "+info.getName());
    }

    /**
     * Applies look and feel.
     */
    public void actionPerformed(java.awt.event.ActionEvent event) {
	    setLAndF(info.getClassName());
    }

    /**
     * Activates look-and-feel
     * @param landf - name of a Look and Feel
     */
    private void setLAndF(String landf) {
	try {
	    UIManager.setLookAndFeel(landf);
	} catch (Exception exception) {
	    JOptionPane.showMessageDialog(parent,
					  "The look-and-feel "+landf+"is not valid.",
					  "Error",
					  JOptionPane.ERROR_MESSAGE);
	}
	SwingUtilities.updateComponentTreeUI(parent);
    }

}


