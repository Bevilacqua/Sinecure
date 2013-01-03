package me.bevilacqua.game.gfx;

import java.util.Random;

import me.bevilacqua.game.gfx.level.tiles.Tile;

public class Screen {
	public int width;
	public int height;
	private int MAP_SIZE = 64;
	private int MAP_SIZE_MASK = MAP_SIZE - 1;
	public int[] pixels;
	
	public int xOffset , yOffset;
	
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE]; //Will be removed
	
	private Random random = new Random();
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public Screen(int width , int height) {
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
	}
	
	public void clear() { //Not needed but clears screen
		for(int i = 0 ; i < pixels.length ; i++) 
			pixels[i] = 0;
	}
	
	public void fillBackRoundSolidColor(int color) { //Not needed but clears screen
		for(int i = 0 ; i < pixels.length ; i++) 
			pixels[i] = color;
	}
	
	public void renderTile(int xPos , int yPos , Tile tile) {
		xPos -= xOffset;
		yPos -= yOffset;
		for(int y = 0 ; y < tile.sprite.size ; y++) {
			int yAbs = y + yPos;
			for(int x = 0 ; x < tile.sprite.size ; x++) {
				int xAbs = x + xPos;
				if(xAbs < -tile.sprite.size || xAbs >= width || yAbs < 0 || yAbs >= height) break;
				if(xAbs < 0) xAbs = 0;
				pixels[xAbs + yAbs * width] = tile.sprite.pixels[x + y * tile.sprite.size];
			}
		}
	}
	
	public void setOffset(int xOffset , int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}