package com.technicat.arcade.reversi;

import com.technicat.reversi.*;
import com.technicat.boardgame.*;

import javax.swing.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
public class ReversiExpertCommand extends ReversiGameCommand {

    public ReversiExpertCommand(JDesktopPane desktop) {
	super("Expert",desktop);
    }

    protected BoardPlayer getPlayer1() {
	ReversiFrame frame = (ReversiFrame)getApplication();
	return new ReversiPlayer("White",(Reversi)frame.getGame(),
				BoardGame.PLAYER1,8);
    }

}

