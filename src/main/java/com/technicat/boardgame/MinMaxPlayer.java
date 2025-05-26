package com.technicat.boardgame;

import java.util.*;

/**
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class MinMaxPlayer extends ComputerBoardPlayer {

    private int maxDepth;
    
    /**
     * One board per ply
     */
    private Board[] boards;

    /**
     *
     */
    private MoveIterator[] movers;

    public MinMaxPlayer(String name, BoardGame game, int piece, int depth) {
	super(name,game,piece);
	maxDepth = depth;
	boards = new Board[depth];
	movers = new MoveIterator[depth];
	for (int i=0; i<depth; ++i) {
	    boards[i] = game.createBoard();
	    movers[i]= new MoveIterator(game);
	}
    }

    final public static int WINNING_SCORE = 100000;
    final public static int LOSING_SCORE = -WINNING_SCORE;
    final public static int LOWEST_SCORE = Integer.MIN_VALUE+1000;
    final public static int TIE_SCORE = 0;

    public Move getBestMove() {
	BoardGame game = (BoardGame)getGame();
	MoveIterator it = movers[0]; //new MoveIterator(game,this,game.getBoard());
	it.reset(this,game.getBoard());
	Move bestMove = null;
	int bestScore = LOWEST_SCORE;
	while (it.hasMoreElements()) {
	    Move move = (Move)it.nextElement();
	    Board newboard = boards[0];
	    game.getBoard().copyBoard(newboard);
	    game.makeMove(this,move,newboard);
	    int score = -eval(game.getOtherPlayer(this),newboard,1,
			      LOWEST_SCORE,-bestScore);
	    if (score> bestScore) {
		bestScore = score;
		bestMove = move;
	    }
	}
	return bestMove;
    }

    protected int eval(BoardPlayer player, Board board, int depth, 
		       int alpha, int beta) {
	BoardGame game = (BoardGame)getGame();
	if (depth == maxDepth || game.isGameOver(player,board)) {
	    return evalstatic(player,board);
	} else {
	    MoveIterator it = movers[depth];
	    it.reset(player,board);
	    if (it.hasMoreElements()) {
		while (it.hasMoreElements()) {
		    Move move = (Move)it.nextElement();
		    Board newboard = boards[depth];
		    board.copyBoard(newboard);
		    game.makeMove(player,move,newboard);
		    int score = -eval(game.getOtherPlayer(player),
				      newboard,depth+1,-beta,-alpha);
		    if (score>alpha) {
			if (score>=beta) {
			    return beta;
			} else {
			    alpha = score;
			}
		    }
		}
		return alpha;
	    } else {
		// pass
		return -eval(game.getOtherPlayer(player),board,depth+1,
			     -beta,-alpha);
	    }
	}
    }

    protected int evalstatic(BoardPlayer player, Board board) {
	BoardGame game = (BoardGame)getGame();
	if (game.isWon(player,board)) {
	    return WINNING_SCORE;
	} else if (game.isWon(game.getOtherPlayer(player),board)) {
	    return LOSING_SCORE;
	} else {
	    return TIE_SCORE;
	}
    }
}