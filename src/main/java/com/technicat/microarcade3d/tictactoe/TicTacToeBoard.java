package com.technicat.microarcade3d.tictactoe;

import com.technicat.microarcade.*;
import com.technicat.boardgame.*;
import com.technicat.tictactoe.*;

import javax.microedition.lcdui.*;

/**
 * Basic display of a board
 * Copyright (c) 2005 Technicat, LLC
 */
public class TicTacToeBoard extends BoardCanvas {

    public TicTacToeBoard(BoardGame game) {
	super(game);
    }

    protected void drawBoard(Graphics g) {
	g.setColor(20,248,20);
	super.drawBoard(g);
    }

    /**
     *
     */
    protected void drawPiece(Graphics graphics,
			     int square,
			     int piece) {
	graphics.setColor(248,248,248);
	if (piece == TicTacToe.O) {
	    graphics.drawArc(getPieceOriginX(square),getPieceOriginY(square),
			     getPieceSize(),getPieceSize(),
			     0,360);
	} else if (piece == TicTacToe.X) {
	    int x = getPieceOriginX(square);
	    int y = getPieceOriginY(square);
	    graphics.drawLine(x,y,x+getPieceSize(),y+getPieceSize());
	    graphics.drawLine(x+getPieceSize(),y,x,y+getPieceSize());
	}
    }

}
