package com.technicat.boardgame;

import com.technicat.games.*;
import com.technicat.automata.*;

import java.util.*;

/**
 * Basic implementation of a two-player board game.
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class RowGameBoard extends GridBoard {

    /**
     *
     */
    public RowGameBoard(int width,int height) {
	super(width,height);
    }

    final public boolean hasRow(final int piece, final int length) {
	final int end = size-length;
	for (int i=0; i<end; ++i) {
	    if (inRow(i,piece,length)) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Assumes left-to-right, top-down iteration
     */
    final private boolean inRow(final int square, final int piece, final int length) {
	/*	return (inRowEast(square, piece, length) ||
		inRowSouth(square, piece, length) ||
		inRowSoutheast(square, piece, length) ||
		inRowSouthwest(square, piece, length)
		);*/
	return (inRow(square, piece, length, GridBoard.EAST) ||
		inRow(square, piece, length, GridBoard.SOUTH) ||
		inRow(square, piece, length, GridBoard.SOUTHEAST) ||
		inRow(square, piece, length, GridBoard.SOUTHWEST)
		);
    }

    final private boolean inRow(int square, final int piece,  int length, final int direction) {

	while (length-- > 0) {
	    if (square <0 || getPiece(square) != piece) {
		return false;
	    } else {
		square = getNeighbor(square,direction);
	    }
	}
	return true;
	}


    final private boolean inRowEast(int square, final int piece, int length) {

	while (length-- > 0) {
	    if (square == OFFBOARD || !isPiece(square,piece)) {
		return false;
	    } else {
		square = getNeighbor(square,EAST);
	    }
	}
	return true;
    }

    final private boolean inRowSouth( int square, final int piece, int length) {

	while ((length-- > 0) && (square != OFFBOARD) && isPiece(square,piece)) {
	    square = getNeighborSouth(square);
    }
	return length==0;
    }

    final private boolean inRowSoutheast(int square, final int piece, int length) {

	while (length-- > 0) {
	    if (square == OFFBOARD || getPiece(square) != piece) {
		return false;
	    } else {
		square = getNeighbor(square,SOUTHEAST);
	    }
	}
	return true;
    }

    final private boolean inRowSouthwest(int square, final int piece, int length) {

	while (length-- > 0) {
	    if (square == OFFBOARD || getPiece(square) != piece) {
		return false;
	    } else {
		square =  getNeighbor(square,SOUTHWEST);
	    }
	}
	return true;
    }

}
