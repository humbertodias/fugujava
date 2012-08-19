package com.technicat.arcade.tictactoe;

import com.technicat.arcade.*;
import com.technicat.boardgame.*;
import com.technicat.tictactoe.*;

/**
 * User interface for Tic Tac Toe
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class TicTacToeFrame extends BoardGameFrame {

    /**
     *
     */
    public TicTacToeFrame() {
	super(new TicTacToe());
    }

    /**
     *
     */
    protected BoardComponent createBoard(BoardGame game) {
	return new TicTacToeBoard(game);
    }
}
