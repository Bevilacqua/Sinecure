package me.bevilacqua.game.gfx;

import me.bevilacqua.game.MainGame;

public class BasicTransSprite extends Sprite {
	
	public BasicTransSprite(SpriteSheet sheet , int size , int x , int y  , String name , boolean isTrans) {
		super(sheet, size, x , y , name , isTrans);
	}
	
	protected void load() {
		for(int y = 0 ; y < size ; y++) {
			for(int x = 0 ; x < size ; x++) {
				if (sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE] != 0xffFF00FF) pixels[x + y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
				else pixels[x + y * size] = MainGame.getFill();
			}
		}
		System.out.println(this.name + " (TransparentTypeSprite) Loaded | Size: " + Sprite.getSize(this));
	}
}

