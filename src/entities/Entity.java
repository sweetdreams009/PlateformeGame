package entities;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public abstract class Entity {

	public static enum TYPE {
		PLAYER,
		ENEMY,
		COIN,
		TILE
	};
	
	protected Point2D m_position;
	protected ImageView m_sprite;
	
	public Entity()
	{
		m_position = new Point2D(0, 0);
		m_sprite = new ImageView();
	}
	
	abstract public TYPE getType();
	
	abstract public void update(double dt);
	
	abstract public void render();

	public Point2D getPosition() {
		return m_position;
	}

	public void setPosition(Point2D m_position) {
		this.m_position = m_position;
	}

	public ImageView getSprite() {
		return m_sprite;
	}

	public void setSprite(ImageView sprite)
	{
		m_sprite = sprite;
	}
}
