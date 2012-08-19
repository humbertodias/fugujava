package com.technicat.games;

/**
 * @author Phil chu
 */
public class Player {

    private String name;
    private Game game;

    public Player(String name, Game game) {
	super();
	setName(name);
	this.game = game;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public Game getGame() {
	return game;
    }

}
