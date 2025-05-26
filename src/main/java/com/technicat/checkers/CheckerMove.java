package com.technicat.checkers;

import com.technicat.boardgame.*;

/**
 * A Checkers move
 * copyright 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class CheckerMove extends Move {

    final private int fromSquare;

    public CheckerMove(int from, int square, int piece) {
	super(square,piece);
	this.fromSquare = from;
    }

    public int getFrom() {
	return fromSquare;
    }
}
