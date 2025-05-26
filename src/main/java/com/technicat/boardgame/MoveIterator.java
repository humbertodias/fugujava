package com.technicat.boardgame;

import java.util.*;

/**
 * @author Phil chu
 */
public class MoveIterator implements Enumeration {

    private BoardGame game;
    private Board board;
    private Move nextMove;
    private BoardPlayer player;

    public MoveIterator(BoardGame game) {
	super();
	this.game = game;
    }

    public void reset(BoardPlayer player, Board board) {
	this.player = player;
	this.board = board;
	nextMove = null;
	updateNext();
     }

    private void updateNext() {
	int start;
	if (nextMove == null) {
	    start = 0;
	} else {
	    start = nextMove.square+1;
	}
	for (int i=start; i<board.size; ++i) {
	    Move move = game.getMove(i,player.getSide());
	    if (game.isLegal(player,move,board)) {
		nextMove = move;
		return;
	    }
	}
	nextMove = null;
    }

    // Iterator

    public boolean hasMoreElements() {
	return (nextMove != null);
    }

    public Object nextElement() {
	Move move = nextMove;
	updateNext();
	return move;
    }

}
