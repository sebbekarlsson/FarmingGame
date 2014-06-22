package com.farming.main.GUI;




import java.lang.reflect.InvocationTargetException;

import com.S2DGL.engine.GameEngine;
import com.S2DGL.engine.Instance;
import com.farming.main.Game;

public class ShopBuyButton extends WindowButton {
	public Instance instance;
	public int price = 100;


	public ShopBuyButton(int xoffset, int yoffset) {
		super(xoffset, yoffset);
		this.setSprite("images/buttons/buybutton.png");
	}


	public void tick(){
		if(leftClick()){
			if(Game.money >= price){



				try {
					//Constructor<? extends Instance> d = instance.getClass().getConstructor(instance.getClass());
					//Object dd = (Instance) d.newInstance(0,0);
					Instance ddd = (Instance) instance.getClass().getDeclaredConstructor(int.class,int.class).newInstance(0,0);
					GameEngine.mouse_left = false;
					Game.boughtInstance = (Instance) ddd;
					Game.money -= price;
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
				}





				

			}

		}

	}

	public void setProduct(Instance instance){


		this.instance = instance;


	}


}
