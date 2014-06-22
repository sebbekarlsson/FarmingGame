package com.farming.main.scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.S2DGL.engine.GameEngine;
import com.S2DGL.engine.Mouse;
import com.S2DGL.engine.Scene;
import com.S2DGL.engine.utils.ImageLoader;
import com.farming.main.Game;
import com.farming.main.GUI.GUIWindow;
import com.farming.main.GUI.ShopButton;
import com.farming.main.instances.tiles.GrassTile;

public class FarmingScene extends Scene {
	
	public static List<GUIWindow> windows = new ArrayList<GUIWindow>();

	public FarmingScene(int width, int height) {
		super(width, height);


		for(int i = 0; i < this.getSceneSize().width/32; i++ ){
			for(int ii = 0; ii < this.getSceneSize().height/32; ii++){
				this.instantiate(new GrassTile(i*32,ii*32));
			}
		}
	}

	public void tick(){
		Game.fallTimer -= 1;
		int mousex = Mouse.getMousePositionInGUI(Game.engine).x;
		int mousey = Mouse.getMousePositionInGUI(Game.engine).y;

		if(GameEngine.vk_ctrl){

			if(mousex < 64){
				camera.x += 8;
			}
			if(mousex > GameEngine.RENDERSIZE.width-64){
				camera.x -= 8;
			}

			if(mousey < 64){
				camera.y += 8;
			}

			if(mousey > GameEngine.RENDERSIZE.height-64){
				camera.y -= 8;
			}

		}
		
		
	}
	
	
	public void drawGUI(Graphics g){
		int mousex = Mouse.getMousePositionInGUI(Game.engine).x;
		int mousey = Mouse.getMousePositionInGUI(Game.engine).y;
		
		
		
		for(int i = 0; i < windows.size(); i++){
			GUIWindow window = windows.get(i);
			window.tick();
			window.drawDeafultWindow(g);
		}
		
		ShopButton shopbutton = new ShopButton(GameEngine.RENDERSIZE.width-64,GameEngine.RENDERSIZE.height-42);
		shopbutton.tick();
		shopbutton.draw(g);
		
		g.setFont(new Font(Font.SERIF,16,16));
		g.setColor(Color.WHITE);
		
		g.drawImage(ImageLoader.loadImage("images/gui/clock.png"), 4, 16, null);
		g.drawString(""+Game.fallTimer/60, 42, 32+8);
		
		g.drawImage(ImageLoader.loadImage("images/gui/money.png"), 4, 16*3, null);
		g.drawString(""+Game.money, 42, 32*2+8);
		
		if(Game.boughtInstance != null){
			g.drawImage(Game.boughtInstance.sprite.images.get(Game.boughtInstance.sprite.spriteIndex), mousex-Game.boughtInstance.sprite.images.get(Game.boughtInstance.sprite.spriteIndex).getWidth(null)/2, mousey-Game.boughtInstance.sprite.images.get(Game.boughtInstance.sprite.spriteIndex).getHeight(null)/2, null);
		}
	}
	
	public static void newWindow(int x, int y, int width, int height){
		windows.add(new GUIWindow(x,y,width,height));
	}
	
	public static void newRawWindow(GUIWindow window){
		windows.add(window);
	}
	
	public static void closeWindow(GUIWindow window){
		windows.remove(window);
	}

}
