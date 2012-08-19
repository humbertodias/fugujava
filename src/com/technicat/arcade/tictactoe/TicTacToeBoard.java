package com.technicat.arcade.tictactoe;

import com.technicat.boardgame.*;
import com.technicat.tictactoe.*;
import com.technicat.arcade.*;

import java.awt.*;
import java.awt.geom.*;


/**
 * Basic display of a board
 * Copyright (c) 2005 Technicat, LLC
 */
class TicTacToeBoard extends BoardComponent {

    public TicTacToeBoard(BoardGame game) {
	super(game);
    }

    protected int getPieceSize() {
	return 75;
    }

    protected void drawPiece(Graphics2D graphics,Point2D loc,int piece) {
	super.drawPiece(graphics,loc,piece);
	graphics.setColor(Color.black);
	switch (piece) {
	case TicTacToe.X:
	    Line2D line = new Line2D.Double(loc,
					    new Point2D.Double(loc.getX()+getPieceSize(),
							       loc.getY()+getPieceSize()));
	    graphics.draw(line);
	    line.setLine(new Point2D.Double(loc.getX(), loc.getY()+getPieceSize()),
				     new Point2D.Double(loc.getX()+getPieceSize(),
							loc.getY()));
	    graphics.draw(line);
	    break;
	case TicTacToe.O:
	    Shape disc = getCircularPiece(loc);
	    graphics.draw(disc);
	}
    }

}
