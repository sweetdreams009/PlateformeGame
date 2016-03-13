package entities;

import javafx.geometry.Point2D;

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
		
	}

	@Override
	public void render() {
		
	}

	@Override
	public TYPE getType() {
		return TYPE.PLAYER;
	}
	
}
