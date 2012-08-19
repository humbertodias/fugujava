package com.technicat.boardgame;

import com.technicat.games.*;

import java.util.*;

/**
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class BoardPlayer extends Player {

    /**
     *
     */
    private int side;

    private long gameTime;

    private long lastTime;

    private boolean timerOn;

    /**
     * History of moves
     */
    private Vector moves;

    public BoardPlayer(String name, BoardGame game, int piece) {
	super(name,game);
	this.side = piece;
	gameTime = 0;
	moves = new Vector();
    }

    final public int getSide() {
	return side;
    }

    final public long getTime() {
	return gameTime;
    }
    
    /**
     * Add move to history
     */
    public void addMove(Move move) {
	moves.addElement(move);
    }

    /**
     *
     */
    public Move getMove(int index) {
	if (index<moves.size()) {
	    return (Move)moves.elementAt(index);
	} else {
	    return null;
	}
    }

    public void startTimer() {
	lastTime = System.currentTimeMillis();
	timerOn = true;
    }

    public void stopTimer() {
	updateTime();
	timerOn = false;
    }

    /**
     * Update time total for player
     */
    public void updateTime() {
	if (timerOn) {
	    long time = System.currentTimeMillis();
	    gameTime += time-lastTime;
	    lastTime = time;
	}
    }

}
