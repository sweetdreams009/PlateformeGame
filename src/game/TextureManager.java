package game;

import java.util.HashMap;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

public class TextureManager {
	public static enum SHEET {
		TILES, PLAYER
	};

	public static enum TILES_VIEWPORT {
		ROCK, LADDER, COIN
	};

	public static enum PLAYER_VIEWPORT {
		STAND
	}

	public static HashMap<TILES_VIEWPORT, Rectangle2D> tilesViewports = new HashMap<>();
	public static HashMap<PLAYER_VIEWPORT, Rectangle2D> playerViewports = new HashMap<>();

	public static void loadViewports() {
		tilesViewports.put(TILES_VIEWPORT.ROCK, new Rectangle2D(0, 0, 32, 32));
		tilesViewports.put(TILES_VIEWPORT.LADDER, new Rectangle2D(33, 0, 32, 32));
		tilesViewports.put(TILES_VIEWPORT.COIN, new Rectangle2D(66, 0, 32, 32));

		playerViewports.put(PLAYER_VIEWPORT.STAND, new Rectangle2D(0, 0, 32, 32));
	}

	private HashMap<SHEET, Image> m_textures;
	private static TextureManager instance;

	public static TextureManager getInstance() {
		if (instance == null) {
			instance = new TextureManager();
		}
		return instance;
	}

	private TextureManager() {
		m_textures = new HashMap<>();
	}

	public Image getTextures(SHEET sheet) {
		return m_textures.get(sheet);
	}

	public void loadTextures() {
		m_textures.put(SHEET.TILES, new Image("file:/../res/tiles-spritesheet.png"));
		m_textures.put(SHEET.PLAYER, new Image("file:/../res/player-spritesheet.png"));
		loadViewports();
	}
}
