/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Principal;
import modelo.Extintor;
import modelo.Usuario;
import persistencia.DataSingleton;
import persistencia.ExtintorDAO;

/**
 * FXML Controller class
 *
 * @author Leonardo
 */
public class ControladorEx implements Initializable {

    private ExtintorDAO extintorDAO = new ExtintorDAO();
    private Extintor extintorEdit = new Extintor();

    int id;
    private ObservableList<Extintor> extintores = FXCollections.observableArrayList();

    public ArrayList<Extintor> listExtintor() {
        ArrayList<Extintor> lista = new ArrayList<>();

        return lista;
    }
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
    private Label lblCadastro;

    @FXML
    private TextField lblTipo;

    @FXML
    private TextField lblPeso;

    @FXML
    private TextField lblSetor;

    @FXML
    private DatePicker lblValidade;

    @FXML
    void cadastrar(ActionEvent event) {
        Extintor e = new Extintor(Date.valueOf(lblValidade.getValue()), lblSetor.getText(), lblTipo.getText(), Integer.parseInt(lblPeso.getText()), DataSingleton.getInstance().getUser());
        extintorDAO.insertExtintor(e);
        limpar();
        refreshTabela();

    }

    @FXML
    void voltar(ActionEvent event) {
        Principal.changeScreen("menu");

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        colunaTipo.setCellValueFactory(new PropertyValueFactory<Extintor, String>("Tipo"));
        colunaPeso.setCellValueFactory(new PropertyValueFactory<Extintor, Float>("Peso"));
        colunaSetor.setCellValueFactory(new PropertyValueFactory<Extintor, String>("Setor"));
        colunaValidade.setCellValueFactory(new PropertyValueFactory<Extintor, Date>("Validade"));

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

            lblTipo.setText(extintorEdit.getTipo());
            lblPeso.setText(String.valueOf(extintorEdit.getPeso()));
            lblSetor.setText(extintorEdit.getSetor());
            lblValidade.setValue(extintorEdit.getValidade().toLocalDate());

            refreshTabela();
            //TODO setar valor no textField
        });

    }

    private void refreshTabela() {
        extintores.clear();
        extintores.addAll(extintorDAO.listExtintor());
        tabela.setItems(extintores);
    }

    void limpar() {
        lblTipo.clear();
        lblPeso.clear();
        lblSetor.clear();
        lblValidade.setValue(LocalDate.now());

    }

    @FXML
    void remover(ActionEvent event) {

    }

    @FXML
    void editar(ActionEvent event) {
        // Extintor e = new Extintor(Date.valueOf(lblValidade.getValue()), lblSetor.getText(), lblTipo.getText(), Integer.parseInt(lblPeso.getText()), DataSingleton.getInstance().getUser());

        extintorEdit.setValidade(Date.valueOf(lblValidade.getValue()));
        extintorEdit.setSetor(lblSetor.getText());
        extintorEdit.setTipo(lblTipo.getText());
        extintorEdit.setPeso(Integer.parseInt(lblPeso.getText()));
        //extintorEdit.setIdExtintor(id);
        extintorDAO.atualizar(extintorEdit);
        limpar();
        refreshTabela();
    }
}
