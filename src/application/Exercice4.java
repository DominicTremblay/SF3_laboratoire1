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
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Exercice 4 - Comparaison des comportements de redimensionnement des conteneurs
 * 
 * Ce code illustre comment différents conteneurs JavaFX gèrent le redimensionnement
 * et comment contrôler précisément les tailles des composants.
 * 
 * Concepts démontrés :
 * 1. Contrôle de taille fixe vs flexible
 * 2. Comportement différent de HBox, VBox et TilePane
 * 3. Étirement et uniformisation des éléments
 */
public class Exercice4 extends Application {

    /**
     * HBOX - Disposition horizontale avec contrôle de taille
     * Démontre comment empêcher certains éléments de changer de taille
     */
    private HBox creerHBox() {
        HBox hBox = new HBox();
        
        // Configuration du conteneur
        hBox.setPadding(new Insets(30));           // Espacement interne de 30px
        hBox.setSpacing(10);                       // 10px entre chaque élément
        
        // Bordure cyan pour visualiser les limites du conteneur
        hBox.setBorder(new Border(new BorderStroke(
            Color.CYAN,                            // Couleur cyan
            BorderStrokeStyle.SOLID,               // Ligne continue
            new CornerRadii(10),                   // Coins arrondis
            new BorderWidths(15)                   // Épaisseur de 15px
        )));
        
        // Alignement central de tous les éléments
        hBox.setAlignment(Pos.CENTER);

        // Création des boutons avec des textes de longueurs variées
        Button btn1 = new Button("bouton 1");
        Button btn2 = new Button("bouton 2");
        Button btn3 = new Button("bouton 3 a un nom long");
        Button btn4 = new Button("4");
        Button btn5 = new Button("un bouton avec une taille...");
        
        // Bouton avec taille fixe explicite
        btn5.setPrefSize(180, 60);  // Largeur 180px, hauteur 60px

        // TextField flexible (s'adapte selon le contenu et l'espace disponible)
        TextField txt1 = new TextField("peut changer de taille");
        
        // TextField à taille FIXE (ne changera jamais de largeur)
        TextField txt2 = new TextField("ne peut changer de taille");
        /*
         * TECHNIQUE DE VERROUILLAGE DE TAILLE :
         * En définissant min, pref et max à la même valeur,
         * l'élément ne pourra jamais changer de largeur
         */
        txt2.setMinWidth(200);   // Largeur minimale
        txt2.setPrefWidth(200);  // Largeur préférée  
        txt2.setMaxWidth(200);   // Largeur maximale
        // Résultat : largeur toujours égale à 200px

        hBox.getChildren().addAll(btn1, btn2, txt1, btn3, txt2, btn4, btn5);
        return hBox;
    }

    /**
     * VBOX - Disposition verticale avec étirement maximal
     * Tous les boutons s'étirent pour occuper toute la largeur disponible
     */
    private VBox creerVBox() {
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(50));  // Espacement interne plus large
        vBox.setSpacing(10);              // Espacement entre éléments

        Button btn1 = new Button("bouton 1");
        Button btn2 = new Button("bouton 2");
        Button btn3 = new Button("bouton 3 a un nom long");
        Button btn4 = new Button("4");
        Button btn5 = new Button("encore un bouton");

        /*
         * ÉTIREMENT MAXIMAL DANS VBOX :
         * setMaxWidth(Double.MAX_VALUE) force chaque bouton à occuper
         * toute la largeur disponible du conteneur, peu importe son contenu textuel
         */
        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn4.setMaxWidth(Double.MAX_VALUE);
        btn5.setMaxWidth(Double.MAX_VALUE);

        vBox.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        return vBox;
    }

    /**
     * TILEPANE - Grille uniforme avec uniformisation forcée
     * Tous les éléments auront exactement la même taille dans leurs tuiles
     */
    private TilePane creerTilePane() {
        TilePane tPane = new TilePane();
        tPane.setPadding(new Insets(20));     // Espacement interne
        tPane.setHgap(12);                    // Espacement horizontal entre tuiles
        tPane.setPrefColumns(5);              // 5 colonnes préférées
        tPane.setAlignment(Pos.CENTER);       // Centrage du contenu des tuiles

        Button btn1 = new Button("bouton 1");
        Button btn2 = new Button("bouton 2");
        Button btn3 = new Button("bouton 3 a un nom long");  // Texte long
        Button btn4 = new Button("4");                       // Texte court
        Button btn5 = new Button("encore un bouton");

        /*
         * UNIFORMISATION DANS TILEPANE :
         * setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE) permet aux boutons
         * de s'étendre pour remplir complètement leur tuile.
         * 
         * Particularité du TilePane : toutes les tuiles ont la même taille
         * (déterminée par l'élément le plus large/haut), donc tous les boutons
         * auront finalement exactement la même taille visuelle.
         */
        btn1.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn2.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn3.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn4.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        btn5.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        tPane.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);
        return tPane;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            /*
             * SÉLECTION DU CONTENEUR À TESTER
             * Décommentez la ligne correspondante pour tester différents comportements
             */
            // Pane root = creerHBox();      // Test du comportement horizontal
            // Pane root = creerVBox();      // Test de l'étirement vertical
            Pane root = creerTilePane();     // Test de l'uniformisation

            /*
             * SCENES AVEC DIFFÉRENTES DIMENSIONS
             * Testez différentes tailles pour observer les comportements de redimensionnement
             */
            // Scene scene1 = new Scene(root, 1000, 140);  // Large et bas
            // Scene scene2 = new Scene(root, 300, 300);   // Carré moyen
            Scene scene3 = new Scene(root, 900, 60);       // Très large et très bas

            primaryStage.setTitle("Exercice 4");
            primaryStage.setScene(scene3);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}