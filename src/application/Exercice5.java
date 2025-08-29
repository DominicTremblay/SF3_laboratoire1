package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Exercice5 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			FlowPane root = new FlowPane();

			root.setOrientation(Orientation.VERTICAL);
			root.setPadding(new Insets(40));
			root.setVgap(10);
			root.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
			root.setAlignment(Pos.TOP_CENTER);

			TextField txt1 = new TextField("ceci est un champ de texte ");
			txt1.setEditable(false);
			txt1.setPrefWidth(340);
//			txt1.setMaxWidth(Double.MAX_VALUE);
			txt1.setBorder(new Border(
					new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(5))));

			TextArea txtZone = new TextArea();
			txtZone.setPrefWidth(340);
			txtZone.setText("Ceci est une zone de texte\n qui peut prendre plusieurs lignes");
			txtZone.setWrapText(true);
			txtZone.setTooltip(new Tooltip("Bulle d'aide contextuelle"));
			
			HBox hBox = new HBox();
			
			Button btnQuitter = new Button("Quitter");
			Image icone = new Image(getClass().getResourceAsStream("/exit.jpeg"));
		
			btnQuitter.setGraphic(new ImageView(icone));
			
			root.getChildren().addAll(txt1, txtZone, btnQuitter);

			Scene scene = new Scene(root, 400, 400);

			primaryStage.setScene(scene);
			primaryStage.sizeToScene();
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

	}

}
