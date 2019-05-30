package dev.ghibran.game.objects.creature;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import dev.ghibran.Timer;
import dev.ghibran.game.Game;



public class Spawner {
	
	
	private LinkedList<Obstacle> list ;
	
	//private Timer timer;
	private double level;
	private Timer timer;
	
	public Spawner(){
		timer = new Timer();
		timer.start();
		list = new LinkedList<Obstacle>();
		
	}
	

	public void tick(){
		timer.tick();	
		level  = 3+ Math.sqrt(timer.getTime()/10);
		
		while(list.size()<level)
			list.add(new Obstacle());
		
		for(int i = 0; i<list.size();i++){
			list.get(i).tick();
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i<list.size();i++){
			list.get(i).render(g);
		}
		g.drawString(""+level, 0, 20);
	}
	public LinkedList<Obstacle> getList(){
		return list;
	}

}
