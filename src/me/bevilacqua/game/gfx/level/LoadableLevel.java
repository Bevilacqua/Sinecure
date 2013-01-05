package me.bevilacqua.game.gfx.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import me.bevilacqua.game.gfx.level.tiles.Tile;

public class LoadableLevel extends Level {

	private String path;
	
	public int pixels[];

	private BufferedImage image;

	public LoadableLevel(String path, String name , int background) {
		super(path, name, background);
		this.name = name;
		this.path = path;
		
		load();
		fillTile();
	}
	
	private void load() {
        try {
            this.image = ImageIO.read(Level.class.getResource(this.path));
            this.width = ((BufferedImage) this.image).getWidth();
            this.height = ((BufferedImage) this.image).getHeight();
            tilez = new byte[width * height];
            this.fillTile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println( name +" (Level) Loaded | Width: " + Level.getWidth(this) + " , Height: " + Level.getHeight(this));
    }

    private void fillTile() {
        int[] tileColours = (this.image.getRGB(0, 0, width, height, null, 0, width));
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                for (Tile t : Tile.tiles) {
                  tileCheck:  if (t!= null && t.getLevelColor() == tileColours[x + y * width]) {
			                        this.tilez[x + y * width] = (byte) t.getId();
			                        break tileCheck;
                    }
                }
            }
        }
    }
}