package me.bevilacqua.game.gfx;

public class Sprite {
	
	public int size;
	protected int x;
	protected int y;
	public int[] pixels;
	protected SpriteSheet sheet;
	public String name;
	private int height;
	private int width;
	private static int voidColor = 0x666666;
	
	public static final Sprite Beam_Light = new Sprite(SpriteSheet.SolidTiles, 16 , 0, 0, "Beam_Light");
	public static final Sprite Beam_Dark = new Sprite(SpriteSheet.SolidTiles, 16 , 1 , 0 , "Beam_Dark");
	public static final Sprite Test_Sprite = new Sprite(SpriteSheet.SolidTiles, 16 , 2 , 0 , "Test_Sprite");
	
	public static final Sprite Fire_Barrel = new Sprite(SpriteSheet.SolidTiles, 16 , 3 , 0 , "Fire_Barrel");

	public static final Sprite Lava_Test = new Sprite(0xff2f00 , "Lava_Test");
	public static final Sprite DarkNess = new Sprite(0x000000 , "DarkNess");
	public static final Sprite DarkDirt = new Sprite(0x542100 , "DarkDirt");
	public static final Sprite VOID = new Sprite();
	public static final Sprite Trans = new Sprite(0xff2f00 , "Transparent");
	
	//Player Sprites
		//DefaultPlayer (There will be many)
		public static final Sprite DefaultPlayerForward = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 0 , 0 , "-DefaultPlayerF");
		public static final Sprite DefaultPlayerForward_1 = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 1 , 0 , "DefaultPlayerF_1");
		public static final Sprite DefaultPlayerForward_2 = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 2 , 0 , "DefaultPlayerF_2") ;

		public static final Sprite DefaultPlayerRight = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 0 , 1 , "-DefaultPlayerR");
		public static final Sprite DefaultPlayerRight_1 = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 1 , 1 , "DefaultPlayerR_1");
		public static final Sprite DefaultPlayerRight_2 = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 2 , 1 , "DefaultPlayerR_2") ;
		
		public static final Sprite DefaultPlayerLeft = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 0 , 2 , "-DefaultPlayerL");
		public static final Sprite DefaultPlayerLeft_1 = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 1 , 2 , "DefaultPlayerL_1");
		public static final Sprite DefaultPlayerLeft_2 = new Sprite(SpriteSheet.DefaultPlayer , 16 , 32 , 2 , 2 , "DefaultPlayerL_2") ;

		

	
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

	
	public Sprite(SpriteSheet sheet , int width , int height , int x , int y  , String name) {
		this.size = height;
		this.height = height;
		this.width = width;
		pixels = new int[width * height]; //Creates a pixel array the size of the sprite
		this.x = x * this.width; //* size so it moves over an entire tile over
		this.y = y * this.height; //
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
		this.width = size;
		this.height = size;
		pixels = new int[size * size * sheet.SIZE]; //Creates a pixel array the size of the sprite
		this.x = x * size; //* size so it moves over an entire tile over
		this.y = y * size; //
		this.sheet = sheet;
		this.name = name;
		load();
	}
	
	public static int getSize(Sprite sprite) {
		return sprite.size;
	}
	
	public static int getWidth(Sprite sprite) {
		return sprite.width;
	}
	
	public static int getHeight(Sprite sprite) {
		return sprite.height;
	}
	
	public void load() {
		for(int y = 0 ; y < height ; y++) {
			for(int x = 0 ; x < width ; x++) {
				pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];
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