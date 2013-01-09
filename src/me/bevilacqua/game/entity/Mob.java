package me.bevilacqua.game.entity;

import me.bevilacqua.game.gfx.Sprite;

public abstract class Mob extends Entity{

	protected Sprite sprite;
	protected int dir = 0; //0 forward , 1 left , 2 right
	protected boolean isMoving;
	
	public void move(int xChange , int yChange) {
		if(yChange > 0) dir = 0;
		if(yChange < 0) dir = 0;
		if(xChange > 0) dir = 2;
		if(xChange < 0) dir = 1;
		if(xChange == 0) dir = 0;
		
		if(!collision()) {
			x += xChange;
			y += yChange;
		}
	}
	
	public abstract void tick();
	
	public void render() {
	}
	
	private boolean collision() {
		return false;
	}
}
