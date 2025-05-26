package com.technicat.arcade.tictactoe;

import com.technicat.tictactoe.*;
import com.technicat.boardgame.*;

import javax.swing.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
public class TicExpertCommand extends TicPlayerCommand {

    public TicExpertCommand(JDesktopPane desktop) {
	super("Expert",desktop);
    }

    protected BoardPlayer getPlayer1() {
	TicTacToeFrame frame = (TicTacToeFrame)getApplication();
	return new MinMaxPlayer("O",(TicTacToe)frame.getGame(),
				   TicTacToe.PLAYER1,9);
    }

}

