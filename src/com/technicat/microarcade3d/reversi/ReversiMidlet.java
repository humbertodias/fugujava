package com.technicat.microarcade.reversi;

import com.technicat.microarcade.*;
import com.technicat.boardgame.*;
import com.technicat.reversi.*;

public class ReversiMidlet extends BoardGameMidlet {

    protected BoardCanvas createBoard(BoardGame game) {
	return new ReversiBoard(game);
    }

    protected BoardPlayer createPlayer0(int type) {
	switch (type) {
	case DEMO:
	    return new MinMaxPlayer("Black",getGame(),BoardGame.PLAYER0,1);
	default:
	    return new HumanPlayer("Black",this,BoardGame.PLAYER0);
	}
    }

    protected BoardPlayer createPlayer1(int type) {
	switch (type) {
	case DEMO:
	    return new MinMaxPlayer("White",getGame(),BoardGame.PLAYER1,1);
	case TWO_PLAYER:
	    return new HumanPlayer("White",this,BoardGame.PLAYER1);
	case EASY:
	    return new MinMaxPlayer("White",getGame(),BoardGame.PLAYER1,1);
	case HARD:
	    return new MinMaxPlayer("White",getGame(),BoardGame.PLAYER1,3);
	}
	return null;
    }

    protected BoardGame createGame() {
	return new Reversi();
    }

}
