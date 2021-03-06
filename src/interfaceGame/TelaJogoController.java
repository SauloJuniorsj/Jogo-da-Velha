/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGame;

import controllers.Jogador;
import controllers.contraPC;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import models.Logar;

/**
 * FXML Controller class
 *
 * @author Saulo Jr
 */
public class TelaJogoController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
    @FXML
    private AnchorPane telaInicial;
    @FXML
    private Pane pane00, pane01, pane02,
                 pane10, pane11, pane12,
                 pane20, pane21, pane22;
    @FXML
    private GridPane meuPane;
      contraPC valor = new contraPC();
      
     @FXML
    private void handleOnMouseClicked(MouseEvent event)
    {
        Node source = (Node)event.getSource();
        Integer colIndex = (GridPane.getColumnIndex(source) == null) ?  0 : (GridPane.getColumnIndex(source));
        Integer colRow = (GridPane.getRowIndex(source) == null) ? 0 : (GridPane.getRowIndex(source));
        source.setStyle("-fx-background-image: url('/interfaceGame/Cimages.png'); -fx-background-size: 80");
        String posicao = colIndex.toString() + colRow.toString();
        valor.recebeValor(posicao);
    }
    
    public void receberMenu(Jogador jogador) throws SQLException, NoSuchAlgorithmException{
         Logar login = new Logar();
           login.Autenticar(jogador);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
