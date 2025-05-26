package com.technicat.arcade.gomoku;

import com.technicat.boardgame.*;
import com.technicat.gomoku.*;
import com.technicat.arcade.*;

import java.awt.*;
import java.awt.geom.*;


/**
 * Gomoku board display
 * Copyright (c) 2005 Technicat, LLC
 */
public class GomokuBoard extends BlackWhiteBoard {

    /**
     *
     */
    public GomokuBoard(BoardGame game) {
	super(game);
	setBackground(new Color(128,128,10));
    }

    protected int getPieceSize() {
	return 15;
    }

}
