package com.technicat.arcade.reversi;

import com.technicat.arcade.*;
import com.technicat.boardgame.*;
import com.technicat.reversi.*;

/**
 * User interface for Reversi
 * Copyright (c) 2004-2005 Technicat, LLC
 * @author Phil Chu
 */
public class ReversiFrame extends BoardGameFrame {

    /**
     *
     */
    public ReversiFrame() {
	super(new Reversi());
    }

    protected BoardComponent createBoard(BoardGame game) {
	return new ReversiBoard(game);
    }
}
