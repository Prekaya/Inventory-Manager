/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprographicsinventorymanager.ScreenControllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import reprographicsinventorymanager.ReprographicsInventoryManager;

/**
 * FXML Controller class
 *
 * @author ADDO_a
 */
public class LoginScreenController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML private AnchorPane pane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    
    @FXML
    public void signIn() throws Exception {
        ReprographicsInventoryManager.Instance.goToScreen("Screens/SearchInventoryScreen.fxml");
    }

}
