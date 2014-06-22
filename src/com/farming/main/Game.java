package com.farming.main;

import com.S2DGL.engine.GameEngine;
import com.S2DGL.engine.Instance;
import com.farming.main.scenes.FarmingScene;

public class Game {
	public static GameEngine engine = new GameEngine();
	
	
	public static int fallTimer = 60000;
	public static Instance boughtInstance;
	
	public static int money = 800;
	
	public static void main(String[] args){
		engine.setTitle("Farmin Game");
		engine.insertScene(new FarmingScene(GameEngine.RENDERSIZE.width*2,GameEngine.RENDERSIZE.height*2));
		engine.start();
	}
	
	public static Instance getBoughtInstance(){
		return boughtInstance;
	}
	
	public static void clearBoughtInstance(){
		boughtInstance = null;
	}
	
	
}
