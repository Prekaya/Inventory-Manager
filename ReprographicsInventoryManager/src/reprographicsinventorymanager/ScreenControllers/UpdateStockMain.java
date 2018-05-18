/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reprographicsinventorymanager.ScreenControllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

/**
 *
 * @author Adjei-Tawiah_a
 */
public class UpdateStockMain extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/com/ListView.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("ListView");
        stage.setScene(scene);
        stage.show();
        }

        
        
  
   
    
}
