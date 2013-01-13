package me.bevilacqua.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener{

	private boolean[] keys = new boolean[120];
	public boolean up , down , left , right , screen_shot;
	
	public void tick() {
		up =  keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];    //Will be Jump
		down =  keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];  //Will not be down but maybe slide or better yet action key or maybe shoot
		left =  keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right =  keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];	
		screen_shot = keys[KeyEvent.VK_F] || keys[KeyEvent.VK_F];
	}
	
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;

	}

	public void keyTyped(KeyEvent e) {
		
	}
	
}
