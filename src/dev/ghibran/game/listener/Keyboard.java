package dev.ghibran.game.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
	
	public class Key{
		private boolean pressed;
		
		public boolean isPressed(){
			return pressed;
		}
		public void press(){
			pressed = true;
		}
		public void release(){
			pressed = false;
		}
			
	}
	
	
	Key[] key = new Key[525];
	
	public static Key UP	
					, DOWN	
					, RIGHT 
					, LEFT;
	
	public Keyboard(){
		
		for(int i = 0 ;i < key.length;i++)
			key[i] = new Key();
	}
	
	public void tick(){
		
		UP = key[KeyEvent.VK_UP];
		DOWN = key[KeyEvent.VK_DOWN];
		LEFT = key[KeyEvent.VK_LEFT];
		RIGHT = key[KeyEvent.VK_RIGHT];
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		key[e.getKeyCode()].press();;
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		key[e.getKeyCode()].release();
		
	} 

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
