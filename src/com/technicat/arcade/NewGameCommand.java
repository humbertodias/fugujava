package com.technicat.arcade;

import com.technicat.boardgame.*;
import com.technicat.desktopinternal.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
abstract public class NewGameCommand extends NewFrameCommand {

    public NewGameCommand(Class cl,String name,
			   JDesktopPane desktop) {
	super(cl,name,desktop);
    }

    abstract protected BoardPlayer getPlayer0();
    abstract protected BoardPlayer getPlayer1();

    public void actionPerformed(ActionEvent event) {
	super.actionPerformed(event);
	BoardPlayer p0 = getPlayer0();
	BoardPlayer p1 = getPlayer1();
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	frame.getGame().addPlayer(p0);
	frame.getGame().addPlayer(p1);
	frame.getGame().setCurrentPlayer(p0);
	frame.start();
    }
}

