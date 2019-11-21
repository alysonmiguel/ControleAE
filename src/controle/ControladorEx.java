/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Principal;
import modelo.Extintor;
import modelo.Usuario;
import persistencia.ExtintorDAO;

/**
 * FXML Controller class
 *
 * @author Aluno
 */
public class ControladorEx implements Initializable {

    private Extintor extintorEdit = new Extintor();

    private ObservableList<Extintor> extintores = FXCollections.observableArrayList();

    private ExtintorDAO extintorDAO = new ExtintorDAO();

    @FXML
    private TableView<Extintor> tabela;

    @FXML
    private TableColumn<Extintor, String> colunaTipo;

    @FXML
    private TableColumn<Extintor, Float> colunaPeso;

    @FXML
    private TableColumn<Extintor, String> colunaSetor;

    @FXML
    private TableColumn<Extintor, Date> colunaValidade;

    @FXML
    private Button btnVoltar;

    @FXML
    private Button btnCadastro;

    @FXML
    private Button btnBuscar;

    @FXML
    void buscar(ActionEvent event) {

    }

    @FXML
    void cadastrar(ActionEvent event) {
        Principal.changeScreen("CE");
    }

    @FXML
    void voltar(ActionEvent event) {
        Principal.changeScreen("menu");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colunaTipo.setCellValueFactory(new PropertyValueFactory<Extintor, String>(" colunaTipo"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory<Extintor, Float>(" colunaPeso"));
        colunaSetor.setCellValueFactory(new PropertyValueFactory<Extintor, String>(" colunaSetor"));
        colunaValidade.setCellValueFactory(new PropertyValueFactory<Extintor, Date>(" colunaValidade"));
        refreshTabela();

        FilteredList<Extintor> filteredData = new FilteredList<>(extintores, p -> true);

        colunaTipo.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(tipo -> {
                // If filter text is empty, display all users.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                if (tipo.getTipo().toUpperCase().contains(newValue.toUpperCase())) {
                    return true;
                }

                return false;
            });

            tabela.setItems(filteredData);
        });

        tabela.setOnMouseClicked(event -> {
            extintorEdit = tabela.getSelectionModel().getSelectedItem();
            colunaTipo.setText(extintorEdit.getTipo());
            colunaPeso.setText(String.valueOf(extintorEdit.getPeso()));
            colunaPeso.setText(extintorEdit.getSetor());
            colunaValidade.setText(String.valueOf(extintorEdit.getValidade()));

        });

    }

    private void refreshTabela() {
        extintores.clear();
        extintores.addAll(extintorDAO.listExtintor());
        tabela.setItems(extintores);
    }

}
