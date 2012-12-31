package me.bevilacqua.game.gfx.level.tiles;

import me.bevilacqua.game.gfx.Sprite;

public class BasicSolidTile extends BasicTile{

	public BasicSolidTile(byte id, Sprite sprite, int LevelColor) {
		super(id, sprite, LevelColor);
		this.solid = true;
	}

}
