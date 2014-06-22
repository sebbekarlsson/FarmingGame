package com.farming.main.GUI;

import java.awt.Graphics;
import java.awt.Image;

import com.S2DGL.engine.GameEngine;
import com.S2DGL.engine.Mouse;
import com.S2DGL.engine.utils.ImageLoader;
import com.farming.main.Game;

public class WindowButton extends GUIWindowComponent {
	public Image sprite;
	
	public WindowButton(int xoffset, int yoffset) {
		super(xoffset, yoffset);
		
	}
	
	public void draw(Graphics g){
		drawDefault(g);
	}
	
	public boolean leftClick(){
		int mousex = Mouse.getMousePositionInGUI(Game.engine).x;
		int mousey = Mouse.getMousePositionInGUI(Game.engine).y;
		if(sprite != null){
			if(mousex >= x && mousex < x+sprite.getWidth(null) && mousey > y && mousey < y+sprite.getHeight(null)){
				if(GameEngine.mouse_left){
					return true;

				}
			}
		}

		return false;
	}
	
	public void setSprite(String spritePath){
		Image image = ImageLoader.loadImage(spritePath);
		if(!(this.sprite == image)){
			this.sprite = image;
		}
	}
	

	public void drawDefault(Graphics g){
		if(sprite != null){
			g.drawImage(sprite, x, y, null);
		}

		
	}


}
