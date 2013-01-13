package me.bevilacqua.game.entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.imageio.ImageIO;

import me.bevilacqua.game.InputHandler;
import me.bevilacqua.game.MainGame;
import me.bevilacqua.game.gfx.Screen;
import me.bevilacqua.game.gfx.Sprite;

public class Player extends Mob {
	
	private InputHandler input;
	private int imageId = 0;
	private Random random = new Random();
	
	
	public Player(InputHandler input) { //Mouse Later
		this.input = input;
	}
	
	public Player(int x , int y , InputHandler input) { 
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void tick() {	
		int xa  = 0 , ya = 0;
		if(input.up) ya--; 
		if(input.down) ya++; 
		if(input.left) xa--;
		if(input.right) xa++; 
		if(input.screen_shot) {
			imageId = random.nextInt(9999);
			try {
				imageId = random.nextInt(9999);
				String OS = System.getProperty("os.name");
				if(OS.startsWith("Windows")) {
					String userHome = System.getProperty( "user.home" );
					String fullPath = userHome+File.separator+"Desktop"+File.separator+"Sinecure_" + imageId + ".png";
					ImageIO.write(MainGame.image, "png" , new File(fullPath));
					System.out.println("Image Saved as Sinecure_" + imageId);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(xa != 0 || ya != 0) move(xa , ya);
	}
	
	public void render(Screen screen ) {
		if(this.dir == 0) screen.renderPlayer(x , y ,Sprite.DefaultPlayerForward); //TODO: find better way to render player because there are going to be multiple types of the player
		if(this.dir == 1) screen.renderPlayer(x , y ,Sprite.DefaultPlayerLeft);
		if(this.dir == 2) screen.renderPlayer(x , y ,Sprite.DefaultPlayerRight);
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

}
