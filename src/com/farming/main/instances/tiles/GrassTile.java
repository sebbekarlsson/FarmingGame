package com.farming.main.instances.tiles;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.S2DGL.engine.GameEngine;
import com.S2DGL.engine.Instance;
import com.S2DGL.engine.Mouse;
import com.farming.instances.Apple;
import com.farming.instances.AppleTree;
import com.farming.main.Game;

public class GrassTile extends Tile {

	public GrassTile(int x, int y) {
		super(x, y);
		this.setSprite("images/tiles/grasstile.png");
	}



}
