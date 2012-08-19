package com.technicat.arcade;

import com.technicat.swing.*;
import com.technicat.boardgame.*;
import com.technicat.automata.*;

import java.awt.*;
import java.util.*;

/**
 * Basic implementation of a user interface for a board game.
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
abstract public class BoardGameFrame extends Application
    implements StateListener
 {

    /**
     * game object
     */
    private BoardGame game;

    /**
     * board display
     */
    private BoardComponent board;

    /**
     *
     */
    public BoardGameFrame(BoardGame game) {
	super();
	//
	this.game = game;
	// initialize game
	game.reset();
	board = createBoard(game);
	game.addStateListener(this);
    }

     private Timer timer;

    public void start() {
	Thread thread = new Thread(game);
	thread.setPriority(Thread.MAX_PRIORITY);
	thread.start();
	timer = new Timer();
	timer.scheduleAtFixedRate(new PlayerTimeTask(),0,1000);
    }

    public BoardGame getGame() {
	return game;
    }

    public BoardComponent getBoard() {
	return board;
    }

    private class PlayerTimeTask extends TimerTask {

	public PlayerTimeTask() {
	    super();
	}

	public void run() {
	    if (game.getState() == game.STATE_THINKING) {
		Enumeration en = game.getPlayerIterator();
		String buffer = "";
		while (en.hasMoreElements()) {
		    BoardPlayer player = (BoardPlayer)en.nextElement();
		    player.updateTime();
		    buffer += " ";
		    buffer += player.getName();
		    buffer += " ";
		    long ms = player.getTime();
		    long secs = ms/1000;
		    long minutes = secs/60;
		    buffer += minutes + ":" + secs;
		}
		showStatus(buffer);
	    }
	}
    }
    
    public void stateChanged(State state) {
	if (state == game.STATE_GAME_OVER) {
	    timer.cancel();
	    //showStatus("Game Over");
	    showMessage(game.getGameOverMessage());
	}
	//	else if (state == game.STATE_THINKING) {
	//	    showStatus(game.getCurrentPlayer().getName()+" to move...");
	//	}
	}

    public void setContainer(ApplicationContainer container) {
	super.setContainer(container);
	getRootPane().getContentPane().setLayout(new BorderLayout());
	getRootPane().getContentPane().add(board,BorderLayout.CENTER);
    }

    /**
     * Get the name from the game object
     */
    public String getName() {
	return game.getName();
    }

    /**
     * @param game
     * @return appropriate BoardComponent for this game
     */
    abstract protected BoardComponent createBoard(BoardGame game);

    /**
     * Create actions for board games.
     */
    protected void createActions() {
	super.createActions();
	setNewAction(new NewAction() { public void action() { game.reset(); }});
    }

}
