package entities;

import java.util.HashMap;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

public abstract class Entity {

	public static enum TYPE {
		PLAYER, ENEMY, COIN, TILE
	};

	protected Point2D m_position;
	protected ImageView m_sprite;

	public Entity() {
		m_position = new Point2D(0, 0);
		m_sprite = new ImageView();
	}

	abstract public TYPE getType();

	public void update(double dt) {
		m_sprite.setTranslateX(m_position.getX());
		m_sprite.setTranslateY(m_position.getY());
	}

	public Point2D getPosition() {
		return m_position;
	}

	public void setPosition(Point2D m_position) {
		this.m_position = m_position;
	}

	public void setPositionFromMap(Point2D position) {
		m_position = new Point2D(Tile.WIDTH * position.getX(), Tile.HEIGHT * position.getY());
	}

	public ImageView getSprite() {
		return m_sprite;
	}

	public void setSprite(ImageView sprite) {
		m_sprite = sprite;
	}

	public void setViewport(Rectangle2D viewport) {
		m_sprite.setViewport(viewport);
	}

	abstract public void handleEvents(double dt, HashMap<KeyCode, Boolean> kbPressed);
}
