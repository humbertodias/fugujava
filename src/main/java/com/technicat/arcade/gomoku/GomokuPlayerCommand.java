package com.technicat.arcade.gomoku;

import com.technicat.boardgame.*;
import com.technicat.arcade.*;

import javax.swing.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
abstract public class GomokuPlayerCommand extends NewGameCommand {

    public GomokuPlayerCommand(String name,JDesktopPane desktop) {
	super(com.technicat.arcade.gomoku.GomokuFrame.class,
	      name,desktop);
    }

    protected BoardPlayer getPlayer0() {
	GomokuFrame frame = (GomokuFrame)getApplication();
	return new MousePlayer("X",frame,BoardGame.PLAYER0);
    }

}

