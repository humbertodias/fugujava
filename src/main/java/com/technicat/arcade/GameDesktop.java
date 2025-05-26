package com.technicat.arcade;

import com.technicat.desktopinternal.*;
import com.technicat.arcade.tictactoe.*;
import com.technicat.arcade.reversi.*;
import com.technicat.arcade.gomoku.*;

import javax.swing.*;

/**
 * Copyright 2004-2005 Technicat, LLC
 * @author Philip Chu
 */
public class GameDesktop extends DesktopApplication {

    public GameDesktop() {
	super();
    }

    public String getName() {
	return "Fugu Games";
    }

    protected void createMenuBar() {
	createGameMenu();
	super.createMenuBar();
    }

    /**
     *
     */
    protected void createGameMenu() {
	JMenu menu = new JMenu("Game");
	addMenu(menu);
	//
	JMenu cmenu = new JMenu("Chess");
	cmenu.setEnabled(false);
	menu.add(cmenu);
	//
	JMenu gomenu = new JMenu("Go");
	gomenu.setEnabled(false);
	menu.add(gomenu);
	//
	JMenu gmenu = new JMenu("Gomoku");
	menu.add(gmenu);
	gmenu.add(new HumanGameCommand(com.technicat.arcade.gomoku.GomokuFrame.class,
				      getDesktop()));
	gmenu.add(new GomokuDemoCommand(getDesktop()));
	gmenu.add(new GomokuEasyCommand(getDesktop()));
	gmenu.add(new GomokuMediumCommand(getDesktop()));
	//
	JMenu tmenu = new JMenu("Tic Tac Toe");
	menu.add(tmenu);
	tmenu.add(new HumanGameCommand(com.technicat.arcade.tictactoe.TicTacToeFrame.class,
				      getDesktop()));
	tmenu.add(new TicDemoCommand(getDesktop()));
	tmenu.add(new TicEasyCommand(getDesktop()));
	tmenu.add(new TicExpertCommand(getDesktop()));
	//
	JMenu rmenu = new JMenu("Reversi");
	menu.add(rmenu);
	rmenu.add(new HumanGameCommand(com.technicat.arcade.reversi.ReversiFrame.class,
				      getDesktop()));
	rmenu.add(new ReversiDemoCommand(getDesktop()));
	rmenu.add(new ReversiEasyCommand(getDesktop()));
	rmenu.add(new ReversiGoodCommand(getDesktop()));
	rmenu.add(new ReversiExpertCommand(getDesktop()));
	}

}
