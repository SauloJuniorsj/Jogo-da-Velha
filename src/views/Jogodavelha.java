package views;

import controllers.Jogar;
import java.io.IOException;
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

public class Jogodavelha extends Application {

    public static Scene telaLogin, telaCadastro, telaJogo;
    public static String telaAtiva = "telaLoginFXML";
    public static Stage stage = null;

    @Override
    public void start(Stage primaryStage) throws Exception {

        try{
        Parent telaLoginFXML = FXMLLoader.load(Jogodavelha.class.getResource("/interfaceGame/painelfrontal.fxml"));
        Parent telaCadastroFXML = FXMLLoader.load(Jogodavelha.class.getResource("/interfaceGame/painel2.fxml"));
        Parent telaJogoFXML = FXMLLoader.load(Jogodavelha.class.getResource("/interfaceGame/telaJogo.fxml"));

        stage = primaryStage;

        telaLogin = new Scene(telaLoginFXML);
        telaCadastro = new Scene(telaCadastroFXML);
        telaJogo = new Scene(telaJogoFXML);
        
//        switch (telaAtiva) {
//
//            case "telaLoginFXML":
//                telaLogin = new Scene(telaLoginFXML);
//                stage.setScene(telaLogin);
//                break;
//            case "telaCadastroFXML":
//                telaCadastro = new Scene(telaCadastroFXML);
//                stage.setScene(telaCadastro);
//                break;
//            case "telaJogoFXML":
//                telaJogo = new Scene(telaJogoFXML);
//                stage.setScene(telaJogo);
//                break;
//        }
        telaLogin.getStylesheets().add(getClass().getResource("/interfaceGame/application.css").toExternalForm());
        stage.setScene(telaLogin);
        stage.show();
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void mudarTela(String telaAtiva) throws IOException {
//
//        Parent telaLoginFXML = FXMLLoader.load(Jogodavelha.class.getResource("/interfaceGame/painelfrontal.fxml"));
//        Parent telaCadastroFXML = FXMLLoader.load(Jogodavelha.class.getResource("/interfaceGame/painel2.fxml"));
//        Parent telaJogoFXML = FXMLLoader.load(Jogodavelha.class.getResource("/interfaceGame/telaJogo.fxml"));

        switch (telaAtiva) {

            case "telaLoginFXML":
//                telaLogin = new Scene(telaLoginFXML);
                stage.setScene(telaLogin);
                break;
            case "telaCadastroFXML":
//                telaCadastro = new Scene(telaCadastroFXML);
                stage.setScene(telaCadastro);
                break;
            case "telaJogoFXML":
//                telaJogo = new Scene(telaJogoFXML);
                stage.setScene(telaJogo);
                break;
            default:
                stage.setScene(telaLogin);
                break;
        }
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
