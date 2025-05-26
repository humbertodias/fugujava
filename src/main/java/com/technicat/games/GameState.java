package com.technicat.games;

import com.technicat.automata.State;

abstract public class GameState implements State {
	
    private Game game;
	
    public GameState(Game game) {
	super();
	this.game = game;
    }
	
    public Game getGame() {
	return game;
    }

    public void init() {};
    
    public void cleanup() {};

}
