package com.technicat.arcade.gomoku;

import com.technicat.gomoku.*;
import com.technicat.boardgame.*;
import com.technicat.arcade.*;

import javax.swing.*;

/**
 * copyright 2005-2006 Technicat, LLC
 * @author Phil Chu
 */
public class GomokuMediumCommand extends GomokuPlayerCommand {

    public GomokuMediumCommand(JDesktopPane desktop) {
	super("Medium",desktop);
    }

    protected BoardPlayer getPlayer1() {
	GomokuFrame frame = (GomokuFrame)getApplication();
	return new MinMaxPlayer("White",(Gomoku)frame.getGame(),
				   BoardGame.PLAYER1,3);
    }

}

