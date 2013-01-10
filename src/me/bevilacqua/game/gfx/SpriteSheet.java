package me.bevilacqua.game.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public int SIZE = 0; //of sprite sheet (256)
	private int Height = 0;
	private int Width = 0;
	public int[] pixels;
	
	public static final SpriteSheet SolidTiles = new SpriteSheet("/Textures/SolidTile.png", 256);
	
	public static final SpriteSheet DefaultPlayer = new SpriteSheet("/Mobs/Player/Default.png" , 160);
	
	public SpriteSheet(String path , int size) {
		this.path = path;
		this.SIZE = size;
		pixels = new int[this.SIZE * this.SIZE];
		load();
	}
	
	public SpriteSheet(String path , int Width , int Height) {
		this.path = path;
		this.Width = Width;
		this.Height = Height;
		if(Width > Height) this.SIZE = Width;
		if(Height > Width) this.SIZE = Height;

		pixels = new int[this.Width * this.Height];
		load();
	}
	
	public static int getSize(SpriteSheet spriteSheet) {
		return spriteSheet.SIZE;
	}
	private void load() { //load the Sprite sheet
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResourceAsStream(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w); //puts the image into the pixels array
			System.out.println(pixels[0]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("SpriteSheet Loaded | Size: " + SpriteSheet.getSize(this));

	}
}
