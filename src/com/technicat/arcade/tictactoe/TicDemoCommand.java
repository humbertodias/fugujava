package com.technicat.arcade.tictactoe;

import com.technicat.boardgame.*;
import com.technicat.arcade.*;

import javax.swing.*;

/**
 * Demo mode - computer vs. computer
 * Copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
public class TicDemoCommand extends TicTacToeGameCommand {

    public TicDemoCommand(JDesktopPane desktop) {
	super("Demo",desktop);
    }

    protected BoardPlayer getPlayer0() {
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	return new MinMaxPlayer("X",(BoardGame)frame.getGame(),
				   BoardGame.PLAYER0,3);
    }

    protected BoardPlayer getPlayer1() {
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	return new MinMaxPlayer("O",(BoardGame)frame.getGame(),
				   BoardGame.PLAYER1,9);
    }

}

