package me.bevilacqua.game.gfx.level.tiles;

import me.bevilacqua.game.gfx.Screen;
import me.bevilacqua.game.gfx.Sprite;

public abstract class Tile {
	
	public int x , y; //location in sprite sheet
	public Sprite sprite;	
	protected boolean solid;
	private int LevelColor;
	protected byte id;
	
    public static final Tile[] tiles = new Tile[256];
	//Tiles Below
    public static final Tile VOID = new BasicTile((byte) 0 , Sprite.VOID, 0xffffff); //NOTICE: WHITE 
    public static final Tile Transparent = new BasicTile((byte) 1 , Sprite.VOID, 0xffffff); //NOTICE: WHITE 

    public static final Tile DARKNESS = new BasicTile((byte) 2 , Sprite.DarkNess , 0xff000000);
    public static final Tile LAVA_TEST = new BasicTile((byte) 3 , Sprite.Lava_Test , 0xffff2f00);
    public static final Tile DARK_DIRT = new BasicTile((byte) 4 , Sprite.DarkDirt , 0xff542100);
    
    public static final Tile BEAM_LIGHT = new BasicSolidTile((byte) 5 , Sprite.Beam_Light, 0xff808080); //NOTICE: DO NOT FORGET TO CANCEL OUT ALPHA CHANEL ADD FF TO HEX VAL
	public static final Tile BEAM_DARK = new BasicSolidTile((byte) 6 , Sprite.Beam_Dark, 0xff404040);
	public static final Tile TEST = new BasicTile((byte) 7 , Sprite.Test_Sprite , 0xffFFFF00);
	public static final Tile FIRE_BARREL = new BasicSolidTile((byte) 8 , Sprite.Fire_Barrel , 0xffFF0000); //TODO: Right now it just has a grey background this needs to be transparent to account for different backrgounds 
	
	
	public Tile(byte id , Sprite sprite , boolean solid , int LevelColor) {
		this.id = id;
		if(tiles[id] != null) throw new RuntimeException("Duplicate tile id on " + id);
		this.sprite = sprite;
		this.solid = solid;
		this.LevelColor = LevelColor;
		tiles[id] = this;
	}
	
	public abstract void tick();
	
	public abstract void render(int x , int y , Screen screen);
	
	public boolean isSolid(){
		return solid;
	}

	public int getLevelColor() {
		return LevelColor;
	}

	public int getId() {
		return id;
	}
}