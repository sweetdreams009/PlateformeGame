import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlateformGame extends Application
{
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// définit la largeur et la hauteur de la fenêtre
		// en pixels, le (0, 0) se situe en haut à gauche de la fenêtre
		stage.setWidth(800);
		stage.setHeight(600);
		// met un titre dans la fenêtre
		stage.setTitle("Plateform Game");

		// la racine du sceneGraph est le root
		Group root = new Group();
		Scene scene = new Scene(root);
		scene.setFill(Color.BLACK);

	 Image pawnTexture = new Image("file:/../res/Base pack/Tiles/box.png");
		ImageView pawn = new ImageView();
		//pawn.setViewport(new Rectangle2D(0, 0, 24, 24));
		pawn.setImage(pawnTexture);
		root.getChildren().add(pawn);

		// ajout de la scène sur l'estrade
		stage.setScene(scene);
		// ouvrir le rideau
		stage.show();
	}

}
