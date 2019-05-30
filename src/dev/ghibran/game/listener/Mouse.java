package dev.ghibran.game.listener;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class Mouse implements MouseListener,MouseMotionListener,MouseWheelListener {
	
	
	private Point locationPoint;
	
	
	public static boolean pressed = false;
	public static boolean isInside = false;
	private static Rectangle mouseBound = new Rectangle();
	
	
	public Mouse (){
		locationPoint = new Point();
		mouseBound.setSize(10, 10);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isInside = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isInside = false;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		pressed = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		pressed = false;
	}


	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}


	@Override
	public void mouseDragged(MouseEvent e) {
	
		
	}


	@Override
	public void mouseMoved(MouseEvent e) {
		locationPoint = e.getPoint();
	}
	
	

	
	public void tick(){
		mouseBound.setLocation(locationPoint.x - 1, locationPoint.y - 1);
	}
	
	
	public static boolean isHoveringOver(Rectangle r){
		return mouseBound.intersects(r);
	}
}
