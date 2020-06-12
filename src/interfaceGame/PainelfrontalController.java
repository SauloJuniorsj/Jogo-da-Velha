/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaceGame;

import java.awt.Button;
import java.awt.Label;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Saulo Jr
 */
public class PainelfrontalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    public Button login_btn;
     @FXML
    public Label nome;
    public Button logi;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
