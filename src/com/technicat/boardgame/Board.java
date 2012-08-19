package com.technicat.boardgame;

import com.technicat.games.*;
import com.technicat.automata.*;

import java.util.*;

/**
 * Basic implementation of a two-player board game.
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class Board {

    // pieces
    final public static int BLANK=0;

    final public static int OFFBOARD = -1;

    /**
     * The current state of the game board.
     */
    final public int[] gameBoard;

    final public int size;

    /**
     *
     */
    public Board(final int size) {
	super();
	this.size = size;
	gameBoard = new int[size];
    }

    final public void setPiece(final int square,int val) {
	gameBoard[square]=val;
    }

    final public int getPiece(final int square) {
	return gameBoard[square];
    }

    final boolean isPiece(final int square, final int piece) {
	return gameBoard[square] == piece;
    }

    synchronized final public void copyBoard(Board board) {
	System.arraycopy(gameBoard,0,board.gameBoard,0,size);
	/* for (int i=0; i<size; ++i) {
	    board.setPiece(i,getPiece(i));
	    } */
    }

    /**
     * @return whether square on the game board is empty
     */
    final public boolean isEmpty(final int i) {
	return (gameBoard[i]==BLANK);
    }

    final public boolean isSquare(final int i) {
	return i>=0;
    }

    /**
     * Set initial board configuration
     */
    synchronized public void reset() {
	for (int i=0; i<size; ++i) {
	    gameBoard[i]=BLANK;
	}
    }
}
