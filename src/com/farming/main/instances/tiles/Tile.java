package com.farming.main.instances.tiles;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.S2DGL.engine.GameEngine;
import com.S2DGL.engine.Instance;
import com.S2DGL.engine.Mouse;
import com.farming.instances.Plant;
import com.farming.main.Game;

public class Tile extends Instance {

	private boolean isPlanted = false;
	public Tile(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	public void draw(Graphics g){
		int mousex = Mouse.getMousePositionInScene(Game.engine).x;
		int mousey = Mouse.getMousePositionInScene(Game.engine).y+16;
		this.drawDefaultSprite(g);

		if(mousex >= x && mousex < x+32 && mousey > y && mousey < y+32){
			g.setColor(Color.BLUE);
			Graphics2D g2d = (Graphics2D) g;
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,0.5f));
			g.fillRect(x, y, 32, 32);
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1f));

			if(GameEngine.vk_shift){
				if(GameEngine.mouse_left){

					if(Game.boughtInstance != null){
						Instance instance = Game.boughtInstance;


						if(!(instance instanceof Tile)){
							if (isPlanted == false){
								instance.x = x+16-instance.sprite.images.get(instance.sprite.spriteIndex).getWidth(null)/2;
								instance.y = y+16-instance.sprite.images.get(instance.sprite.spriteIndex).getHeight(null)/2;;

								if(instance.sprite.images.get(instance.sprite.spriteIndex).getHeight(null)> 32){
									instance.y = y-sprite.images.get(sprite.spriteIndex).getHeight(null);
								}
								isPlanted = true;
								GameEngine.getCurrentScene().instantiate(instance);
								Game.clearBoughtInstance();
							}
						}else{
							instance.x = x;
							instance.y = y;
							Tile tile = (Tile) instance;
							tile.isPlanted = isPlanted;
							GameEngine.getCurrentScene().replaceInstance(this, tile);
							Game.clearBoughtInstance();
							
						}
						
						GameEngine.mouse_left = false;


					}


				}
			}
		}
	}





}
