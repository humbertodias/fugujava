package com.technicat.arcade.gomoku;

import com.technicat.arcade.*;
import com.technicat.boardgame.*;
import com.technicat.gomoku.*;

/**
 * User interface for Tic Tac Toe
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class GomokuFrame extends BoardGameFrame {

    /**
     *
     */
    public GomokuFrame() {
	super(new Gomoku());
    }

    /**
     *
     */
    protected BoardComponent createBoard(BoardGame game) {
	return new GomokuBoard(game);
    }
}
