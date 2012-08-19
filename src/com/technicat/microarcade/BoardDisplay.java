package com.technicat.microarcade;

import com.technicat.games.*;
import com.technicat.boardgame.*;
import com.technicat.automata.*;

import java.util.*;

import javax.microedition.lcdui.*;

/**
 * Basic display of a board
 * Copyright (c) 2005 Technicat, LLC
 */
public interface BoardDisplay extends BoardListener, StateListener {

    public void setHighlight(int square);

    public void clearHighlight();

    public void addActionListener(ActionListener listener);

    public void boardChanged();

    public void stateChanged(State state);
}
