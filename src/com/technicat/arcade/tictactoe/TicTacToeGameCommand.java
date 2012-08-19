package com.technicat.arcade.tictactoe;

import com.technicat.boardgame.*;
import com.technicat.arcade.*;

import javax.swing.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
abstract public class TicTacToeGameCommand extends NewGameCommand {

    public TicTacToeGameCommand(String name,JDesktopPane desktop) {
	super(com.technicat.arcade.tictactoe.TicTacToeFrame.class,
	      name,desktop);
    }

}

