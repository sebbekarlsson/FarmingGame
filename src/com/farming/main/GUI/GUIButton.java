package com.farming.main.GUI;

import java.awt.Graphics;
import java.awt.Image;

import com.S2DGL.engine.GameEngine;
import com.S2DGL.engine.Mouse;
import com.S2DGL.engine.utils.ImageLoader;
import com.farming.main.Game;

public class GUIButton {

	
	public int x, y;
	
	public Image sprite;
	
	public GUIButton(int x,int y){
		this.x = x;
		this.y = y;
	}
	
	public void tick(){}
	public void draw(Graphics g){
		drawDeafultSprite(g);
		
	}
	
	public void setSprite(String spritePath){
		Image image = ImageLoader.loadImage(spritePath);
		if(!(this.sprite == image)){
			this.sprite = image;
		}
	}
	
	public void drawDeafultSprite(Graphics g){
		g.drawImage(sprite, x, y, null);
	}
	
	public boolean leftClick(){
		int mousex = Mouse.getMousePositionInGUI(Game.engine).x;
		int mousey = Mouse.getMousePositionInGUI(Game.engine).y;
		
		if(mousex >= x && mousex < x+sprite.getWidth(null) && mousey > y && mousey < y+sprite.getHeight(null)){
			if(GameEngine.mouse_left){
				return true;
				
			}
		}
		
		return false;
	}
}
