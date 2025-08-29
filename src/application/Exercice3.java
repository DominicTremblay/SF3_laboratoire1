package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercice3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Pane root = new Pane();

		BackgroundFill bgFillVert = new BackgroundFill(Color.LIGHTGREEN, new CornerRadii(10), new Insets(0));
		BackgroundFill bgFillRouge = new BackgroundFill(Color.RED, new CornerRadii(25), new Insets(30));

		BackgroundFill[] fills = { bgFillVert, bgFillRouge };

//		Background bg = new Background(bgFillVert, bgFillRouge);

		Image image = new Image(getClass().getResourceAsStream("/tournesol.png"));
		BackgroundSize bgTaille = new BackgroundSize(200, 200, false,false, false, false);
		BackgroundImage[] bgImage = { new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
				BackgroundPosition.CENTER, bgTaille) };
		Background bg = new Background(fills, bgImage);
		Background bg1 = new Background(bgImage);

		root.setBackground(bg);

		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("Exercice 3");
		primaryStage.setScene(scene);

		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);
	}
}
