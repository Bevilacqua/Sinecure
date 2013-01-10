package me.bevilacqua.game.gfx.level;

import me.bevilacqua.game.MainGame;
import me.bevilacqua.game.gfx.Screen;
import me.bevilacqua.game.gfx.Sprite;
import me.bevilacqua.game.gfx.level.tiles.Tile;

public class Level {

	protected static int width;
	protected static int height;
	protected byte[] tilez;
	protected String name;
	
	//Pre-MadeLevels
//	public static final Level TEST_LEVEL = new LoadableLevel("/Levels/Test.png" , "TEST_LEVEL"); 

	public Level(int width, int height , String name , int background) {
		this.width = width;
		this.height = height;
		MainGame.setFill(background);
		Sprite.setVoidColor(background);
		this.name = name;
		tilez = new byte[this.width * this.height];
		generateLevel();
	}

	public Level(String path , String name , int background) {
		this.name = name;
		MainGame.setFill(background);
		loadLevel(path);
	}

	protected void generateLevel() {
	}

	private void loadLevel(String path) {	
	}

	public void update() {
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);

		int x0 = xScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for(int y = y0; y < y1; y++) {
			for(int x = x0; x < x1; x++) {
				if(getTile(x , y) != Tile.VOID)
					getTile(x, y).render(x, y, screen);
			}
		}
	}

	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= width || y >= height) return Tile.VOID;
		
		if(tilez[x + y * width ] == Tile.BEAM_LIGHT.getId()) return Tile.BEAM_LIGHT;
		if(tilez[x + y * width ] == Tile.BEAM_DARK.getId()) return Tile.BEAM_DARK;
		if(tilez[x + y * width] == Tile.TEST.getId()) return Tile.TEST;
		if(tilez[x + y * width] == Tile.DARKNESS.getId()) return Tile.DARKNESS;
		if(tilez[x + y * width] == Tile.LAVA_TEST.getId()) return Tile.LAVA_TEST;
		if(tilez[x + y * width] == Tile.FIRE_BARREL.getId()) return Tile.FIRE_BARREL;
		if(tilez[x + y * width] == Tile.DARK_DIRT.getId()) return Tile.DARK_DIRT;
		if(tilez[x + y * width] == Tile.Transparent.getId()) return Tile.Transparent;

		return Tile.VOID;
		
	}

	public static int getSize(Level level) {
		return level.width;
	}

	public static int getWidth(LoadableLevel loadableLevel) {
		return width;
	}
	
	public static int getHeight(LoadableLevel loadableLevel) {
		return height;
	}

}