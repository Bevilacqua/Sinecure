package me.bevilacqua.game.entity;

import me.bevilacqua.game.InputHandler;

public class Player extends Mob {
	
	private InputHandler input;
	private int scale = 1;
	private int walkingSpeed = 1;
	
	public Player(int x , int y , InputHandler input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public Player() {
		
	}

	public void tick() {	
	}
	
	public void render() {
		int xTile = 0;
		int yTile = 0;
	}

}
