/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.controller.classe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import mpcompetences.MainApp;
import mpcompetences.model.Classe;

/**
 * FXML classe overview controller
 *
 * @author Paul
 */
public class ClasseOverviewController {

    private MainApp mainApp;
    private final ObservableList<Classe> classeData = FXCollections.observableArrayList();
    @FXML
    private TableView<Classe> classeTableView;
    @FXML
    private TableColumn<Classe, String> nomClasseColumn;
    @FXML
    private TableColumn<Classe, String> cycleColumn;
    @FXML
    private Label classeLabel;
    @FXML
    private Label cycleLabel;
    @FXML
    private Button nouveauButton;
    @FXML
    private Button editerButton;
    @FXML
    private Button supprimerButon;

    /**
     * Initializes the controller class.
     */
    public void initialize () {
        nomClasseColumn.setCellValueFactory(cellData -> cellData.getValue().nomClasseProperty());
        cycleColumn.setCellValueFactory(cellData -> cellData.getValue().cycleProperty());

        initClasseTableData();
    }

    private void initClasseTableData () {
        // TODO: Sample Data a remplacer par backend data
        classeData.add(new Classe("6°", "Cycle3"));
        classeTableView.setItems(classeData);

        showClasseDetails(null);

        classeTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showClasseDetails(newValue));
    }

    private void showClasseDetails (Classe classe) {
        if (classe == null) {
            classeLabel.setText("");
            cycleLabel.setText("");
        } else {
            classeLabel.setText(classe.getNomClasse());
            cycleLabel.setText(classe.getCycle());
        }
    }

    public void setMainApp (MainApp mainApp) {
        this.mainApp = mainApp;
    }

    @FXML
    private void handleNewClasse () {

    }

    @FXML
    private void handleUpdateClasse () {

    }

    @FXML
    private void handleDeleteClasse () {

    }

}
