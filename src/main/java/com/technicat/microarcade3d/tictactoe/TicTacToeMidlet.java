package com.technicat.microarcade3d.tictactoe;

import com.technicat.microarcade.*;
import com.technicat.boardgame.*;
import com.technicat.tictactoe.*;

public class TicTacToeMidlet extends BoardGameMidlet {

    protected BoardCanvas createBoard(BoardGame game) {
	return new TicTacToeBoard(game);
    }

    protected BoardGame createGame() {
	return new TicTacToe();
    }

    protected BoardPlayer createPlayer0(int type) {
	switch (type) {
	case DEMO:
	    return new MinMaxPlayer("X",getGame(),BoardGame.PLAYER0,9);
	default:
	    return new HumanPlayer("X",this,BoardGame.PLAYER0);
	}
    }

    protected BoardPlayer createPlayer1(int type) {
	switch (type) {
	case DEMO:
	    return new MinMaxPlayer("O",getGame(),BoardGame.PLAYER1,3);
	case TWO_PLAYER:
	    return new HumanPlayer("O",this,BoardGame.PLAYER1);
	case EASY:
	    return new MinMaxPlayer("O",getGame(),BoardGame.PLAYER1,3);
	case HARD:
	    return new MinMaxPlayer("O",getGame(),BoardGame.PLAYER1,9);
	}
	return null;
    }
}
