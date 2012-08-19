package com.technicat.boardgame;

import com.technicat.games.*;
import com.technicat.automata.*;

final public class MoveState extends GameState {

    public MoveState(Game game) {
	super(game);
    }
	
    public State getNextState() { 
	BoardGame game = (BoardGame)getGame();
	return game.STATE_SWITCH_PLAYER;
    }
	
    public void init() {
	BoardGame game = (BoardGame)getGame();
	game.makeMove(game.peekPendingMove());
    }

    public void cleanup() {
	BoardGame game = (BoardGame)getGame();
	game.getPendingMove();
    }
}
