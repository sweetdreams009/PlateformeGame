import java.util.HashMap;

import javafx.scene.image.Image;

public class TextureManager
{
	public static enum SHEET {
		TILES,
		CHARACTERS,
		ENEMIES
	};
	
	private HashMap<SHEET, Image> m_textures;
	private static TextureManager instance;
	
	public static TextureManager getInstance()
	{
		if (instance == null) {
			instance = new TextureManager();
		}
		return instance;
	}
	
	private TextureManager()
	{
		m_textures = new HashMap<>();
	}
	
	public Image getTextures(SHEET sheet)
	{
		return m_textures.get(sheet);
	}
	
	public void loadTextures()
	{
		m_textures.put(SHEET.TILES, new Image("file:/../res/Base pack/Tiles/tiles_spritesheet.png"));
	}
}
