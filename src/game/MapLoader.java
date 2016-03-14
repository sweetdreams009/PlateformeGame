package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Coin;
import entities.Entity;
import entities.Player;
import entities.Tile;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

public class MapLoader {

	public static List<Entity> load(String filepath) {
		Scanner scanner;
		try {
			scanner = new Scanner(new File(filepath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}

		List<Entity> entities = new ArrayList<>();
		int i = 0, j = 0;

		scanner.useDelimiter("");
		while (scanner.hasNext()) {
			String token = scanner.next();

			switch (token) {
			case "=": // Délimitations du niveau
				break;
			case "J": // Le joueur
			{
				Player tileTmp = new Player();
				tileTmp.setSprite(new ImageView(TextureManager.getInstance().getTextures(TextureManager.SHEET.PLAYER)));
				tileTmp.setViewport(TextureManager.tilesViewports.get(TextureManager.PLAYER_VIEWPORT.STAND));
				tileTmp.setPositionFromMap(new Point2D(i, j));
				entities.add(tileTmp);
			}
				break;
			case "-": // Une plateforme
			{
				Tile tileTmp = new Tile();
				tileTmp.setSprite(new ImageView(TextureManager.getInstance().getTextures(TextureManager.SHEET.TILES)));
				tileTmp.setViewport(TextureManager.tilesViewports.get(TextureManager.TILES_VIEWPORT.ROCK));
				tileTmp.setPositionFromMap(new Point2D(i, j));
				entities.add(tileTmp);
			}
				break;
			case "H": // Une échelle
			{
				Tile tileTmp = new Tile();
				tileTmp.setSprite(new ImageView(TextureManager.getInstance().getTextures(TextureManager.SHEET.TILES)));
				tileTmp.setViewport(TextureManager.tilesViewports.get(TextureManager.TILES_VIEWPORT.LADDER));
				tileTmp.setPositionFromMap(new Point2D(i, j));
				entities.add(tileTmp);
			}
				break;
			case "P": // Une pièce
			{
				Coin coinTmp = new Coin();
				coinTmp.setSprite(new ImageView(TextureManager.getInstance().getTextures(TextureManager.SHEET.TILES)));
				coinTmp.setViewport(TextureManager.tilesViewports.get(TextureManager.TILES_VIEWPORT.COIN));
				coinTmp.setPositionFromMap(new Point2D(i, j));
				entities.add(coinTmp);
			}
				break;
			case "L": // Un ennemi vers la gauche
				break;
			case "R": // Un ennemi vers la droite
				break;
			case "\n": // On change de ligne
				j++;
				i = -1;
				break;
			}

			i++;
		}
		System.out.println("size : " + entities.size());

		scanner.close();

		return entities;
	}
}
