package views;

import controllers.Jogar;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Jogodavelha extends Application{
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
          Parent root = FXMLLoader.load(getClass().getResource("/interfaceGame/painelfrontal.fxml"));
        
        Scene scene = new Scene(root);
     
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    public static void main(String[] args) {
            launch(args);
    }

    
}        
