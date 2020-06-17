/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGame;

import controllers.Jogador;
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

/**
 * FXML Controller class
 *
 * @author Saulo Jr
 */
public class Painel2Controller implements Initializable {

   @FXML
   public Button telaInicial_btn, cadastro_btn;
   @FXML
   public TextField nome;
   @FXML
   private PasswordField senha,senha_conf;
   @FXML
   private AnchorPane telaInicial;
   @FXML
    private void cadastro() throws SQLException, NoSuchAlgorithmException{
        try{
        Jogador jogador = new Jogador();
        Cadastrar cadastro = new Cadastrar();
   
            jogador.setNome(nome.getText());
            jogador.setSenha(senha.getText());
            jogador.setConf_Senha(senha_conf.getText());
            cadastro.recebeDados(jogador);
        }catch(SQLException e){
            printStackTrace(e);
        }
    }
    
     @FXML
    private void telaLogin(ActionEvent action) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/interfaceGame/painelfrontal.fxml"));
        telaInicial.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
