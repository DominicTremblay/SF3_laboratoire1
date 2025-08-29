package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercice4 extends Application {
	
	
	private HBox creerHBox() {
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(30));
		hBox.setSpacing(10);
		hBox.setBorder(new Border(
				new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(15))));
//		root.setAl
		hBox.setAlignment(Pos.CENTER);

		Button btn1 = new Button("bouton 1");
		Button btn2 = new Button("bouton 2");
		Button btn3 = new Button("bouton 3 a un nom long");
		Button btn4 = new Button("4");
		Button btn5 = new Button("un bouton avec une taille...");
		btn5.setPrefSize(180, 60);

		TextField txt1 = new TextField("peut changer de taille");
		TextField txt2 = new TextField("ne peut changer de taille");

		txt2.setMinWidth(200);
		txt2.setPrefWidth(200);
		txt2.setMaxWidth(200);

		hBox.getChildren().addAll(btn1, btn2, txt1, btn3, txt2, btn4, btn5);
		
		return hBox;
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {

			Pane root = creerHBox();

			Scene scene = new Scene(root, 1000, 140);

			primaryStage.setTitle("Exercice 4");
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
