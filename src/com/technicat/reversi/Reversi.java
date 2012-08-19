package com.technicat.reversi;

import com.technicat.boardgame.*;

//import java.util.*;

/**
 * Reversi
 * Copyright (c) 2004-2005 Technicat, LLC
 */
public class Reversi extends BoardGame {

    final static public int BLACK = PLAYER0;
    final static public int WHITE = PLAYER1;

    /**
     *
     */
    public Reversi() {
	super();
    }

    public Board createBoard() {
	return new ReversiBoard();
    }

    public boolean isWon(BoardPlayer player,Board board) {
	return ((ReversiBoard)board).getScore(player.getSide()) > 0;
    }

    public boolean isGameOver(BoardPlayer player, Board board) {
	return (!hasMove(player,board) &&
		!hasMove(getOtherPlayer(player),board));
    }

    public String getGameOverMessage() {
	ReversiBoard board = (ReversiBoard)getBoard();
	String message = super.getGameOverMessage();
	message += " "+
	    board.getTotal(PLAYER0)+" - " +
	    board.getTotal(PLAYER1);
	return message;
    }

    /**
     * @return Reversi
     */
    public String getName() {
	return "Reversi";
    }

    /**
     * check if move will flip pieces in any direction
     * @return move is legal
     */
    public boolean isLegal(BoardPlayer player,Move move,Board board) {
	return super.isLegal(player,move,board) &&
	    ((ReversiBoard)board).hasFlips(move);
    }

    /**
     * flip pieces in every direction
     */
    public void makeMove(BoardPlayer player,
			 Move move,
			 Board board) {
	    super.makeMove(player,move,board);
	    ((ReversiBoard)board).makeFlips(move);
    }

}
