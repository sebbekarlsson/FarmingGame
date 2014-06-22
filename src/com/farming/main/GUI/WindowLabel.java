package com.farming.main.GUI;

import java.awt.Color;
import java.awt.Graphics;

public class WindowLabel extends GUIWindowComponent {

	public String text = "";
	public Color color;
	
	public WindowLabel(int xoffset, int yoffset,String text,Color color) {
		super(xoffset, yoffset);
		this.text = text;
		this.color = color;
	}
	
	public void draw(Graphics g){
		g.setColor(color);
		drawDefault(g);
	}
	
	public void setText(String text){
		this.text = text;
	}
	

	public void drawDefault(Graphics g){
		
		g.drawString(text, x, y);
	}


}
