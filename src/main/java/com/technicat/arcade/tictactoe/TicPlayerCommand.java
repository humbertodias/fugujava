package com.technicat.arcade.tictactoe;

import com.technicat.boardgame.*;
import com.technicat.arcade.*;

import javax.swing.*;

/**
 * Command to start a game with a human player
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
abstract public class TicPlayerCommand extends TicTacToeGameCommand {

    public TicPlayerCommand(String name,JDesktopPane desktop) {
	super(name,desktop);
    }

    /**
     * First player is human
     */
    protected BoardPlayer getPlayer0() {
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	return new MousePlayer("X",frame,BoardGame.PLAYER0);
    }

}

