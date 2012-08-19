package com.technicat.boardgame;

/**
 * A board game move.
 * copyright 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class Move {

    final public int piece;

    final public int square;

    public Move(int square,int piece) {
	super();
	this.piece = piece;
	this.square = square;
    }

}
