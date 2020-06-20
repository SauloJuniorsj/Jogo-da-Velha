/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGame;


import controllers.Jogador;
import controllers.Jogar;
import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import models.Cadastrar;
import models.Logar;
import models.Placar;
import views.Jogodavelha;

/**
 * FXML Controller class
 *
 * @author Saulo Jr
 */
public class PainelfrontalController implements Initializable {

    @FXML
    public Button login_btn, cadastro_btn;
    @FXML
    public TextField nome_field;
    @FXML
    private PasswordField senha_field;
    @FXML
    private AnchorPane telaInicial;
    
    Jogador jogador = new Jogador();
    Placar placar = new Placar();
    Jogar jogo = new Jogar();  
    TelaJogoController a = new TelaJogoController(); 
    
    @FXML
    protected void login() throws NoSuchAlgorithmException, IOException, SQLException{
             
            jogador.setNome(nome_field.getText());
            jogador.setSenha(senha_field.getText());
            Jogodavelha.mudarTela("telaJogoFXML");
            a.receberMenu(jogador);
      
    }
    
    public void telaJogo() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaceGame/telaJogo.fxml"));
        telaInicial.getChildren().setAll(pane);
     
    }
    
    @FXML
    private void telaCadastro(ActionEvent action) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaceGame/painel2.fxml"));
        telaInicial.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
