package me.bevilacqua.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

public class InputHandler implements KeyListener{

	private boolean[] keys = new boolean[120];
	public long current , last = -1;
	public boolean up , down , left , right , screen_shot;
	public boolean shotFlag = true; //True if allowed
	
	public void tick() {
		up =  keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];    //Will be Jump
		down =  keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];  //Will not be down but maybe slide or better yet action key or maybe shoot
		left =  keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];
		right =  keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];	
		screen_shot = keys[KeyEvent.VK_F5];
	}
	
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() != KeyEvent.VK_F5) keys[e.getKeyCode()] = true;
		else if (e.getKeyCode() == KeyEvent.VK_F5 && shotFlag) {
			keys[e.getKeyCode()] = true;
			shotFlag = false;
		}
		

	}
	
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
		if(e.getKeyCode() == KeyEvent.VK_F5) shotFlag = true;
	}

	public void keyTyped(KeyEvent e) {	
	}
	
	
}
