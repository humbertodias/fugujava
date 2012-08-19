package com.technicat.microarcade;

import com.technicat.micro.*;
import com.technicat.boardgame.*;
import com.technicat.automata.*;

import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;

abstract public class BoardGameMidlet extends Application implements CommandListener, StateListener {

    public static final int DEMO = 0;
    public static final int TWO_PLAYER = 1;
    public static final int EASY = 2;
    public static final int HARD = 3;

    private BoardGame game;
    private BoardCanvas board;

    protected void initApp() {
	super.initApp();

	List menu = new List("Choose a game",List.IMPLICIT);
	menu.append("Demo",null);
	menu.append("Two player",null);
	menu.append("Easy",null);
	menu.append("Expert",null);
	initDisplay(menu);
    }

    private void startGame(int type) {
	game = createGame();
	game.addStateListener(this);
	board = createBoard(game);
	game.reset();
	
	initDisplay(board);

	BoardPlayer player0 = createPlayer0(type);
	BoardPlayer player1 = createPlayer1(type);
	game.addPlayer(player0);
	game.addPlayer(player1);
	game.setCurrentPlayer(player0);
	Thread thread = new Thread(game);
	thread.setPriority(Thread.MIN_PRIORITY);
	thread.start();
    }

    private void initDisplay(Displayable d) {
	d.setCommandListener(this);
	d.addCommand(getExitCommand());
	d.addCommand(getHelpCommand());
	getDisplay().setCurrent(d);
    }

    abstract protected BoardPlayer createPlayer0(int type);

    abstract protected BoardPlayer createPlayer1(int type);

    public BoardCanvas getBoard() {
	return board;
    }

    public BoardGame getGame() {
	return game;
    }

    abstract protected BoardCanvas createBoard(BoardGame game);
    abstract protected BoardGame createGame();

    public void stateChanged(State state) {
	if (state == game.STATE_GAME_OVER) {
	    Alert alert = new Alert("Game Over",
				    game.getGameOverMessage(),
				    null,null);
	    alert.setTimeout(Alert.FOREVER);
	    getDisplay().setCurrent(alert,board);
	}
    }

    public void commandAction(Command c,Displayable s) {
	if (c==List.SELECT_COMMAND) {
	    startGame(((List)s).getSelectedIndex());
	} else {
	    super.commandAction(c,s);
	}
    }
}
