package game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PlateformGame extends Application {
	static double lastTime = 0.0;
	static World world;
	static Scene scene;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		world = new World();
		scene = new Scene(world.getRootNode(), World.WIDTH, World.HEIGHT);
		scene.setFill(Color.SKYBLUE);

		stage.setScene(scene);

		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			if (key.getCode() == KeyCode.RIGHT) {
				world.setKbPress(KeyCode.RIGHT, true);
			}
			if (key.getCode() == KeyCode.LEFT) {
				world.setKbPress(KeyCode.LEFT, true);
			}
			if (key.getCode() == KeyCode.UP) {
				world.setKbPress(KeyCode.UP, true);
			}
			if (key.getCode() == KeyCode.DOWN) {
				world.setKbPress(KeyCode.DOWN, true);
			}
			if (key.getCode() == KeyCode.SPACE) {
				world.setKbPress(KeyCode.SPACE, true);
			}
		});
		scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			if (key.getCode() == KeyCode.RIGHT) {
				world.setKbPress(KeyCode.RIGHT, false);
			}
			if (key.getCode() == KeyCode.LEFT) {
				world.setKbPress(KeyCode.LEFT, false);
			}
			if (key.getCode() == KeyCode.UP) {
				world.setKbPress(KeyCode.UP, false);
			}
			if (key.getCode() == KeyCode.DOWN) {
				world.setKbPress(KeyCode.DOWN, false);
			}
			if (key.getCode() == KeyCode.SPACE) {
				world.setKbPress(KeyCode.SPACE, false);
			}
		});

		final long startNanoTime = System.nanoTime();

		new AnimationTimer() {
			public void handle(long currentNanoTime) {
				double time = (currentNanoTime - startNanoTime) / 1000000000.0;
				double dt = time - lastTime;
				lastTime = time;

				world.update(dt);
			}
		}.start();

		stage.show();
	}

}
