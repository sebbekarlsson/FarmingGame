package com.farming.instances;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;







import com.S2DGL.engine.GameEngine;

import com.S2DGL.engine.Mouse;
import com.farming.main.Game;

public class Tree extends Plant {

Random random = new Random();
	
	boolean created = false;
	protected int moneyGain = 0;
	public int growth = 5000;
	List<TreeFruit> fruits = new ArrayList<TreeFruit>();
	private TreeFruit product;
	
	
	public Tree(int x, int y ) {
		super(x, y);
		this.setSprite("images/plants/tree.png");
		
	
		
		
	}
	
	
	public void tick(){
		if(created == false){
			
			growFruits();
			
			created = true;
		}
		
		if(leftClick()){
			harvest();
			
		}
		
		if(fruits.size() < 1){
			if(random.nextInt(growth) == 0){
				growFruits();
			}
		}
	}
	
	
	public boolean leftClick(){
		int mousex = Mouse.getMousePositionInScene(Game.engine).x;
		int mousey = Mouse.getMousePositionInScene(Game.engine).y+16;
		if(sprite != null){
			if(mousex >= x && mousex < x+sprite.images.get(sprite.spriteIndex).getWidth(null) && mousey > y && mousey < y+sprite.images.get(sprite.spriteIndex).getHeight(null)){
				if(GameEngine.mouse_left){
					return true;

				}
			}
		}

		return false;
	}
	
	

	public void harvest(){
		for(int i = 0; i < fruits.size(); i++){
			TreeFruit fruit = fruits.get(i);
			GameEngine.getCurrentScene().destroy(fruit);
			
		}
		Game.money += moneyGain;
		fruits.clear();
		GameEngine.mouse_left = false;
	}
	
	public void growFruits(){
		for(int i = 0; i < 10; i ++){
			
			TreeFruit f;
			try {
				f = (TreeFruit) product.getClass().getDeclaredConstructor(int.class,int.class).newInstance(x+random.nextInt(64-32)+16,y+random.nextInt(64-32)+8);
				
				fruits.add(f);
				GameEngine.getCurrentScene().instantiate(f);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			
		}
	}
	
	

	public void setProduct(TreeFruit product){
		this.product = product;
	}



	


}
