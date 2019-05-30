package dev.ghibran.game.display;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window {

	private int width, height;
	private String title;
	private Dimension dimension;
	
	
	private Canvas canvas;
	private JFrame frame;
	
	
	
	public Window(String title, int width , int height){
		this.width = width;
		this.height = height;
		this.title = title;
		this.dimension = new Dimension(width, height);
		
		init();
	}

	
	
	private void init(){
	// Frame
		frame = new JFrame(title);
	
		frame.setSize(dimension);
		frame.setFocusable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		
		
	// Canvas
		canvas = new Canvas();
		
		canvas.setMaximumSize(dimension);
		canvas.setMinimumSize(dimension);
		canvas.setPreferredSize(dimension);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		frame.pack();
		frame.requestFocus();
	}
	
	public void addActionListener(KeyListener listener){
		frame.addKeyListener(listener);
	}
	
	
	// display TITLE + : @param as a title
	public void frameRate(int fps){
		frame.setTitle(title + " - " + fps+"fps" ); 
	}
	
	
	
	
	//Getters And Setters
		
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Canvas getCanvas() {
		return canvas;
	}

	public JFrame getFrame() {
		return frame;
	}


}
	
