package me.bevilacqua.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.text.DecimalFormat;

import javax.swing.JFrame;

import me.bevilacqua.game.entity.Player;
import me.bevilacqua.game.gfx.Screen;
import me.bevilacqua.game.gfx.level.Level;
import me.bevilacqua.game.gfx.level.LoadableLevel;

public class MainGame extends Canvas implements Runnable {
	//SIDESCROLLER!!!
	//16*16 tiles
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 420;
	private static final int HEIGHT = WIDTH / 16 * 9; // 16 * 9 maintains a 16 X 9 aspect ratio
	private static final int SCALE = 3;
	private static final String TITLE = "Ongoing";
	
	JFrame frame;
	public boolean running = false;
	
	private static Screen screen;
	private InputHandler input;
	private static Level level;
	private Player player;
	
	private int Fframes;
	private int Fticks;
	private double framePerc = 0;
	DecimalFormat df = new DecimalFormat("###.##");

		
	private BufferedImage image = new BufferedImage(WIDTH , HEIGHT , BufferedImage.TYPE_INT_RGB); //The image the game runs on but you cant edit it without a raster
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData(); //Converts the buffered image into an array of integers to hold pixel data 

	private static Dimension size = new Dimension(WIDTH * SCALE , HEIGHT * SCALE);
	
	public MainGame() {
		setSize(size);
		setPreferredSize(size);
		
		screen = (new Screen(WIDTH , HEIGHT));
		input = new InputHandler();
//		level = new RandomLevel(300 , 300 , "RandomTest" , 0x666666);
		level = new LoadableLevel("/Levels/Test.png" , "Test" , 0x666666);
//		level = new LoadableLevel("/Levels/Ben's Awesome Thing.png" , "Bens Awesome Thing" );
		
		
		player = new Player(input);
		addKeyListener(input); //kinda like frame.add
		
		frame = new JFrame();
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setTitle(TITLE);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.println("Screen Created Resolution:_ " + WIDTH * SCALE + " x " + HEIGHT * SCALE + " _:");
	}

	public static void main(String Args[]) {		
		new MainGame().start();
	}
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop() {
		running = false;
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;

		int ticks = 0;
		int frames = 0;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0;
		requestFocus();
		
		
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;
			boolean ShouldRender = false; //Too Slow? make true (Drastic Measure)
			while (delta >= 1) {
				ticks++;
				tick();
				delta--;
				ShouldRender = true; 
			}
			
			try { Thread.sleep(5); } //Too Slow? make 0 or at least lower
			catch (InterruptedException e) { e.printStackTrace(); }
			
			if (ShouldRender) {
				frames++;
				render();
			}
			
			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				framePerc = 0;
				Fframes = frames;
				Fticks = ticks;
				framePerc = (((double)Fframes / 60D)) * 100;
				frame.setTitle(TITLE + "   |" + " Frames: " + frames + " Ticks: " + ticks);
				System.out.println(TITLE + "   |" + " Frames: " + frames + " Ticks: " + ticks);
				frames = 0;
				ticks = 0;
			}
		}
	}
	
	private void tick() {
		input.tick();
		player.tick();
	}

	private static int fill;
	
	public static void setFill(int background) {
		fill = background;
	}
	
	public static int getFill() {
		return fill;
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
            createBufferStrategy(4); //Too Slow? make this 3
            return;
        }
		//Optional clearing goes below
		screen.clear();
		
		//Rendering goes below:
			screen.fillBackRoundSolidColor(fill);
			int xScroll = player.getX() - screen.width /2;
			int yScroll = player.getY() - screen.height /2;
			
			level.render(xScroll, yScroll , screen);
			player.render(screen);
		
		for (int i = 0 ; i < pixels.length ; i++) { //Sets the pixels array in MainGame to the pixel array in the Screen class
			pixels[i] = screen.pixels[i];
		}
		//Displaying goes below:
		Graphics g = bs.getDrawGraphics();
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null); //Draws the buffered image (pixels[])
		
		//FrameRate Display
		if(Fframes >= 60) g.setColor(Color.white);
		else if (Fframes >= 55) g.setColor(Color.YELLOW);
		else if (Fframes > 65 ) g.setColor(Color.GREEN);
		else g.setColor(Color.red);
		g.setFont(new Font("Verdana" , 0 , 10));
		String err = "";
		if(Fframes <= 20 || Fframes > 65) err = "| CHECK FRAMERATE |"; 
		g.drawString("(" + Fframes + ")" + " " + df.format(framePerc) + "% " + err  , 10 , HEIGHT * SCALE - 10);
		//End of FrameRateDisplay
		
//		g.drawRect(0, 141 * SCALE, 300 * SCALE + 8 , 70);
		g.dispose(); //Disposes the graphics
		bs.show(); //Shows the next buffer
	}
	
}
