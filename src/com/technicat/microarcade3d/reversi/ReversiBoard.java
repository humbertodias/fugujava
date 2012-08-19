package com.technicat.microarcade.reversi;

import com.technicat.microarcade.*;
import com.technicat.boardgame.*;
import com.technicat.reversi.*;

import javax.microedition.lcdui.*;

/**
 * Basic display of a board
 * Copyright (c) 2005 Technicat, LLC
 */
public class ReversiBoard extends BoardCanvas {

    public ReversiBoard(BoardGame game) {
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
	if (piece == Reversi.BLACK) {
	    graphics.setColor(0,0,0);
	} else {
	    graphics.setColor(255,255,255);
	}
	graphics.fillArc(getPieceOriginX(square),getPieceOriginY(square),
			 getPieceSize(),getPieceSize(),
			 0,360);
    }

}
