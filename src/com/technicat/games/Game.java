package com.technicat.games;

import com.technicat.automata.*;

import java.util.*;

/**
 * Basic implementation of a board game.
 * Todo - implement Game interface
 * Copyright (c) 2004-2005 Technicat, LLC
 */
abstract public class Game extends FiniteStateMachine {

    public State STATE_GAME_OVER;
    
    /**
     * list of players
     */
    private Vector players = new Vector();

    public Game() {
    		super();
    		STATE_GAME_OVER = new GameOverState(this);
    }

    public State getStopState() {
    		return STATE_GAME_OVER;
    }

    /**
     * game name
     */
    abstract public String getName();

    /**
     * @return null if no winner
     */
    public Player getWinner() {
	for (int i=0; i<players.size(); ++i) {
	    Player player = (Player)players.elementAt(i);
	    if (isWinner(player)) {
		return player;
	    }
	}
	return null;
    }


    abstract public boolean isWinner(Player player);

    /**
     *
     */
    public int getMaxPlayers() {
	return players.size();
    }

    public void addPlayer(Player player) {
	players.addElement(player);
    }

    /**
     * @return player with index
     */
    public Player getPlayer(int index) {
	return (Player)players.elementAt(index);
    }

    public int getPlayerIndex(Player player) {
	return players.indexOf(player);
    }

    public Player getNextPlayer(Player player) {
	int index = getPlayerIndex(player);
	if (++index == getMaxPlayers()) {
	    index = 0;
	}
	return getPlayer(index);
    }

    public Enumeration getPlayerIterator() {
	return players.elements();
    }

    abstract public boolean isGameOver();

    public String getGameOverMessage() {
	String message;
	Player winner = getWinner();
	if (winner != null) {
	    message = winner.getName() + " wins";
	} else {
	    message = "Tie Game";
	}
	return message;
    }
    
}
