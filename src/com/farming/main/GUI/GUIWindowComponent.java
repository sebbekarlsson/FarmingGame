package com.farming.main.GUI;

import java.awt.Graphics;


public class GUIWindowComponent {


	public int x, y;
	public int xoffset,yoffset;
	

	

	public GUIWindowComponent(int xoffset,int yoffset){
		this.xoffset = xoffset;
		this.yoffset = yoffset;
	}

	public void tick(){}
	public void draw(Graphics g){}

	




}
