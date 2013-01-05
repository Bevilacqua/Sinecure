package me.bevilacqua.game.entity;

import java.util.Random;

import me.bevilacqua.game.gfx.Screen;
import me.bevilacqua.game.gfx.level.Level;

public abstract class Entity {
	
	protected int x , y; //location of mob
	private boolean removed; //has it been removed from the game
	protected Level level;
	protected Random random = new Random();
	
	public void tick() {
	}
	
	public void render(Screen screen) {

	}

	
//Getters/Setters	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public boolean isRemoved() {
		return removed;
	}

	public void setRemoved(boolean removed) {
		this.removed = removed;
	}
}
