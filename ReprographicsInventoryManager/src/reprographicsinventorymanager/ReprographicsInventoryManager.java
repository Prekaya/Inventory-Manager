package reprographicsinventorymanager;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author ADDO_a
 */
public class ReprographicsInventoryManager extends Application {
    
    FXMLLoader loader = new FXMLLoader();
    public Stage mainStage = null;
    
    public static  ReprographicsInventoryManager Instance;
    
    public void goToScreen(String path) throws IOException{
       AnchorPane root = loader.load(getClass().getResource(path));  
       Scene scene = new Scene(root, 355, 500);
        mainStage.setScene(scene);
        mainStage.setResizable(true);
        mainStage.setTitle("SOS-HGIC Reprographics");
        mainStage.show();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        if (Instance == null) Instance = this;

        AnchorPane root = loader.load(getClass().getResource("Screens/LoginScreen.fxml"));

        Scene scene = new Scene(root, 355, 500);

        mainStage = primaryStage;
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image("reprographicsinventorymanager/Images/SOS logo Black.png"));
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
