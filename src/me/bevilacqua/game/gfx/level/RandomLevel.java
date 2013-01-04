package me.bevilacqua.game.gfx.level;

import java.util.Random;

import me.bevilacqua.game.gfx.Screen;

public class RandomLevel extends Level{

	private static final Random random = new Random();
	
	public RandomLevel(int width, int height, String Name , int background , String forground) {
		super(width, height, Name, background , forground);
	}

	protected void generateLevel() {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				tilez[x + y * width] = (byte) random.nextInt(7);
			}
		}
		System.out.println(this.name + " (Level) Generated | Size " + width + " , " + height);
	}
	
	public void update() {		
	}

	
	public void render(Screen screen, int xScroll, int yScroll) {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				tilez[x + y * width] = (byte) random.nextInt(7); 
			}
		}
	}

}
