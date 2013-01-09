package me.bevilacqua.game.gfx;

public class Sprite {
	
	public int size;
	protected int x;
	protected int y;
	public int[] pixels;
	protected SpriteSheet sheet;
	public String name;
	public boolean isTrans = false;
	private static int voidColor = 0x666666;
	
	public static final Sprite Beam_Light = new Sprite(SpriteSheet.SolidTiles, 16 , 0, 0, "Beam_Light");
	public static final Sprite Beam_Dark = new Sprite(SpriteSheet.SolidTiles, 16 , 1 , 0 , "Beam_Dark");
	public static final Sprite Test_Sprite = new Sprite(SpriteSheet.SolidTiles, 16 , 2 , 0 , "Test_Sprite");
	
	public static final Sprite Fire_Barrel = new Sprite(SpriteSheet.SolidTiles, 16 , 3 , 0 , "Fire_Barrel");

	public static final Sprite Lava_Test = new Sprite(0xff2f00 , "Lava_Test");
	public static final Sprite DarkNess = new Sprite(0x000000 , "DarkNess");
	public static final Sprite DarkDirt = new Sprite(0x542100 , "DarkDirt");
	public static final Sprite VOID = new Sprite();
	
	//Player Sprites
		//DefaultPlayer (There will be many)
		public static final Sprite DefaultPlayer0 = new Sprite(SpriteSheet.DefaultPlayer , 16 , 0 , 0 , "-DefaultPlayer0");
		public static final Sprite DefaultPlayer1 = new Sprite(SpriteSheet.DefaultPlayer , 16 , 0 , 1 , "-DefaultPlayer1");

	
	public Sprite() {
		this.name = "void";
		pixels = new int [16 * 16];

		this.size = 16;
		
		for(int y = 0 ; y < size ; y++) {
			for(int x = 0 ; x < size ; x++) {
				
				pixels[x + y * size] = voidColor;
			}
		}
		System.out.println("Void Sprite Loaded");
	}
	
	public Sprite(SpriteSheet sheet , int size , int x , int y  , String name , boolean isTrans) {
		this.size = size;
		this.isTrans = true;
		pixels = new int[size * size]; //Creates a pixel array the size of the sprite
		this.x = x * size; //* size so it moves over an entire tile over
		this.y = y * size; //
		this.sheet = sheet;
		this.name = name;
		load();
	}
	
	public Sprite(int color , String name) {
		this.name = name;
		pixels = new int [16 * 16];

		this.size = 16;
		
		for(int y = 0 ; y < size ; y++) {
			for(int x = 0 ; x < size ; x++) {
				
				pixels[x + y * size] = color;
			}
		}
		System.out.println(name + "(Sprite) Loaded");
	}
	
	public Sprite(SpriteSheet sheet , int size , int x , int y  , String name) {
		this.size = size;
		pixels = new int[size * size]; //Creates a pixel array the size of the sprite
		this.x = x * size; //* size so it moves over an entire tile over
		this.y = y * size; //
		this.sheet = sheet;
		this.name = name;
		load();
	}
	
	public static int getSize(Sprite sprite) {
		return sprite.size;
	}
	
	public void load() {
		for(int y = 0 ; y < size ; y++) {
			for(int x = 0 ; x < size ; x++) {
				pixels[x + y * size] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
			}
		}
		System.out.println(this.name + " (Sprite) Loaded | Size: " + Sprite.getSize(this));
	}

	public int getVoidColor() {
		return voidColor;
	}

	public static void setVoidColor(int Color) {
		voidColor = Color;
	}

}