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
public class ReversiDemoCommand extends ReversiGameCommand {

    public ReversiDemoCommand(JDesktopPane desktop) {
	super("Demo",desktop);
    }

    protected BoardPlayer getPlayer0() {
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	return new ReversiPlayer("Black",(Reversi)frame.getGame(),
				 BoardGame.PLAYER0,2);
    }

    protected BoardPlayer getPlayer1() {
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	return new ReversiPlayer("White",(Reversi)frame.getGame(),
				BoardGame.PLAYER1,3);
    }

}

