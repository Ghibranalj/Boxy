package dev.ghibran.game.objects.creature;

import java.awt.Graphics;
import java.awt.Rectangle;

import dev.ghibran.Util;
import dev.ghibran.game.Game;

public abstract class Creature {
	

	public static final int DEFAULT_CREATURE_WIDTH = 20,
							DEFAULT_CREATURE_HEIGHT = 20,
							DEFAULT_CREATURE_DIAMETER = 20,
							DEFAULT_Y_SPAWN = Game.HEIGHT/2,
							DEFAULT_X_SPAWN = Game.WIDTH/2,
							DEFAULT_CREATURE_SPEED = 10;
	
	protected final int id;
	protected int x = DEFAULT_X_SPAWN,y = DEFAULT_Y_SPAWN;
	protected int speed = DEFAULT_CREATURE_SPEED;
	protected int height = DEFAULT_CREATURE_WIDTH, width = DEFAULT_CREATURE_HEIGHT;
	
	protected int velX = 0, velY = 0;
	
	
	Creature(int id){
		this.id =id;
	}
	
	public abstract void tick();
	public abstract void render (Graphics g);
	public abstract void collision(Creature arg);
	
	
	protected void move(){
		x+=velX;
		y+=velY;
	}
	
	
	// Getters And setters

	public Rectangle getBounds(){
		return new Rectangle(x,y,width,height);
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}

	public int getId() {
		return id;
	}
	
}
