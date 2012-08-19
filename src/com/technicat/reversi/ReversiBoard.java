package com.technicat.reversi;

import com.technicat.boardgame.*;

/**
 * Reversi
 * Copyright (c) 2004-2005 Technicat, LLC
 */
public class ReversiBoard extends GridBoard {

/**
     *
     */
    public ReversiBoard() {
	super(8,8);
    }

    /** 
     * @return number of pieces more than opponent
     */
    public int getScore(int piece) {
	int score = 0;
	for (int i=0; i<size; ++i) {
	    if (!isEmpty(i)) {
		if (piece == getPiece(i)) {
		    ++score;
		} else {
		    --score;
		}
	    }
	}
	return score;
    }

    /** 
     * @return number of pieces more than opponent
     */
    public int getTotal(int piece) {
	int score = 0;
	for (int i=0; i<size; ++i) {
	    if (!isEmpty(i)) {
		if (piece == getPiece(i)) {
		    ++score;
		}
	    }
	}
	return score;
    }

    /**
     * Reset game board to initial state.
     * For Reversi, all squares are empty except
     * the center four.
     */
    public void reset() {
	super.reset();
	setPiece(getSquare(3,3),Reversi.BLACK);
	setPiece(getSquare(4,4),Reversi.BLACK);
	setPiece(getSquare(3,4),Reversi.WHITE);
	setPiece(getSquare(4,3),Reversi.WHITE);
    }

    final public boolean hasFlips(Move move) {
	return flipStart(move,EAST) || 
	    flipStart(move,NORTH) || 
	    flipStart(move,SOUTH) || 
	    flipStart(move,WEST) || 
	    flipStart(move,NORTHEAST) || 
	    flipStart(move,NORTHWEST) || 
	    flipStart(move,SOUTHEAST) || 
	    flipStart(move,SOUTHWEST);
    }

    final public void makeFlips(Move move) {
	flipPiecesStart(move,EAST);
	flipPiecesStart(move,NORTH);
	flipPiecesStart(move,SOUTH);
	flipPiecesStart(move,WEST);
	flipPiecesStart(move,NORTHEAST);
	flipPiecesStart(move,NORTHWEST);
	flipPiecesStart(move,SOUTHEAST);
	flipPiecesStart(move,SOUTHWEST);
    }

    /**
     * flip pieces in one direction, if possible
     * @param move
     * @param direction
     */
    final private void flipPiecesStart(Move move,int direction) {
	if (flipStart(move,direction)) {
	    flipPieces(move,direction);
	}
    }

    final private int getOtherPiece(int piece) {
	if (piece == Reversi.BLACK) {
	    return Reversi.WHITE;
	} else {
	    return Reversi.BLACK;
	}
    }

    /**
     * test whether pieces can be flipped in a certain directino
     * @param move
     * @param direction
     */
    final private boolean flipStart(Move move,int direction) {
	int next = getNeighbor(move.square,direction);
	    // if we fall off the board, no flip
	if (next < 0) {
	    return false;
	    // if square is occupied by other sie
	    // keep going
	} else if (getPiece(next)==getOtherPiece(move.piece)) {
	    return isFlippable(move,direction);
	    // false otherwise (empty or current side)
	} else return false;
    }

    /**
     * @param direction
     */
    final private boolean isFlippable(Move move,
				int direction) {
	int square = getNeighbor(move.square,direction);
	while (square >= 0 && !isEmpty(square)) {
	    if (getPiece(square)==move.piece) {
		return true;
	    } else {
		square = getNeighbor(square,direction);
	    }
	}
	return false;
    }

    /**
     * @param direction
     */
    final private boolean getFlippable(Move move,
				 int direction) {
	int square = getNeighbor(move.square,direction);
	while (square >=0 && !isEmpty(square)) {
	    if (getPiece(square)==move.piece) {
		return true;
	    } else {
		//		flipped.push(square);
		square = getNeighbor(square,direction);
	    }
	}
	return false;
    }


    /**
     * flip pieces in a certain direction
     * @param direction
     */
    final private void flipPieces(Move move,
			    int direction) {
	int square = getNeighbor(move.square,direction);
	while (getPiece(square)!=move.piece) {
	    setPiece(square,move.piece);
	    square = getNeighbor(square,direction);
	}
    }

}
