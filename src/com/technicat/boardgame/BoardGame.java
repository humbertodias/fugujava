package com.technicat.boardgame;

import com.technicat.games.*;
import com.technicat.automata.*;

import java.util.*;

/**
 * Basic implementation of a two-player board game.
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
abstract public class BoardGame extends Game {

    final static public int PLAYER0 = 1;
    final static public int PLAYER1 = 2;

    final public State STATE_THINKING;

    final public State STATE_MOVING;

    final public State STATE_SWITCH_PLAYER;

    private Vector boardListeners;

    /**
     * Current player who's turn it is
     */
    private BoardPlayer currentPlayer;

    /**
     * pending move
     */
    private Vector pendingMoves;
    
    /**
     * The current state of the game board.
     */
    private Board gameBoard;

    /**
     * precreated Moves
     */
    private Move[][] moves;

    MoveIterator hasMoveIterator;

    /**
     *
     */
    public BoardGame() {
	super();
	// create the board
	gameBoard = createBoard();
	boardListeners = new Vector();
	STATE_THINKING = new ThinkState(this);
	STATE_MOVING = new MoveState(this);
	STATE_SWITCH_PLAYER = new SwitchPlayerState(this);
	pendingMoves = new Vector(1);
	moves = new Move[gameBoard.size][3];
	for (int i=0; i<gameBoard.size; ++i) {
	    moves[i][PLAYER0]=new Move(i,PLAYER0);
	    moves[i][PLAYER1]=new Move(i,PLAYER1);
	}
	hasMoveIterator = new MoveIterator(this);
    }
    
    public Move getMove(int square,int side) {
	return moves[square][side];
    }

    abstract public Board createBoard();

    // FSM

    public State getStartState() {
	return STATE_THINKING;
    }
    
    // pending move queue

    synchronized public void queueMove(Move move) {
	pendingMoves.addElement(move);
    }

    synchronized public Move peekPendingMove() {
	if (pendingMoves.size()==0) {
	    return null;
	} else {
	    return (Move)pendingMoves.elementAt(0);
	}
    }

    synchronized public Move getPendingMove() {
	Move move = peekPendingMove();
	if (move != null) {
	    pendingMoves.removeElementAt(0);
	}
	return move;
    }
    
    protected void notifyBoardChanged() {
	for (int i=0; i<boardListeners.size(); ++i)  {
	    BoardListener listener = (BoardListener)boardListeners.elementAt(i);
	    listener.boardChanged();
	}
    }

    public void addBoardListener(BoardListener listener) {
	boardListeners.addElement(listener);
    }

    public Board getBoard() {
	return gameBoard;
    }

    /**
     * game is over when player can't make a move, i.e. board is full
     */
    public boolean isGameOver(BoardPlayer player, Board board) {
	return  // isWon(player,board) ||
	    isWon(getOtherPlayer(player),board) ||
	    !hasMove(player,board);

    }

    public boolean isGameOver() {
	return isGameOver(currentPlayer,gameBoard);
    }

    public boolean isWinner(Player player) {
	return isWon((BoardPlayer)player,gameBoard);
    }


    abstract public boolean isWon(BoardPlayer player,Board board);

    public boolean hasMove() {
	return hasMove(currentPlayer,gameBoard);
    }

    public boolean hasMove(BoardPlayer player,Board board) {
	hasMoveIterator.reset(player,board);
	return hasMoveIterator.hasMoreElements();
    }

    /**
     *
     */
    public void makeMove(Move move) {
	// update player's move history
	currentPlayer.addMove(move);
	makeMove(currentPlayer,move,gameBoard);
	notifyBoardChanged();
    }

    public void makeMove(BoardPlayer player, Move move, Board board) {
	board.setPiece(move.square,move.piece);
    }

    public void setCurrentPlayer(BoardPlayer player) {
	currentPlayer = player;
    }

    /**
     * Set initial board configuration
     */
    public void reset() {
	gameBoard.reset();
	super.reset();
    }

    public Player getWinner() {
	Enumeration it = getPlayerIterator();
	while (it.hasMoreElements()) {
	    BoardPlayer player = (BoardPlayer)it.nextElement();
	    if (isWinner(player)) {
		return player;
	    }
	}
	return null;
    }

    public BoardPlayer getCurrentPlayer() {
	return currentPlayer;
    }

    public BoardPlayer getOtherPlayer(BoardPlayer player) {
	return (BoardPlayer)getNextPlayer(player);
    }

    public void switchPlayer() {
	currentPlayer = getOtherPlayer(currentPlayer);
    }

    /**
     * @return whether move is legal
     */
    public boolean isLegal(Move move) {
	return isLegal(currentPlayer,move,gameBoard);
    }

    public boolean isLegal(BoardPlayer player,Move move,Board board) {
	return board.isEmpty(move.square);
    }

}
