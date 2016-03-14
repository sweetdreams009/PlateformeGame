package entities;

import java.util.HashMap;

import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;

public class Player extends Entity {

	private Point2D m_speed;
	private Point2D m_acceleration;
	private boolean m_invisibility;
	// private double m_invisibilityCooldown;
	private int m_coins;
	private int m_life;

	public Player() {
		super();
		m_speed = new Point2D(0, 0);
		m_acceleration = new Point2D(0, 0);
		m_invisibility = false;
		m_coins = 0;
		m_life = 3;
	}

	@Override
	public void update(double dt) {

		m_position = m_position.add(m_speed.getX() * dt, m_speed.getY() * dt);

		m_sprite.setTranslateX(m_position.getX());
		m_sprite.setTranslateY(m_position.getY() - (45 - 32)); // (height
																// texture -
																// height tile)
		m_sprite.toFront();
	}

	@Override
	public TYPE getType() {
		return TYPE.PLAYER;
	}

	@Override
	public void handleEvents(double dt, HashMap<KeyCode, Boolean> kbPressed) {
		m_speed = new Point2D(0, 0);

		// VERIF COLLISIONS ! !!!!! !! !! ! !! ! !!!
		if (kbPressed.get(KeyCode.RIGHT) != null && kbPressed.get(KeyCode.RIGHT)) {
			m_speed = m_speed.add(150, 0);
		}
		if (kbPressed.get(KeyCode.LEFT) != null && kbPressed.get(KeyCode.LEFT)) {
			m_speed = m_speed.add(-150, 0);
		}
		if (kbPressed.get(KeyCode.UP) != null && kbPressed.get(KeyCode.UP)) {
			// COLLISION ECHELLE ????
			m_speed = m_speed.add(0, -100);
		}
		if (kbPressed.get(KeyCode.DOWN) != null && kbPressed.get(KeyCode.DOWN)) {
			// COLLISION ECHELLE ????
			m_speed = m_speed.add(0, 100);
		}
	}
}
