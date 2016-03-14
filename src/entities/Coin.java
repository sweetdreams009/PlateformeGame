package entities;

public class Coin extends Tile {

	public Coin() {
		super();
		m_ladder = false;
		m_transparent = true;
	}

	@Override
	public void update(double dt) {

		super.update(dt);
	}

	@Override
	public TYPE getType() {
		return TYPE.COIN;
	}
}
