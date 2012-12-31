package me.bevilacqua.game.entity;

import me.bevilacqua.game.gfx.Sprite;

public abstract class Mob extends Entity{

	protected Sprite sprite;
	protected int dir = 0; //North = 0 | East = 1 | South = 2 | West = 3
	protected boolean isMoving;
	
	public void move(int xChange , int yChange) {
		if(xChange > 0) dir = 1;
		if(xChange < 0) dir = 3;
		if(yChange > 0) dir = 2;
		if(yChange < 0) dir = 0;
		
		if(!collision()) {
			x += xChange;
			y += yChange;
		}
	}
	
	public abstract void tick();
	
	public abstract void render();
	
	private boolean collision() {
		return false;
	}
}
