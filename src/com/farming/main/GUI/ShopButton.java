package com.farming.main.GUI;

import java.awt.Color;

import com.S2DGL.engine.GameEngine;
import com.farming.instances.AppleTree;
import com.farming.instances.BerryBush;
import com.farming.main.instances.tiles.DirtTile;
import com.farming.main.scenes.FarmingScene;

public class ShopButton extends GUIButton {
	
	
	public ShopButton(int x, int y) {
		super(x, y);
		this.setSprite("images/buttons/shopbutton.png");
	}
	
	

	public void tick(){
		if(this.leftClick()){
			GUIWindow shopwindow = new GUIWindow((GameEngine.RENDERSIZE.width/2)-350/2,(GameEngine.RENDERSIZE.height/2)-300/2, 350, 300);
			
			WindowLabel label = new WindowLabel(shopwindow.width/2-16,32,"Shop",Color.black);
			
			
			
			ShopBuyButton buyAppleTree = new ShopBuyButton(16,64);
			buyAppleTree.setProduct(new AppleTree(0,0));
			buyAppleTree.price = 50;
			WindowLabel AppleTreeLabel = new WindowLabel(16,64,"Apple Tree "+buyAppleTree.price+"$",Color.black);
			
			
			ShopBuyButton buyBerryBush = new ShopBuyButton(16,64*2);
			buyBerryBush.setProduct(new BerryBush(0,0));
			buyBerryBush.price = 40;
			WindowLabel berryBushLabel = new WindowLabel(16,64*2,"Berry Bush "+buyBerryBush.price+"$",Color.black);
			
			ShopBuyButton buyGrass = new ShopBuyButton(16,64*3);
			buyGrass.setProduct(new DirtTile(0,0));
			buyGrass.price = 16;
			WindowLabel buyGrassLabel = new WindowLabel(16,64*3,"Dirt"+buyGrass.price+"$",Color.black);
			
			
			shopwindow.components.add(label);
			shopwindow.components.add(AppleTreeLabel);
			shopwindow.components.add(buyAppleTree);
			shopwindow.components.add(buyBerryBush);
			shopwindow.components.add(berryBushLabel);
			shopwindow.components.add(buyGrass);
			shopwindow.components.add(buyGrassLabel);
			
			FarmingScene.newRawWindow(shopwindow);
			GameEngine.mouse_left = false;
		}
		
		
		
		
	}

}
