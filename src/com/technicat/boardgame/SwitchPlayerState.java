package com.technicat.boardgame;

import com.technicat.games.*;
import com.technicat.automata.*;

final public class SwitchPlayerState extends GameState {
	
    public SwitchPlayerState(Game game) {
	super(game);
    }

    public void init() {
	BoardGame game = (BoardGame)getGame();
	game.switchPlayer();
    }

    /**
     * @return STATE_THINKING
     */
    public State getNextState() {
	BoardGame game = (BoardGame)getGame();
	return game.STATE_THINKING;
    }

}
