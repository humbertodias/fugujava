package com.technicat.arcade;

import com.technicat.boardgame.*;
import com.technicat.automata.*;

import java.awt.event.*;
import java.awt.geom.*;

/**
 * Copyright (c) 2005 Technicat, LLC
 * @author Phil Chu
 */
public class MousePlayer extends BoardPlayer implements MouseListener,
							MouseMotionListener {

    private BoardGameFrame frame;

    public MousePlayer(String name,BoardGameFrame frame,int side) {
	super(name,frame.getGame(),side);
	this.frame = frame;
	frame.getBoard().addMouseListener(this);
	frame.getBoard().addMouseMotionListener(this);
    }

    /**
     * noop
     */
    public void mouseDragged(MouseEvent event) {
    }

    /**
     * noop
     */
    public void mouseEntered(MouseEvent event) {
    }

    /**
     * noop
     */
    public void mouseExited(MouseEvent event) {
	frame.getBoard().setDraggedPiece(null);
    }

    /**
     * noop
     */
    public void mousePressed(MouseEvent event) {
    }

    /**
     * noop
     */
    public void mouseReleased(MouseEvent event) {
    }

    public void mouseClicked(MouseEvent event) {
	BoardGame game = (BoardGame)getGame();
	if ((game.getCurrentPlayer()==this) &&
	    (game.getState() == game.STATE_THINKING)) {
	    Move move = new Move(frame.getBoard().getSquare(event),
				 getSide());
	    if (game.isLegal(move)) {
		frame.getBoard().setDraggedPiece(null);
		game.queueMove(move);
	    }
	}
    }
     
    public void mouseMoved(MouseEvent event) {
	BoardGame game = (BoardGame)getGame();
       	if ((game.getCurrentPlayer()==this) &&
	    (game.getState() == game.STATE_THINKING)) {
	    frame.getBoard().setDraggedPiece(event.getPoint());
	    //	    frame.getBoard().drawCursor();
	    if (game.isLegal(new Move(frame.getBoard().getSquare(event),
				      getSide()))) {
		frame.getBoard().setHighlight(event);
	    } else {
		frame.getBoard().clearHighlight();
	    }
	    frame.getBoard().repaint();
	}
    }

}
