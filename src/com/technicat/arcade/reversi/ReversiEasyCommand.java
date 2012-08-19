package com.technicat.arcade.reversi;

import com.technicat.boardgame.*;
import com.technicat.reversi.*;
import com.technicat.arcade.*;

import javax.swing.*;
//import java.awt.event.*;

/**
 * Copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
public class ReversiEasyCommand extends ReversiGameCommand {

    public ReversiEasyCommand(JDesktopPane desktop) {
	super("Easy",desktop);
    }

    protected BoardPlayer getPlayer1() {
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	return new ReversiPlayer("White",(Reversi)frame.getGame(),
				BoardGame.PLAYER1,1);
    }

}

