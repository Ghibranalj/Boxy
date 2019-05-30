package dev.ghibran.game.objects.creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.ghibran.Util;
import dev.ghibran.game.Game;
import dev.ghibran.game.listener.Keyboard;
import dev.ghibran.game.states.State;

public class Player extends Creature {
	
	
	private Color color;
	public Player() {
		super(0);
		
		speed = 5;
		color = Color.RED;
	}

	@Override
	public void tick() {
		if(Keyboard.UP.isPressed())
			velY= -speed;
		if(Keyboard.DOWN.isPressed())
			velY= speed;
		if(Keyboard.LEFT.isPressed())
			velX= -speed;
		if(Keyboard.RIGHT.isPressed())
			velX= speed;
		
		
		if(Keyboard.UP.isPressed()||Keyboard.DOWN.isPressed())
			velX=0;
		else if(Keyboard.RIGHT.isPressed()||Keyboard.LEFT.isPressed())
			velY=0;

		move();
		
		x = (int) Util.restrict((float)x,(float)0 ,(float)Game.WIDTH - width);
		y = (int) Util.restrict((float)y,(float)0 ,(float)Game.HEIGHT - height);
	}

	@Override
	public void render(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
		
	}

	@Override
	public void collision(Creature arg) {
		if(arg.getId() == 1){
			State.setCurrState(State.GAME_LOST);
		}
		
	}
	
	public void setColor(Color color){
		this.color = color;
	}


}
