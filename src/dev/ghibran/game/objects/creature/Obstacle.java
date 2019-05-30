package dev.ghibran.game.objects.creature;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import dev.ghibran.Util;
import dev.ghibran.game.Game;

public class Obstacle extends Creature {
	
	
	
	private int poss;
	private Random r;
	private int  R ,G ,B;
	
	public Obstacle() {
		super(1);
		r = new Random();
		initPoss();
	}
	
	private void initPoss(){
		
		
		
		poss = r.nextInt(4);
		R = r.nextInt(255);
		G = r.nextInt(255);
		B = r.nextInt(255);
		
		width = 10 +  r.nextInt(40);
		height = 10 + r.nextInt(40);
		
		int area = width * height;
		
		speed = 2500/area;
		
		speed = (int)Util.restrict((float) speed, 3.0F, 20.0F);
		
		if(poss == 0){
			y = - r.nextInt(50);
			x = r.nextInt(Game.WIDTH - width);
			velX = 0;
			velY = speed;
		}
		else if(poss == 1){
			x = Game.WIDTH + r.nextInt(50);
			y = r.nextInt(Game.HEIGHT - height);
			velX= -speed;
			velY=0;
		}
		else if(poss == 2){
			x = r.nextInt(Game.WIDTH - width);  
			y = Game.HEIGHT + r.nextInt(50);
			velX= 0;
			velY = -speed;
		}
		else if(poss == 3){
			x = 0 - r.nextInt(50);
			y = r.nextInt(Game.HEIGHT- height);
			velX = speed;
			velY = 0;
		}
		
		
		
	}

	@Override
	public void tick() {
		move();
		if(x >= Game.WIDTH + width || x<= 0 - width
		   || y<=0 - height || y>= Game.HEIGHT + height ){
			initPoss();
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color(R,G,B));
		
		g.fillRect(x, y, width, height);
		
	}

	@Override
	public void collision(Creature arg) {
	}


}
