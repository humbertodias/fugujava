package com.technicat.microarcade;

import com.technicat.boardgame.*;
import com.technicat.automata.*;

import javax.microedition.lcdui.*;

import java.util.*;

/**
 * Copyright (c) 2005 Technicat, LLC
 * @author Phil Chu
 */
public class HumanPlayer extends BoardPlayer implements StateListener, ActionListener {

    private BoardGameMidlet frame;

    private MoveIterator it;

    /**
     * Available moves
     */
    private Vector moves;

    /**
     * Currently-selected move
     */
    private int moveIndex;

    public HumanPlayer(String name,BoardGameMidlet frame,int side) {
	super(name,frame.getGame(),side);
	this.frame = frame;
	BoardGame game = (BoardGame)getGame();
	game.addStateListener(this);
	frame.getBoard().addActionListener(this);
	it = new MoveIterator(game);
	moves = new Vector(game.getBoard().size);
	moveIndex=-1;
    }

    public void stateChanged(State state) {
	BoardGame game = (BoardGame)getGame();
	if ((state == game.STATE_THINKING) &&
	    (game.getCurrentPlayer() == this)) {
	    it.reset(this,game.getBoard());
	    while (it.hasMoreElements()) {
		moves.addElement(it.nextElement());
	    }
	    if (isMoveAvailable()) {
		setCursor(0);
	    }
	}
    }

    private void setCursor(int index) {
	moveIndex = index;
	if (isMoveSelected()) {
	    frame.getBoard().setHighlight(getSelectedMove().square);
	} else {
	    frame.getBoard().clearHighlight();
	}
	//?
	//	frame.getBoard().repaint();
	frame.getBoard().boardChanged();
    }

    private Move getSelectedMove() {
	if (isMoveSelected()) {
	    return (Move)moves.elementAt(moveIndex);
	} else {
	    return null;
	}
    }
	
    private boolean isMoveSelected() {
	return moveIndex>=0;
    }

    private boolean isMoveAvailable() {
	return moves.size()>0;
    }

    private void moveCursor(int inc) {
	if (isMoveSelected()) {
	    int newIndex = moveIndex+inc;
	    if (newIndex>=moves.size()) {
		newIndex = 0;
	    }
	    if (newIndex<0) {
		newIndex = moves.size()-1;
	    }
	    setCursor(newIndex);
	}
    }

    public void gameAction(int action) {
	BoardGame game = (BoardGame)getGame();
	if ((game.getCurrentPlayer()==this) &&
	    (game.getState() == game.STATE_THINKING) &&
	    (getSelectedMove()!=null)) {
	    switch (action) {
	    case Canvas.FIRE:
		game.queueMove(getSelectedMove());
		moves.removeAllElements();
		break;
	    case Canvas.LEFT:
	    case Canvas.UP:
		moveCursor(-1);
		break;
	    case Canvas.DOWN:
	    case Canvas.RIGHT:
		moveCursor(1);
		break;
	    }
	}
    }

}
