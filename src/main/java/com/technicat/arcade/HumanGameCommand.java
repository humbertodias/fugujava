package com.technicat.arcade;

import com.technicat.boardgame.*;

import javax.swing.*;
import java.awt.event.*;

/**
 * copyright 2005 Technicat, LLC
 * @author Phil Chu
 */
public class HumanGameCommand extends NewGameCommand {

    public HumanGameCommand(Class cl,
			   JDesktopPane desktop) {
	super(cl,"Two Player",desktop);
    }

    public BoardPlayer getPlayer0() {
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	return new MousePlayer("Black",frame,
			       BoardGame.PLAYER0);
    }
    
    public BoardPlayer getPlayer1() {
	BoardGameFrame frame = (BoardGameFrame)getApplication();
	return new MousePlayer("White",frame,
			       BoardGame.PLAYER1);
    }
}

