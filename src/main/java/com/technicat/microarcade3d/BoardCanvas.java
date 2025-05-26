package com.technicat.microarcade3d;

import com.technicat.games.*;
import com.technicat.boardgame.*;
import com.technicat.automata.*;

import java.util.*;

import javax.microedition.lcdui.*;

/**
 * Basic display of a board
 * Copyright (c) 2005 Technicat, LLC
 */
abstract public class BoardCanvas extends Canvas
    implements BoardListener, 
	       StateListener {

    private BoardGame game;

    private int cursor;

    private Vector actionListeners;

    /**
     * 
     */
    private int highlightSquare;

    public BoardCanvas(BoardGame game) {
	super();
	this.game = game;
	game.addBoardListener(this);
	game.addStateListener(this);
	actionListeners = new Vector(2);
	clearHighlight();
    }

    protected void drawBoard(Graphics g) {
	GridBoard board = (GridBoard)game.getBoard();
	g.fillRect(0,0,
		   board.width*getSquareSize(),
		   board.height*getSquareSize());
    }

    protected int getPieceOriginX(int square) {
	GridBoard board = (GridBoard)game.getBoard();
	int offset = (getSquareSize()-getPieceSize())/2;
	return board.getSquareX(square)*getSquareSize()+offset;
    }

    protected int getPieceOriginY(int square) {
	GridBoard board = (GridBoard)game.getBoard();
	int offset = (getSquareSize()-getPieceSize())/2;
	return board.getSquareY(square)*getSquareSize()+offset;
    }

    protected int getPieceSize() {
	return getSquareSize()-4;
    }
	

    protected int getSquareSize() {
	return getWidth()/((GridBoard)game.getBoard()).width;
    }

    public void setHighlight(int square) {
	highlightSquare = square;
    }

    public void clearHighlight() {
	highlightSquare = -1;
    }

    protected void paint(Graphics g) {
	Board board = game.getBoard();
	drawBoard(g);
	if (board.isSquare(highlightSquare)) {
	    drawHighlightSquare(g);
	}
	for (int i=0; i<board.size; ++i) {
	    if (!game.getBoard().isEmpty(i)) {
		drawPiece(g,i,
			  board.getPiece(i));
	    }
	}
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
     *
     */
    abstract protected void drawPiece(Graphics graphics,
				      int square,
				      int piece);

    protected void drawHighlightSquare(Graphics g) {
	GridBoard board = (GridBoard)game.getBoard();
	if (board.isSquare(highlightSquare)) {
	    int squareSize = getSquareSize();
	    g.setColor(0,0,0);
	    g.drawRect(board.getSquareX(highlightSquare)*squareSize,
		       board.getSquareY(highlightSquare)*squareSize,
		       squareSize,squareSize);
	}
    }

    /**
     * respond to game state changes
     */
    public void boardChanged() {
	repaint();
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
	repaint();
    }
}
