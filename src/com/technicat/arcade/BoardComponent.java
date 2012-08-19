package com.technicat.arcade;

import com.technicat.games.*;
import com.technicat.boardgame.*;
import com.technicat.automata.*;

import javax.swing.*;

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.font.*;

import java.util.*;

/**
 * Basic display of a board
 * Copyright (c) 2005 Technicat, LLC
 */
abstract public class BoardComponent extends JPanel
    implements BoardListener, 
	       StateListener {

    private BoardGame game;

    private Point2D cursor;

    private GridBoard displayBoard;

    /**
     * 
     */
    private int highlightSquare = -1;

    public BoardComponent(BoardGame game) {
	super();
	this.game = game;
	displayBoard = (GridBoard)game.createBoard();
	game.addBoardListener(this);
	game.addStateListener(this);
	setPreferredSize(new Dimension((int)getBoardWidth(),(int)getBoardHeight()));
	setDoubleBuffered(true);
    }

    abstract protected int getPieceSize();

    protected double getSquareSize() {
	return 1.2*getPieceSize();
    }

    public void setHighlight(int square) {
	highlightSquare = square;
    }

    public void setHighlight(MouseEvent event) {
	highlightSquare = getSquare(event);
    }

    public void clearHighlight() {
	highlightSquare = -1;
    }

    synchronized protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2 = (Graphics2D)g;
	if (highlightSquare >= 0) {
	    drawHighlightSquare(g2);
	}
	game.getBoard().copyBoard(displayBoard);
	for (int i=0; i<displayBoard.size; ++i) {
	    if (!displayBoard.isEmpty(i)) {
		drawPiece(g2,getPieceLocation(i),
			  displayBoard.getPiece(i));
	    }
	}
	drawCursor(g2);
    }

    /**
     * @return Shape
     */
    protected Shape getCircularPiece(Point2D loc) {
	return new Ellipse2D.Double(loc.getX(),
				    loc.getY(),
				    getPieceSize(),getPieceSize());
    }

    public double getBoardWidth() {
	return getSquareSize()*displayBoard.width;
    }

    public double getBoardHeight() {
	return getSquareSize()*displayBoard.height;
    }

    /**
     * @return top-left coordinate of square on the game board
     */
    protected Point2D getSquareLocation(int square) {
	return new Point2D.Double(displayBoard.getSquareX(square)*getSquareSize(),
				  displayBoard.getSquareY(square)*getSquareSize());
    }

    protected Point2D getPieceLocation(int square) {
	double pieceOffset = (getSquareSize()-getPieceSize())/2.0;
	Point2D point = getSquareLocation(square);
	point.setLocation(point.getX()+pieceOffset,
		       point.getY()+pieceOffset);
	return point;
    }
    
    /**
     *
     */
    protected void drawPiece(Graphics2D graphics,
			     Point2D loc,
			     int piece) {
	graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			    RenderingHints.VALUE_ANTIALIAS_ON);
	graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION,
			    RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
    }


    /**
   * @return Square on which mouse is pointing
     */
    public int getSquare(MouseEvent event) {
	double squareSize = getSquareSize();
	return displayBoard.getSquare((int)(event.getX()/squareSize),
				      (int)(event.getY()/squareSize));
    }

    public void setDraggedPiece(Point2D point) {
	cursor = point;
    }

    protected void drawCursor() {
	drawCursor((Graphics2D)getGraphics());
    }

    protected void drawCursor(Graphics2D g2) {
	if (cursor != null) {
	    Point2D point = new Point2D.Double(cursor.getX()-getPieceSize()/2,
					       cursor.getY()-getPieceSize()/2);
	    drawPiece(g2,point,game.getCurrentPlayer().getSide());
	}
    }

    protected void drawHighlightSquare(Graphics2D g2) {
	if (highlightSquare >= 0) {
	    float squareSize = (float)getSquareSize();
	    Rectangle2D rect = new Rectangle2D.Float(displayBoard.getSquareX(highlightSquare)*squareSize,
						     displayBoard.getSquareY(highlightSquare)*squareSize,
					       squareSize,squareSize);
	    g2.draw(rect);
	}
    }

    synchronized public void boardChanged() {
	for (int i=0; i<displayBoard.size; ++i) {
	    if (displayBoard.getPiece(i) != game.getBoard().getPiece(i)) {
		drawPiece((Graphics2D)getGraphics(),
			  getPieceLocation(i),
			  game.getBoard().getPiece(i));
		try {
		    Thread.sleep(250);
		} catch (InterruptedException exception)
		    {}
	    }
	}
    }

    public void stateChanged(State state) {
	if (state == game.STATE_MOVING) {
	    Move move = game.peekPendingMove();
	    highlightSquare = move.square;
	}
	if (state == game.STATE_GAME_OVER) {
	    clearHighlight();
	    cursor = null;
	}
    }
}
