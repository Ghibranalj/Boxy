package dev.ghibran.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;

import dev.ghibran.game.listener.Action;
import dev.ghibran.game.listener.Mouse;


public class Button {
	
	private Rectangle pane;
	private Dimension dimension;
	private Color color,exitedColor,currColor;
	private String text;
	private Font font;
	private Action clickedAction,hoveredAction;
	
	int xOffset,yOffset;
	
	public Button(String text,int x , int y, int width , int height,Color color,Color exitedColor){
		
		font = new Font("tahoma",Font.PLAIN,height/3);
		dimension = new Dimension(width,height);
		pane = new Rectangle(dimension);
		pane.setLocation(x, y);
		
		this.color = color;
		
		this.exitedColor = exitedColor;
		this.text = text;
		hoveredAction = null;
		clickedAction = null;
		
	}
	
	
	private void findTextOffset(Graphics g){
		FontMetrics metrics = g.getFontMetrics(font);
		int dx,dy;
		dx = ((metrics.stringWidth(text))/2);
		dy = font.getSize()/2;
		
		xOffset = ((pane.x + pane.width/2))  - dx;
		yOffset = (pane.y +pane.height/2) + dy;
	}
	
	public void tick(){
		
		if(Mouse.isHoveringOver(pane)){
			currColor =exitedColor;
			if(hoveredAction != null)
				hoveredAction.actionPerFormed();
		}else{
			currColor = color;
		}
		
		
		if(clickedAction!= null && Mouse.pressed && Mouse.isHoveringOver(pane)){
			clickedAction.actionPerFormed();
		}
		
	}
	
	public void render(Graphics g){
		
		
		g.setColor(currColor);
		g.fillRect(pane.x, pane.y, pane.width, pane.height);
		g.setColor(Color.BLACK);
		findTextOffset(g);
		g.setFont(font);
		g.drawString(text, xOffset, yOffset);
	}
	
	
	
	public void setClickedEventListener(Action a){
		this.clickedAction = a;
	}
	public void setHoveredEventListener(Action a){
		this.hoveredAction = a;
	}
}
