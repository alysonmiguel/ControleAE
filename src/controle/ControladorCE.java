/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import main.Principal;
import modelo.Extintor;

/**
 * FXML Controller class
 *
 * @author Alyson
 */
public class ControladorCE implements Initializable {

     
    @FXML
    private TextField lblTipo;

    @FXML
    private TextField lblPeso;

    @FXML
    private TextField lblSetor;

    @FXML
    private DatePicker lblValidade;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnVoltar;

    @FXML
    void salvar(ActionEvent event) {

    }

    @FXML
    void voltar(ActionEvent event) {
        
       Principal.changeScreen("ex");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
