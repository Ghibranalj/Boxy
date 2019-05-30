package dev.ghibran.game.states;

import java.awt.Graphics;

public abstract class State {
	private static State currState = null;
	
	public static State getCurrState(){
		return currState;
		
	}
	public static void setCurrState(State state){
		currState = state;
	}
	
	
	public static final State GAME 		= new GameState(),
							  PAUSE 	= new PauseState(),
							  MAIN_MENU = new MainMenuState(),
							  GAME_LOST = new GameLostState();
	
	public abstract void tick();
	public abstract void render(Graphics g);
	public abstract void init();
}
