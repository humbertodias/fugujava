package com.technicat.gomoku;

import com.technicat.boardgame.*;

/**
 * Copyright (c) 2005 Technicat, LLC
 * @author Phil Chu
 */
final public class Gomoku extends BoardGame {

    final static public int BLACK = PLAYER0;
    final static public int WHITE = PLAYER1;

    public Gomoku() {
	super();
    }

    public Board createBoard() {
	return new RowGameBoard(getWidth(),getHeight());
    }

    public boolean isWon(BoardPlayer player,Board board) {
	return ((RowGameBoard)board).hasRow(player.getSide(),5);
    }


    public int getWidth() {
	return 19;
    }

    public int getHeight() {
	return 19;
    }

    public String getName() {
	return "Gomoku";
    }

}
