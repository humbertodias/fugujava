package com.technicat.swing;

import javax.swing.*;

/**
 * The Swing Container around an Application
 * @author Phil Chu
 */
public interface ApplicationContainer {

    /**
     *
     */
    public void showStatus(String string);

    public void setJMenuBar(JMenuBar bar);
}