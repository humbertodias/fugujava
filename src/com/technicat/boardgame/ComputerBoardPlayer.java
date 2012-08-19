package com.technicat.boardgame;

import com.technicat.automata.*;

/**
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
abstract public class ComputerBoardPlayer extends BoardPlayer
    implements StateListener {

    public ComputerBoardPlayer(String name,
			       BoardGame game, 
			       int side) {
	super(name,game,side);
	game.addStateListener(this);
    }

    abstract public Move getBestMove();

    public void stateChanged(State state) {
	BoardGame game = (BoardGame)getGame();
	if ((state == game.STATE_THINKING) &&
	    (game.getCurrentPlayer() == this)) {
	    startTimer();
	    Move move = getBestMove();
	    stopTimer();
	    if (move != null) {
		game.queueMove(move);
	    }
	}
    }

}
