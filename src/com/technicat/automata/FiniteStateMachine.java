package com.technicat.automata;

import java.util.*;

abstract public class FiniteStateMachine implements Runnable {

    private Vector listeners = new Vector();

    State state;

    synchronized public State getState() {
	return state;
    }

    abstract public State getStartState();

    abstract public State getStopState();

    /**
     */
    protected void notifyStateChanged() {
	for (int i=0; i<listeners.size(); ++i) {
	    StateListener listener = (StateListener)listeners.elementAt(i);
	    listener.stateChanged(state);
	}
    }

    public void addStateListener(StateListener listener) {
	listeners.addElement(listener);
    }

    /**
     * Reset the FSM to the start state
     */
    public void reset() {
	state = getStartState();
	//setState(getStartState());
    }

    public void run() {
	try {
	    setState(getStartState());
	    while (state != getStopState()) {
		State nextState = state.getNextState();
		if (nextState != null) {
		    state.cleanup();
		    setState(nextState);
		}
		Thread.yield();
	    }
	} catch (Exception exception) {
	    exception.printStackTrace();
	}
    }

    private void setState(State state) {
	this.state = state;
	state.init();
	notifyStateChanged();
	Thread.yield();
    }


}