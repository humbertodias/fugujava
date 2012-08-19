package com.technicat.tictactoe;

import com.technicat.boardgame.*;

/**
 * @author Phil Chu
 */
final public class TicTacToe extends BoardGame {

    final static public int X = PLAYER0;
    final static public int O = PLAYER1;

    public TicTacToe() {
	super();
    }

    public Board createBoard() {
	return new RowGameBoard(3,3);
    }

    public boolean isWon(BoardPlayer player,Board board) {
	return ((RowGameBoard)board).hasRow(player.getSide(),3);
    }

    public String getName() {
	return "Tic Tac Toe";
    }

}
