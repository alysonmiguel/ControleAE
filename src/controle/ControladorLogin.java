
package controle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import main.Principal;
import modelo.Usuario;
import persistencia.DataSingleton;
import persistencia.UsuarioDAO;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class ControladorLogin implements Initializable {

    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @FXML
    private Label txtLabel;

    @FXML
    private Pane pane;

    @FXML
    private TextField txtUsuario;

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtSenha;

    @FXML
    private Button btnCadastro;

    @FXML
    void cadastrar(ActionEvent event) {
        Principal.changeScreen("cadastro");
    }
     @FXML
    void limpar(ActionEvent event) {
        txtUsuario.clear();
        txtSenha.clear();
    }
    @FXML
    void voltar(ActionEvent event) {
   Principal.changeScreen("menu");
    }
    @FXML
    void login(ActionEvent event) {
        Usuario u = new Usuario(txtUsuario.getText(), Integer.parseInt(txtSenha.getText()));

        if (usuarioDAO.login(u) != null) {
            System.out.println("Login ");
            DataSingleton.getInstance().setUser(u);
            Principal.changeScreen("menu");

        } else {
            System.out.println("Erro login");
        }
        //Principal.changeScreen("login");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
