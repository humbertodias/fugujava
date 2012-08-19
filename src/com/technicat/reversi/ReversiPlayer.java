package com.technicat.reversi;

import com.technicat.boardgame.*;

//import java.util.*;

public class ReversiPlayer extends MinMaxPlayer {

    private int[] weights= {
	120,-20,20,15,15,20,-20,120,
	-20,-40,-5,-5,-5,-5,-40,-20,
	20,-5,15,3,3,15,-5,20,
	15,-5,3,3,3,3,-5,15,
	15,-5,3,3,3,3,-5,15,
	20,-5,15,3,3,15,-5,20,
	-20,-40,-5,-5,-5,-5,-40,-20,
	120,-20,20,15,15,20,-20,120,
	};
    
    public ReversiPlayer(String name,Reversi game,int side, int depth) {
	super(name,game,side,depth);
    }

    protected int evalstatic(BoardPlayer player,Board board) {
	Reversi game = (Reversi)getGame();
	if (game.isGameOver(player,board)) {
	    return 1000*((ReversiBoard)board).getScore(player.getSide());
	} else {
	    int score = 0;
	    for (int i=0; i<board.size; ++i) {
		if (!board.isEmpty(i)) {
		    if (player.getSide() == board.getPiece(i)) {
			score += weights[i];
		    } else {
			score -= weights[i];
		    }
		}
	    }
	    return score;
	}
    }
}

