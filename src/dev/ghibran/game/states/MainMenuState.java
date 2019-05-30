package dev.ghibran.game.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.util.Random;

import dev.ghibran.game.Game;
import dev.ghibran.game.listener.Action;
import dev.ghibran.ui.Button;

public class MainMenuState extends State {
	
	
	private Button playButton, helpButton,exitButton;
	
	public MainMenuState(){
		init();
		
	}
	
	Font fnt = new Font("arial",Font.PLAIN,50);

	@Override
	public void tick() {
		playButton.tick();
		helpButton.tick();
		exitButton.tick();
	}

	
	int counter = 0;
	int red = 0,gr = 0,bl = 0;
	@Override
	public void render(Graphics g) {
		
		
		counter ++;
		if(counter >= 30){
			Random r = new Random();
			red = r.nextInt(150);
			gr = r.nextInt(150);
			bl = r.nextInt(150);
			counter = 0;
			}
		g.setColor(new Color(red,gr,bl));
		
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		playButton.render(g);
		exitButton.render(g);
		helpButton.render(g);
		
		g.setFont(fnt);
		g.setColor(Color.WHITE);
		FontMetrics metrics = g.getFontMetrics(fnt);
		int x = metrics.stringWidth(Game.TITLE)/2;
		g.drawString(Game.TITLE, (Game.WIDTH/2)-x, 50 + fnt.getSize()/2);
		
		
	}
	
	
	private void setActionListener(){
		
		playButton.setClickedEventListener(new Action(){
			@Override
			public void actionPerFormed() {
				State.GAME.init();
				State.setCurrState(State.GAME);	
			}
		});
		
		exitButton.setClickedEventListener(new Action(){
			@Override
			public void actionPerFormed() {
				System.exit(1);
			}
		});
		
		
		}


	@Override
	public void init() {
		playButton = new Button("PLAY", (Game.WIDTH/2) -90  ,140,180, 60, Color.gray,Color.LIGHT_GRAY);
		helpButton = new Button("HELP", (Game.WIDTH/2) -90  ,230,180, 60, Color.gray,Color.LIGHT_GRAY);
		exitButton = new Button("EXIT", (Game.WIDTH/2) -90  ,320,180, 60, Color.gray,Color.LIGHT_GRAY);
		
		
		setActionListener();
		
	}
	}


