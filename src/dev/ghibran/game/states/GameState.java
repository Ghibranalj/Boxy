package dev.ghibran.game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import dev.ghibran.Timer;
import dev.ghibran.game.Game;
import dev.ghibran.game.handler.CollisionHandler;
import dev.ghibran.game.handler.Handler;
import dev.ghibran.game.objects.creature.Obstacle;
import dev.ghibran.game.objects.creature.Player;
import dev.ghibran.game.objects.creature.Spawner;

public class GameState extends State {

	Player p;
	Spawner s;
	Handler cHandler;
	Timer timer;
	
	public GameState(){
		init();
	}
	
	public void init(){
		timer = new Timer();
		timer.start();
		p = new Player();
		s = new Spawner();
		cHandler = new CollisionHandler<Obstacle>(s.getList(),p);
	}
	@Override
	public void tick() {
		timer.tick();
		p.tick();
		s.tick();
		if(timer.getTime()/10 >= 3){
			cHandler.tick();
			p.setColor(Color.red);
		}else{
			p.setColor(new Color(255,0,0,40));
		}
		
	}

	@Override
	public void render(Graphics g) {
		p.render(g);
		s.render(g);
		
		if(timer.getTime()/10 < 3){
			int c = 3 - (int) (timer.getTime()/10);
			g.setFont(new Font("tahoma",Font.PLAIN,50));
			g.setColor(Color.BLUE);
			FontMetrics metrics = g.getFontMetrics();
			int x = metrics.stringWidth(""+c)/2;
			g.drawString(""+c, Game.WIDTH/2 - x, 100);
		}
	}
	}
