package entities;

import java.util.HashMap;

import com.sun.prism.image.ViewPort;

import javafx.geometry.Point2D;
import javafx.geometry.Rectangle2D;

public class Tile extends Entity {

	public static enum SPRITE {
		ROCK,
		LADDER
	};
	public static HashMap<SPRITE, Rectangle2D> spritesViewports = new HashMap<>();

	private static int WIDTH = 20;
	private static int HEIGHT = 20;
	
	private boolean m_ladder;
	private boolean m_transparent;
	
	public static void loadSpritesViewports()
	{
		spritesViewports.put(SPRITE.ROCK, new Rectangle2D(504, 288, 70, 70));
		spritesViewports.put(SPRITE.LADDER, new Rectangle2D(504, 144, 70, 70));
	}
	
	public Tile() {
		super();
		m_ladder = false;
		m_transparent = false;
	}

	@Override
	public void update(double dt) {
		
		//m_position = m_position.add(50 * dt, 0);
		
		m_sprite.setTranslateX(m_position.getX());
		m_sprite.setTranslateY(m_position.getY());
	}

	@Override
	public void render() {
		// #OSBLC
		
	}

	@Override
	public TYPE getType() {
		return TYPE.TILE;
	}

	@Override
	public void setPosition(Point2D position) {
		m_position = new Point2D(WIDTH * position.getX(), HEIGHT * position.getY());
	}
	
	public void setViewport(SPRITE viewport) {
		m_sprite.setViewport(spritesViewports.get(viewport));
	}

}
