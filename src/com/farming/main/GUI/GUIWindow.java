package com.farming.main.GUI;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.S2DGL.engine.GameEngine;
import com.S2DGL.engine.Mouse;
import com.farming.main.Game;
import com.farming.main.scenes.FarmingScene;

public class GUIWindow {

	
	public int x, y;
	public int width,height;
	boolean following = false;
	
	public List<GUIWindowComponent> components = new ArrayList<GUIWindowComponent>();

	
	public GUIWindow(int x,int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void tick(){
		checkForClose();
		checkForLeftClick();
		tickComponents();
		
		
	}
	public void draw(Graphics g){
		drawDeafultWindow(g);
		
	}
	
	
	
	public void drawDeafultWindow(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
		g2d.setColor(Color.black);
		
		g2d.fillRect(x+8, y+8, width, height);
		
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));
		g.setColor(new Color(194,159,122));
		g.fillRect(x, y, width, height);
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, 16);
		g.setColor(Color.red);
		g.drawRect(x+width-16, y+4, 8, 8);
		
		g.setColor(Color.black);
		g.drawRect(x, y, width, height);
		
		
		drawComponents(g);
	}
	
	public void checkForLeftClick(){
		int mousex = Mouse.getMousePositionInGUI(Game.engine).x;
		int mousey = Mouse.getMousePositionInGUI(Game.engine).y;
		
		if(mousex >= x && mousex < x+width && mousey > y-16 && mousey < y+4){
			if(GameEngine.mouse_left){
				if(following == false){
					following = true;
				}else{
					following = false;
				}
				GameEngine.mouse_left = false;
				
				
			}
		}
		if(following){
			x = mousex-width/2;
			y = mousey;
		}
		
	}
	
	public void checkForClose(){
		int mousex = Mouse.getMousePositionInGUI(Game.engine).x;
		int mousey = Mouse.getMousePositionInGUI(Game.engine).y;
		
		if(mousex >= x+width-16 && mousex < x+width && mousey > y-16 && mousey < y){
			if(GameEngine.mouse_left){
				close();
				
			}
		}
		
		
	}
	
	public void tickComponents(){
		for(int i = 0; i < components.size(); i++){
			GUIWindowComponent component = components.get(i);
			component.tick();
		}
	}
	
	public void drawComponents(Graphics g){
		for(int i = 0; i < components.size(); i++){
			GUIWindowComponent component = components.get(i);
			component.x = x+component.xoffset;
			component.y = y+component.yoffset;
			component.draw(g);
		}
	}
	
	
	public void close(){
		FarmingScene.windows.remove(this);
	}
}
