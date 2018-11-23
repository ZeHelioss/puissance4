package puissance4.vue;

import exemplecode.ExempleGlisserDeposer;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.Light;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import puissance4.controleur.ControleurPuissance4;
import puissance4.modele.Modele;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.service.query.impl.NodeQueryUtils.hasText;


public class TestsFonctionnelsVue extends ApplicationTest {

    private Parent parent;

    // Commentaire test commit automatique  TEST
    @Override
    public void start(Stage stage) {
        Scene scene;
        Vue vue = new Vue();
        ControleurPuissance4 controleur = new ControleurPuissance4();
        // lier la vue et le modele au controleur */
        controleur.setVue( vue );
        controleur.setModele( new Modele() );

        parent = vue;
        scene = new Scene(parent
                , 500, 500, Color.GREY);
        stage.setScene(scene);
        stage.show();
    }


    @Test
    public void testLacher7pionsDansColonne1EtVerifierAffichageColonnePleine()
    {
        for( int coup=0; coup<7; coup++) {
            //drag("#pion-curseur").dropTo(new Point2D( 300 , 40 ));
            clickOn("#btn-jouer-coup");
        }
        // Message
        String message = ((Vue)parent).lireAvertissement();
        assertEquals( "La colonne 1 est pleine", message );
    }


}
