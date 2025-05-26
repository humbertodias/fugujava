package com.technicat.arcade.gomoku;

import com.technicat.gomoku.*;
import com.technicat.boardgame.*;
import com.technicat.arcade.*;

import javax.swing.*;

/**
 * copyright 2005-2006 Technicat, LLC
 * @author Phil Chu
 */
public class GomokuDemoCommand extends GomokuPlayerCommand {

    public GomokuDemoCommand(JDesktopPane desktop) {
	super("Demo",desktop);
    }

    protected BoardPlayer getPlayer0() {
	GomokuFrame frame = (GomokuFrame)getApplication();
	return new MinMaxPlayer("Black",(Gomoku)frame.getGame(),
				   BoardGame.PLAYER0,1);
    }

    protected BoardPlayer getPlayer1() {
	GomokuFrame frame = (GomokuFrame)getApplication();
	return new MinMaxPlayer("White",(Gomoku)frame.getGame(),
				   BoardGame.PLAYER1,3);
    }

}

