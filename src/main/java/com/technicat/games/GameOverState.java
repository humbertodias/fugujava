package com.technicat.games;

import com.technicat.automata.State;

public class GameOverState extends GameState {

    public GameOverState(Game game) {
	super(game);
    }
	
    public State getNextState() {
	return null;
    }

}
