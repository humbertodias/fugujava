package com.technicat.microarcade2;

import com.technicat.games.*;
import com.technicat.boardgame.*;
import com.technicat.automata.*;
import com.technicat.microarcade.*;

import java.util.*;

import javax.microedition.lcdui.game.*;
import javax.microedition.lcdui.*;

/**
 * Basic display of a board
 * Copyright (c) 2005 Technicat, LLC
 */
abstract public class BoardGameCanvas extends GameCanvas
    implements BoardDisplay {

    private BoardGame game;

    private int cursor;

    private Vector actionListeners;

    private TiledLayer boardLayer;

    /**
     * 
     */
    private int highlightSquare;

    protected Image createImage() { return null; }

    protected int getTileWidth() { return 20; }
    protected int getTileHeight() { return 20; }

    public BoardGameCanvas(BoardGame game) {
	super(true);
	this.game = game;
	boardLayer = new TiledLayer(((GridBoard)game.getBoard()).width,
				    ((GridBoard)game.getBoard()).height,
				    createImage(),
				    getTileWidth(),getTileHeight());
	game.addBoardListener(this);
	game.addStateListener(this);
	actionListeners = new Vector(2);
	clearHighlight();
    }

    public void setHighlight(int square) {
	highlightSquare = square;
    }

    public void clearHighlight() {
	highlightSquare = -1;
    }


    public void addActionListener(ActionListener listener) {
	actionListeners.addElement(listener);
    }

    protected void keyPressed(int keycode) {
	int action = getGameAction(keycode);
	for (int i=0; i<actionListeners.size(); ++i) {
	    ActionListener listener = (ActionListener)actionListeners.elementAt(i);
	    listener.gameAction(action);
	}
    }


    /**
    /**
     * respond to game state changes
     */
    public void boardChanged() {
	GridBoard board = (GridBoard)game.getBoard();
       	if (board.isSquare(highlightSquare)) {
	    // drawHighlightSquare(g);
	}
	for (int i=0; i<board.size; ++i) {
	    boardLayer.setCell(board.getSquareX(i), board.getSquareY(i),
			       board.getPiece(i));
	}
	flushGraphics();
    }

    public void stateChanged(State state) {
	if (state == game.STATE_MOVING) {
	    Move move = game.peekPendingMove();
	    highlightSquare = move.square;
	}
	if (state == game.STATE_GAME_OVER) {
	    clearHighlight();
	    cursor = -1;
	}
	flushGraphics();
    }
}
