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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static jdk.nashorn.internal.objects.NativeError.printStackTrace;
import models.Cadastrar;
import models.Logar;
import models.Placar;

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
    
    
    @FXML
    private void login() throws NoSuchAlgorithmException, IOException{
        try{
            Logar login = new Logar();
            jogador.setNome(nome_field.getText());
            jogador.setSenha(senha_field.getText());
            boolean verific =  login.Autenticar(jogador);
            if(verific == true){ 
               telaJogo();
//               placar.mostrarPlacar(jogador);
//               jogo.entrarJogo(jogador);
                   
            }else{
                System.out.println("algo deu errado, tentar novamente");
            }
        }catch(SQLException e){
            Object printStackTrace = printStackTrace(e);
        }
        
    }
    
    @FXML
    private void telaJogo() throws IOException{
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
