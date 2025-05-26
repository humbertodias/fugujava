package com.technicat.arcade.reversi;

import com.technicat.reversi.*;
import com.technicat.boardgame.*;

import javax.swing.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
public class ReversiGoodCommand extends ReversiGameCommand {

    public ReversiGoodCommand(JDesktopPane desktop) {
	super("Good",desktop);
    }

    protected BoardPlayer getPlayer1() {
	ReversiFrame frame = (ReversiFrame)getApplication();
	return new ReversiPlayer("White",(Reversi)frame.getGame(),
				Reversi.PLAYER1,5);
    }

}

