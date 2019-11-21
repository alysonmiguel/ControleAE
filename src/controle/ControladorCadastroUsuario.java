/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import main.Principal;
import modelo.Usuario;
import persistencia.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class ControladorCadastroUsuario implements Initializable {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    @FXML
    private TextField lblNome;

    @FXML
    private TextField lblLogin;

    @FXML
    private TextField lblEmail;

    @FXML
    private TextField lblFuncao;

    @FXML
    private TextField lblSenha;

    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnLimpar;

    @FXML
    private Pane pane;
    
     @FXML
    private Button btnVoltar;

    @FXML
    void cadastrarUsuario(ActionEvent event) {
        Usuario u = new Usuario(lblNome.getText(), lblEmail.getText(), lblFuncao.getText(), lblLogin.getText(), Integer.parseInt(lblSenha.getText()));
       
            usuarioDAO.insertUsuario(u);
          
        Principal.changeScreen("login");
    }

    @FXML
    void limpar(ActionEvent event) {
        lblNome.clear();
        lblEmail.clear();
        lblFuncao.clear();
        lblLogin.clear();
        lblSenha.clear();

    }

    @FXML
    void voltar(ActionEvent event) {
        Principal.changeScreen("login");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
