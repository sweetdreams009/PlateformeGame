package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entities.Entity;
import entities.Tile;
import javafx.scene.Group;
import javafx.scene.input.KeyCode;

public class World {

	public static final int WIDTH_TILES = 30;
	public static final int HEIGHT_TILES = 12;
	public static final int WIDTH = Tile.WIDTH * WIDTH_TILES;
	public static final int HEIGHT = Tile.HEIGHT * HEIGHT_TILES;

	private List<Entity> m_entities;
	private Group m_rootNode;

	private HashMap<KeyCode, Boolean> m_kbPressed;
	private boolean m_kbLeftPressed;

	public World() {
		m_rootNode = new Group();
		m_entities = new ArrayList<>();
		m_kbPressed = new HashMap<>();
		init();
	}

	public Group getRootNode() {
		return m_rootNode;
	}

	public void update(double dt) {
		for (Entity entity : m_entities) {
			entity.handleEvents(dt, m_kbPressed);
			entity.update(dt);
		}
	}

	private void init() {
		TextureManager.getInstance().loadTextures();

		m_entities = MapLoader.load(":/../res/maps/map1.txt");
		if (m_entities == null) {
			System.err.println("Aucune entité chargée !");
			return;
		}
		for (Entity entity : m_entities) {
			m_rootNode.getChildren().add(entity.getSprite());
		}
	}

	public void setKbPress(KeyCode code, boolean val) {
		m_kbPressed.put(code, val);
	}
}
