package com.technicat.automata;

public interface State {

    /**
     * Initial action upon entering state
     */
    public void init();

    /**
     * @return next State
     */
    public State getNextState();

    /**
     * Action upon exiting state
     */
    public void cleanup();

}