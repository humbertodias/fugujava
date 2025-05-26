package com.technicat.arcade;

import com.technicat.boardgame.*;
import com.technicat.reversi.*;
import com.technicat.arcade.*;

import java.awt.*;
import java.awt.geom.*;


/**
 * Board display with black and white pieces
 * Copyright (c) 2005 Technicat, LLC
 */
abstract public class BlackWhiteBoard extends BoardComponent {

    /**
     *
     */
    public BlackWhiteBoard(BoardGame game) {
	super(game);
    }

    /**
     *
     */
    protected void drawPiece(Graphics2D graphics, Point2D point,int piece) {
	super.drawPiece(graphics,point,piece);
	graphics.setColor(Color.black);
	Shape disc = getCircularPiece(point);
	graphics.draw(disc);
	switch (piece) {
	case Reversi.BLACK:
	    graphics.setColor(Color.black);
	    break;
	case Reversi.WHITE:
	    graphics.setColor(Color.white);
	}
	graphics.fill(disc);
    }

}
