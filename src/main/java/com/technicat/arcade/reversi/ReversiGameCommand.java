package com.technicat.arcade.reversi;

import com.technicat.boardgame.*;
import com.technicat.arcade.*;

import javax.swing.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
abstract public class ReversiGameCommand extends NewGameCommand {

    public ReversiGameCommand(String name,JDesktopPane desktop) {
	super(com.technicat.arcade.reversi.ReversiFrame.class,name,desktop);
    }

    protected BoardPlayer getPlayer0() {
	ReversiFrame frame = (ReversiFrame)getApplication();
	return new MousePlayer("Black",frame,
			       BoardGame.PLAYER0);
    }

}

