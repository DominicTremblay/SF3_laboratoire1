package application;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Exercice2 extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Group root = new Group();

			Label etiquette = new Label("Test Interface Graphique");
			Button btnQuitter = new Button("Quitter");
			Button btnOk = new Button("OK");
			Button btnAnnuler = new Button("Annuler");

			etiquette.setLayoutX(20);
			etiquette.setLayoutY(30);

			btnQuitter.setLayoutX(30);
			btnQuitter.setLayoutY(60);
			btnOk.setLayoutX(10);
			btnOk.setLayoutY(150);

			root.setTranslateX(100);
//			btn.setRotate(45);

			root.getChildren().add(etiquette);
			root.getChildren().add(btnQuitter);
			
			NumberBinding layX = btnOk.layoutXProperty().add(btnOk.widthProperty().add(10));
			btnAnnuler.layoutXProperty().bind(layX);
			btnAnnuler.layoutYProperty().bind(btnOk.layoutYProperty());
			root.getChildren().addAll(btnOk, btnAnnuler);

			Scene scene = new Scene(root, 320, 200);

			primaryStage.setScene(scene);
			primaryStage.setTitle("Exercice 2");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
