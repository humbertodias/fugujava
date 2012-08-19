package com.technicat.boardgame;

import com.technicat.games.*;
import com.technicat.automata.*;

import java.util.*;

/**
 * Basic implementation of a two-player board game.
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class GridBoard extends Board {

    final public int width,height;

    final public static int EAST = 1;
    final public static int WEST = 2;
    final public static int SOUTH = 4;
    final public static int NORTH = 8;
    final public static int NORTHWEST = NORTH | WEST;
    final public static int NORTHEAST = NORTH | EAST;
    final public static int SOUTHWEST = SOUTH | WEST;
    final public static int SOUTHEAST = SOUTH | EAST;

    /**
     *
     */
    public GridBoard(final int width, final int height) {
	super(width*height);
	this.width = width;
	this.height = height;
    }

    final public int getSquare(final int x, final int y) {
	return y*width+x;
    }

    final public int getNeighbor(final int square, final int direction) {
	int x = 0;
	int y = 0;
	if ((direction & EAST)!=0) {
	    x=1;
	}
	if ((direction & WEST)!=0) {
	    x=-1;
	}
	if ((direction & NORTH)!=0) {
	    y=-1;
	}
	if ((direction & SOUTH)!=0) {
	    y=1;
	}
	return getNeighbor(square,x,y);
    }

    final public int getSquareX(final int square) {
	return square-getSquareY(square)*width;
    }

    final public int getSquareY(final int square) {
	return square/width;
    }

    /**
     * @param x
     * @param y
     * @return neighboring Square (no guarantees on valid coordinates)
     */
    final public int getNeighbor(final int square, final int x, final int y) {
	int newy = getSquareY(square)+y;
	int newx = getSquareX(square)+x;
	if ( newx>=0 && newx<width && newy>=0 && newy<height) {
	    return getSquare(newx,newy);
	} else {
	    return OFFBOARD;
	}
    }

    /**
     * @return neighboring Square (no guarantees on valid coordinates)
     */
    final public int getNeighborSouth(final int square) {
	int newy = getSquareY(square)+1;
	if ( newy<height) {
	    return getSquare(getSquareX(square),newy);
	} else {
	    return OFFBOARD;
	}
    }

}
