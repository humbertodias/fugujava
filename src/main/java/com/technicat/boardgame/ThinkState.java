package com.technicat.boardgame;

import com.technicat.games.*;
import com.technicat.automata.*;

public class ThinkState extends GameState {
	
	public ThinkState(Game game) {
		super(game);
	}

	public State getNextState() {
	    BoardGame game = (BoardGame)getGame();
	if (game.isGameOver()) {
	    return game.STATE_GAME_OVER;
	} else {
	    if (game.peekPendingMove()!=null) { 
		return game.STATE_MOVING; 
	    } else {
		// reversi-specific
		if (!game.hasMove()) {
		    return game.STATE_SWITCH_PLAYER;
		} else {
		    return null;
		}
	    }
	}
	}
}
