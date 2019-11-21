package main;

import javafx.application.Application;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Principal extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    private static Stage stage;

    private static Scene login;
    private static Scene cadastro;
    private static Scene menu;
    private static Scene arCondicionado;
    private static Scene extintor;
    private static Scene cadastroExtintor;

    @Override
    public void start(Stage stageP) throws Exception {
        stage = stageP;
        stageP.setTitle("Login");

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/visao/Login.fxml"));
        login = new Scene(fxmlLogin, 640, 400);

        Parent fxmlCadastro = FXMLLoader.load(getClass().getResource("/visao/CadastroUsuario.fxml"));
        cadastro = new Scene(fxmlCadastro, 640, 400);

        Parent fxmlMenu = FXMLLoader.load(getClass().getResource("/visao/Menu.fxml"));
        menu = new Scene(fxmlMenu, 640, 400);

        Parent fxmlArCondicionado = FXMLLoader.load(getClass().getResource("/visao/ArCondicionado.fxml"));
        arCondicionado = new Scene(fxmlArCondicionado, 640, 400);

        Parent fxmlExtintor = FXMLLoader.load(getClass().getResource("/visao/Extintor.fxml"));
        extintor = new Scene(fxmlExtintor, 640, 400);

        Parent fxmlCadastroExtintor = FXMLLoader.load(getClass().getResource("/visao/CadastroExtintor.fxml"));
        cadastroExtintor = new Scene(fxmlCadastroExtintor, 700, 500);

        stageP.setScene(login);
        stageP.show();
    }

    public static void changeScreen(String tela) {
        switch (tela) {
            case "login":
                stage.setScene(login);
                break;
            case "cadastro":
                stage.setScene(cadastro);
                break;
            case "menu":
                stage.setScene(menu);
                break;

            case "ar":
                stage.setScene(arCondicionado);
                break;
            case "ex":
                stage.setScene(extintor);
                break;
            case "CE":
                stage.setScene(cadastroExtintor);
                break;

        }
    }

}
