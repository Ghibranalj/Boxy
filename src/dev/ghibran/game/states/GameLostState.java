package dev.ghibran.game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import dev.ghibran.game.Game;
import dev.ghibran.game.listener.Action;
import dev.ghibran.game.objects.creature.Obstacle;
import dev.ghibran.ui.Button;

public class GameLostState extends State {

	
	Button Mmenu , playAgain;
	Font fnt = new Font("tahoma",Font.PLAIN,80);
	Obstacle[] prop = new Obstacle[10];
	
	
	public GameLostState (){
		init();
	}
	
	@Override
	public void tick() {
		for(Obstacle i : prop)
			i.tick();
		Mmenu.tick();
		playAgain.tick();
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		for(Obstacle i : prop)
			i.render(g);
		Mmenu.render(g);
		playAgain.render(g);
		
		g.setColor(Color.black);
		g.setFont(fnt);
		
		FontMetrics metrics = g.getFontMetrics();
		int xoff = metrics.stringWidth("YOU LOST")/2;
		
		g.drawString("YOU LOST", Game.WIDTH/2 - xoff, Game.HEIGHT/2 - 50 + fnt.getSize()/2);
		
	}

	@Override
	public void init() {
		Mmenu = new Button("Main Menu",		(Game.WIDTH/2) -200  ,380,400,50,Color.GRAY,Color.LIGHT_GRAY);
		playAgain = new Button("Play Again",(Game.WIDTH/2) -200  ,300,400,50,Color.GRAY,Color.LIGHT_GRAY);
		for(int i  = 0; i < prop.length;i++)
			prop[i] = new Obstacle();
		
		setActionListeners();
	}

	private void setActionListeners() {
		Mmenu.setClickedEventListener(new Action(){

			@Override
			public void actionPerFormed() {
				State.MAIN_MENU.init();
				State.setCurrState(State.MAIN_MENU);
			}
		});
		
		playAgain.setClickedEventListener(new Action(){

			@Override
			public void actionPerFormed() {
				State.GAME.init();
				State.setCurrState(State.GAME);
			}
			
		});
		
	}

}
