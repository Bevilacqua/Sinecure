package me.bevilacqua.game.gfx;

public class BasicSprite extends Sprite{
	public BasicSprite(SpriteSheet sheet, int color , int x, int y, String name) {
		super(sheet , color , x , y , name);
	}
	
	public BasicSprite(int color , String name) {
		super(color , name);
	}
	
	public BasicSprite() {
		super();
	}
	
	public void load() {
		for(int y = 0 ; y < size ; y++) {
			for(int x = 0 ; x < size ; x++) {
				pixels[x + y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
		System.out.println(this.name + " (Sprite) Loaded | Size: " + Sprite.getSize(this));
	}
}
