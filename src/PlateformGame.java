import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlateformGame extends Application
{
	static double lastTime = 0.0;
	static World world;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// définit la largeur et la hauteur de la fenêtre
		// en pixels, le (0, 0) se situe en haut à gauche de la fenêtre
		stage.setWidth(35*30);
		stage.setHeight(35*12);
		// met un titre dans la fenêtre
		stage.setTitle("Plateform Game");
		
		// la racine du sceneGraph est le root
		//Group root = new Group();
		
		world = new World();
		Scene scene = new Scene(world.getRootNode());
		scene.setFill(Color.SKYBLUE);
/*
		Image pawnTexture = new Image("file:/../res/Base pack/Tiles/box.png");
		ImageView pawn = new ImageView();
		//pawn.setViewport(new Rectangle2D(0, 0, 24, 24));
		pawn.setImage(pawnTexture);
		root.getChildren().add(pawn);
*/
		// ajout de la scène sur l'estrade
		stage.setScene(scene);

		final long startNanoTime = System.nanoTime();

		new AnimationTimer()
		{
			public void handle(long currentNanoTime)
			{
				double time = (currentNanoTime - startNanoTime) / 1000000000.0; 
				double dt = time - lastTime;
				lastTime = time;

				world.update(dt);
				world.render(); // #OSBLC
			}
		}.start();


		// ouvrir le rideau
		stage.show();
	}

}
