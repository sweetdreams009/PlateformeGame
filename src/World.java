import java.util.ArrayList;

import entities.Entity;
import entities.Tile;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;

public class World {

	private ArrayList<Entity> m_entities;
	private Group m_rootNode;
	
	public World()
	{
		m_rootNode = new Group();
		m_entities = new ArrayList<>();
		init();
	}
	
	public Group getRootNode()
	{
		return m_rootNode;
	}
	
	public void update(double dt)
	{
		for (Entity entity : m_entities)
		{
			entity.update(dt);
		}
	}
	
	public void render()
	{
		for (Entity entity : m_entities)
		{
			entity.render();
		}
	}
	
	private void init()
	{
		TextureManager.getInstance().loadTextures();
		Tile.loadSpritesViewports();
		
		{
			Tile tileTmp = new Tile();
			tileTmp.setSprite(new ImageView(TextureManager.getInstance().getTextures(TextureManager.SHEET.TILES)));
			tileTmp.setViewport(Tile.SPRITE.ROCK);
			tileTmp.setPosition(new Point2D(0, 0));
			m_rootNode.getChildren().add(tileTmp.getSprite());
			m_entities.add(tileTmp);
		}
		{
			Tile tileTmp = new Tile();
			tileTmp.setSprite(new ImageView(TextureManager.getInstance().getTextures(TextureManager.SHEET.TILES)));
			tileTmp.setViewport(Tile.SPRITE.LADDER);
			tileTmp.setPosition(new Point2D(0, 11));
			m_rootNode.getChildren().add(tileTmp.getSprite());
			m_entities.add(tileTmp);
		}
		{
			Tile tileTmp = new Tile();
			tileTmp.setSprite(new ImageView(TextureManager.getInstance().getTextures(TextureManager.SHEET.TILES)));
			tileTmp.setViewport(Tile.SPRITE.ROCK);
			tileTmp.setPosition(new Point2D(29, 11));
			m_rootNode.getChildren().add(tileTmp.getSprite());
			m_entities.add(tileTmp);
		}
		{
			Tile tileTmp = new Tile();
			tileTmp.setSprite(new ImageView(TextureManager.getInstance().getTextures(TextureManager.SHEET.TILES)));
			tileTmp.setViewport(Tile.SPRITE.LADDER);
			tileTmp.setPosition(new Point2D(29, 0));
			m_rootNode.getChildren().add(tileTmp.getSprite());
			m_entities.add(tileTmp);
		}

	}
}
