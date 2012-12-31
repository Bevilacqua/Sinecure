package me.bevilacqua.game.gfx.level.tiles;

import me.bevilacqua.game.gfx.Screen;
import me.bevilacqua.game.gfx.Sprite;

public class BasicTile extends Tile{

	public BasicTile(byte id , Sprite sprite , int LevelColor) {
		super(id , sprite, false, LevelColor);
	}

	
	public void tick() {		
	}

	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
}
