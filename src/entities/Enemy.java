package entities;

import java.util.HashMap;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class Enemy extends Entity {

	private Point2D m_speed;
	private Point2D m_direction;

	public Enemy() {
		super();
		m_speed = new Point2D(0, 0);
		m_direction = new Point2D(1, 0);
	}

	@Override
	public void update(double dt) {

		super.update(dt);
	}

	@Override
	public TYPE getType() {
		return TYPE.ENEMY;
	}

	public void handleEvents(double dt, HashMap<KeyCode, Boolean> kbPressed) {
	}
}
