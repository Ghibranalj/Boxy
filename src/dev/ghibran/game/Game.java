package dev.ghibran.game;

import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.ghibran.game.display.Window;
import dev.ghibran.game.listener.Keyboard;
import dev.ghibran.game.listener.Mouse;
import dev.ghibran.game.states.State;

public  class Game implements Runnable{
		
	
	// changable Var
	
	
		public static final int WIDTH = 600,
								HEIGHT = WIDTH * 9 / 12;
	
	
		public static final String TITLE = "thought";
	
		
	//----------------------------------------------------------------------
	
		
		private boolean running;
        private Thread thread;
        private Graphics g;
        private BufferStrategy bs;
        private Window window ;
        private Keyboard keyboard;
        private Mouse mouse;
	
        public static long timer = 0;
        
		public Game(){
		initGame();	
		}

		private void initGame() {
			
			keyboard = new Keyboard();
			mouse = new Mouse();
			window = new Window(TITLE,WIDTH,HEIGHT);
			window.addActionListener(keyboard);
			window.getCanvas().addMouseListener(mouse);
			window.getCanvas().addMouseMotionListener(mouse);
			thread = new Thread(this);
		}

		
		
		@Override
		public void run() {
			
			State.setCurrState(State.MAIN_MENU);
			
			int fps = 60;
			double timePerTick = 1e9/fps;
			long lastTime = System.nanoTime();
			double delta =0 ;
			long now;
			int ticks = 0;
			double timer = 0;
			while(running){
				now = System.nanoTime();
				delta += (now - lastTime) / timePerTick;
				timer += now - lastTime;
				lastTime = now;
				
				if(delta >= 1){
					tick();
					render();
					
					ticks ++;
					delta = 0;
				}
				
				
				if(timer == 1e9){
					window.frameRate(ticks);
					ticks =0;
					timer = 0 ;
				}
				
			}
		}
		
		

		public void Start(){
			if(running)
				return;
			
			running = true;
			thread.start();
		}
		
		public void Stop(){
			if(!running)
				return;
				
			try {
				thread.join();
				running = false;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
		private void tick() {
			long Ttimer = System.nanoTime();
			
			mouse.tick();
			keyboard.tick();
			if(State.getCurrState() != null)
			State.getCurrState().tick();
			
			timer += (System.nanoTime() - Ttimer);
			
			
		}

		private void render() {
			bs = window.getCanvas().getBufferStrategy();
			if(bs == null){
				window.getCanvas().createBufferStrategy(3);
				return;
			}
			
			g = bs.getDrawGraphics();
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, window.getWidth(), window.getHeight());
			// render Here
				if(State.getCurrState() != null)
				State.getCurrState().render(g);
				
				g.setColor(Color.BLACK);
			//
			
			g.dispose();
			bs.show();
		}

		
	
}

