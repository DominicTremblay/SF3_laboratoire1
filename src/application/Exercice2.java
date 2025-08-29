package application;

import javafx.application.Application;
import javafx.beans.binding.NumberBinding;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Exercice 2 - Démonstration du positionnement manuel et des bindings JavaFX
 * 
 * Ce code illustre :
 * 1. L'utilisation du conteneur Group (positionnement absolu)
 * 2. Le positionnement manuel avec setLayoutX() et setLayoutY()
 * 3. Les transformations (translation, rotation)
 * 4. Les bindings de propriétés pour la synchronisation automatique
 */
public class Exercice2 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        try {
            /*
             * GROUP - Conteneur de base sans logique de mise en page
             * Contrairement aux autres conteneurs (HBox, VBox, etc.), Group ne gère pas
             * automatiquement la position de ses enfants. Chaque élément doit être
             * positionné manuellement avec setLayoutX() et setLayoutY().
             */
            Group root = new Group();

            // Création des contrôles de l'interface
            Label etiquette = new Label("Test Interface Graphique");
            Button btnQuitter = new Button("Quitter");
            Button btnOk = new Button("OK");
            Button btnAnnuler = new Button("Annuler");

            /*
             * POSITIONNEMENT MANUEL
             * setLayoutX() et setLayoutY() définissent la position absolue de l'élément
             * dans son conteneur parent (ici le Group).
             * Coordonnées : (0,0) = coin supérieur gauche
             */
            etiquette.setLayoutX(20);   // 20 pixels de la gauche
            etiquette.setLayoutY(30);   // 30 pixels du haut

            btnQuitter.setLayoutX(30);  // 30 pixels de la gauche
            btnQuitter.setLayoutY(60);  // 60 pixels du haut
            
            btnOk.setLayoutX(10);       // 10 pixels de la gauche
            btnOk.setLayoutY(150);      // 150 pixels du haut

            /*
             * TRANSFORMATION DU GROUPE
             * setTranslateX() déplace tout le groupe de 100 pixels vers la droite
             * C'est différent de setLayoutX() car c'est une transformation appliquée
             * APRÈS le positionnement initial de tous les enfants.
             */
            root.setTranslateX(100);
            
            /*
             * ROTATION (commentée)
             * setRotate() permettrait de faire tourner l'élément autour de son centre
             * btn.setRotate(45); // Rotation de 45 degrés
             */

            // Ajout des premiers éléments au groupe
            root.getChildren().add(etiquette);
            root.getChildren().add(btnQuitter);

            /*
             * BINDING DE PROPRIÉTÉS - Concept avancé
             * 
             * Le binding permet de lier automatiquement une propriété à une autre.
             * Ici, on calcule dynamiquement la position X du bouton "Annuler"
             * basée sur la position et la largeur du bouton "OK".
             * 
             * Formule : Position_Annuler_X = Position_OK_X + Largeur_OK + 10
             */
            NumberBinding layX = btnOk.layoutXProperty()        // Position X de btnOk
                                     .add(btnOk.widthProperty()  // + largeur de btnOk
                                     .add(10));                  // + 10 pixels d'espacement

            /*
             * APPLICATION DU BINDING
             * btnAnnuler se repositionne automatiquement si :
             * - La position de btnOk change
             * - La largeur de btnOk change (ex: changement de texte)
             */
            btnAnnuler.layoutXProperty().bind(layX);  // Position X liée au calcul
            btnAnnuler.layoutYProperty().bind(btnOk.layoutYProperty()); // Même Y que btnOk

            // Ajout des boutons avec binding
            root.getChildren().addAll(btnOk, btnAnnuler);

            /*
             * CRÉATION DE LA SCÈNE
             * Scene(conteneur, largeur, hauteur)
             * Définit la zone d'affichage de l'application
             */
            Scene scene = new Scene(root, 320, 200);

            /*
             * CONFIGURATION DE LA FENÊTRE PRINCIPALE
             */
            primaryStage.setScene(scene);              // Associe la scène à la fenêtre
            primaryStage.setTitle("Exercice 2");       // Titre de la fenêtre
            primaryStage.show();                       // Affiche la fenêtre
            
        } catch (Exception e) {
            e.printStackTrace();  // Affiche les erreurs en cas de problème
        }
    }

    /**
     * Point d'entrée de l'application JavaFX
     * launch() initialise le framework JavaFX et appelle start()
     */
    public static void main(String[] args) {
        launch(args);
    }
}