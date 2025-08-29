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
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeLineCap;
import javafx.scene.shape.StrokeLineJoin;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 * Exercice 3 - Démonstration des arrière-plans complexes et bordures multiples
 * 
 * Ce code illustre les concepts avancés de JavaFX : 1. Arrière-plans composites
 * (couleurs + images) 2. Bordures multiples avec styles personnalisés 3.
 * Gestion des images avec dimensionnement 4. Effets de superposition et de
 * transparence
 */
public class Exercice3 extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Conteneur de base sans logique de mise en page
		Pane root = new Pane();

		/*
		 * CRÉATION D'ARRIÈRE-PLANS COLORÉS MULTIPLES
		 * 
		 * JavaFX permet de superposer plusieurs arrière-plans colorés avec des formes
		 * et positions différentes pour créer des effets visuels complexes.
		 */

		// Arrière-plan vert clair (couche externe)
		BackgroundFill bgFillVert = new BackgroundFill(Color.LIGHTGREEN, // Couleur de remplissage
				new CornerRadii(10), // Coins arrondis de 10px
				new Insets(40) // Marge de 40px sur tous les côtés
		);

		// Arrière-plan rouge (couche interne)
		BackgroundFill bgFillRouge = new BackgroundFill(Color.RED, // Couleur rouge
				new CornerRadii(25), // Coins plus arrondis (25px)
				new Insets(60) // Marge plus importante (60px)
		);

		// Tableau des arrière-plans colorés (ordre = ordre de superposition)
		BackgroundFill[] fills = { bgFillVert, bgFillRouge };

		/*
		 * Alternative simplifiée (commentée) : Background bg = new
		 * Background(bgFillVert, bgFillRouge); Cette syntaxe fait la même chose mais de
		 * manière plus concise.
		 */

		/*
		 * GESTION D'IMAGES D'ARRIÈRE-PLAN
		 */

		// Chargement de l'image depuis les ressources
		// IMPORTANT : L'image doit être dans le dossier src/main/resources ou src/
		Image image = new Image(getClass().getResourceAsStream("/tournesol.png"));

		// Configuration de la taille de l'image d'arrière-plan
		BackgroundSize bgTaille = new BackgroundSize(200, // Largeur en pixels
				200, // Hauteur en pixels
				false, // widthAsPercentage : false = pixels, true = pourcentage
				false, // heightAsPercentage : false = pixels, true = pourcentage
				false, // contain : ajuste pour contenir entièrement
				false // cover : ajuste pour couvrir entièrement
		);

		// Configuration de l'image d'arrière-plan
		BackgroundImage[] bgImage = { new BackgroundImage(image, // Image à afficher
				BackgroundRepeat.NO_REPEAT, // Pas de répétition horizontale
				BackgroundRepeat.NO_REPEAT, // Pas de répétition verticale
				BackgroundPosition.CENTER, // Centrer l'image
				bgTaille // Taille définie ci-dessus
				) };

		/*
		 * COMPOSITION DES ARRIÈRE-PLANS L'ordre de superposition : couleurs en
		 * arrière-plan, images au premier plan
		 */
		Background bg = new Background(fills, bgImage); // Couleurs + image
		Background bg1 = new Background(bgImage); // Image seule (non utilisée)

		// Application de l'arrière-plan composite au conteneur
		root.setBackground(bg);

		/*
		 * CRÉATION DE BORDURES MULTIPLES AVEC STYLES PERSONNALISÉS
		 */

		// Style de bordure bleue (extérieure)
		BorderStrokeStyle styleBleu = new BorderStrokeStyle(StrokeType.CENTERED, // Type : centrée sur le bord
				StrokeLineJoin.MITER, // Jointure : angle droit aux coins
				StrokeLineCap.BUTT, // Terminaison : bout carré
				10, // Limite de jointure
				0, // Décalage des pointillés (0 = ligne continue)
				null // Tableau de pointillés (null = ligne continue)
		);

		// Style de bordure cyan (intérieure)
		BorderStrokeStyle styleCyan = new BorderStrokeStyle(StrokeType.INSIDE, // Type : à l'intérieur du bord (ne
																				// dépasse pas)
				StrokeLineJoin.MITER, // Même type de jointure
				StrokeLineCap.BUTT, // Même type de terminaison
				10, 0, null);

		/*
		 * DÉFINITION DES BORDURES AVEC LEURS PROPRIÉTÉS
		 */

		// Bordure bleue (externe)
		BorderStroke bordureBleue = new BorderStroke(Color.BLUE, // Couleur bleue
				styleBleu, // Style défini ci-dessus
				CornerRadii.EMPTY, // Coins carrés (pas d'arrondi)
				new BorderWidths(30), // Épaisseur de 30px sur tous les côtés
				new Insets(20) // Décalage de 20px vers l'intérieur
		);

		// Bordure cyan (interne)
		BorderStroke bordureCyan = new BorderStroke(Color.CYAN, // Couleur cyan
				styleCyan, // Style avec StrokeType.INSIDE
				new CornerRadii(15), // Coins arrondis de 15px
				new BorderWidths(15), // Épaisseur de 15px
				new Insets(15) // Décalage de 15px vers l'intérieur
		);

		/*
		 * COMPOSITION DES BORDURES L'ordre des BorderStroke détermine l'ordre de
		 * superposition La première bordure est dessinée en premier (arrière-plan)
		 */
		Border bordure = new Border(bordureBleue, bordureCyan);
		root.setBorder(bordure);

		/*
		 * CONFIGURATION DE LA SCÈNE ET AFFICHAGE
		 */
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setTitle("Exercice 3");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}