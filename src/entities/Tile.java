package entities;

import java.util.HashMap;

import javafx.scene.input.KeyCode;

public class Tile extends Entity {

	public static int WIDTH = 32;
	public static int HEIGHT = 32;

	protected boolean m_ladder;
	protected boolean m_transparent;

	public Tile() {
		super();
		m_ladder = false;
		m_transparent = false;
	}

	@Override
	public void update(double dt) {
		super.update(dt);
	}

	@Override
	public TYPE getType() {
		return TYPE.TILE;
	}

	public void handleEvents(double dt, HashMap<KeyCode, Boolean> kbPressed) {
	}
}
