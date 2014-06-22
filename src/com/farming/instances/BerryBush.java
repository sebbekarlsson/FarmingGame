package com.farming.instances;

public class BerryBush extends Bush {

	public BerryBush(int x, int y) {
		super(x, y);
		this.setProduct(new Berry(0,0));
		this.moneyGain = 20;
	}

}
