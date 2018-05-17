package reprographicsinventorymanager;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author ADDO_a
 */
public class ReprographicsInventoryManager extends Application {
    
    FXMLLoader loader = new FXMLLoader();
    public Stage mainStage = null;
    
    public static  ReprographicsInventoryManager Instance;
    
    public Pane getResourceExternally(String path) throws IOException{
      return loader.load(getClass().getResource("Screens/LoginScreen.fxml"));  
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        if (Instance == null) Instance = this;

        AnchorPane root = loader.load(getClass().getResource("Screens/LoginScreen.fxml"));

        Scene scene = new Scene(root, 355, 500);

        mainStage = primaryStage;
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
