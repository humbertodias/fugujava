package com.technicat.arcade.gomoku;

import com.technicat.gomoku.*;
import com.technicat.boardgame.*;
import com.technicat.arcade.*;

import javax.swing.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
public class GomokuEasyCommand extends GomokuPlayerCommand {

    public GomokuEasyCommand(JDesktopPane desktop) {
	super("Easy",desktop);
    }

    protected BoardPlayer getPlayer1() {
	GomokuFrame frame = (GomokuFrame)getApplication();
	return new MinMaxPlayer("White",(Gomoku)frame.getGame(),
				   BoardGame.PLAYER1,0);
    }

}

