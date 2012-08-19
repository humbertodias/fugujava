package com.technicat.arcade.reversi;

import com.technicat.boardgame.*;
import com.technicat.reversi.*;
import com.technicat.arcade.*;

import java.awt.*;
import java.awt.geom.*;


/**
 * Reversi board display
 * Copyright (c) 2005 Technicat, LLC
 */
public class ReversiBoard extends BlackWhiteBoard {

    /**
     *
     */
    public ReversiBoard(BoardGame game) {
	super(game);
	setBackground(new Color(10,128,10));
    }

    protected int getPieceSize() {
	return 40;
    }

}
