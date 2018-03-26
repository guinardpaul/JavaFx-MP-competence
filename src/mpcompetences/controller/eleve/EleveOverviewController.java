/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.controller.eleve;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import mpcompetences.MainApp;
import mpcompetences.model.Classe;
import mpcompetences.model.Eleve;
import mpcompetences.model.enums.CYCLE;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class EleveOverviewController {

    private MainApp mainApp;
    private final ObservableList<Eleve> eleveData = FXCollections.observableArrayList();
    @FXML
    private TableView<Eleve> eleveTableView;
    @FXML
    private TableColumn<Eleve, String> nomColumn;
    @FXML
    private TableColumn<Eleve, String> prenomColumn;
    @FXML
    private TableColumn<Eleve, Classe> classeColumn;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label classeLabel;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize () {
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        classeColumn.setCellValueFactory(cellData -> cellData.getValue().classeProperty());

        initEleveTableData();
    }

    public void setMainApp (MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void initEleveTableData () {
        eleveData.add(new Eleve("GUINARD", "Paul", new Classe("6°", CYCLE.Cycle3.getNom())));
        eleveData.add(new Eleve("toto", "Paul", new Classe("6°", CYCLE.Cycle3.getNom())));
        eleveData.add(new Eleve("TUTU", "Paul", new Classe("6°", CYCLE.Cycle3.getNom())));
        eleveData.add(new Eleve("TITI", "Paul", new Classe("6°", CYCLE.Cycle3.getNom())));
        eleveTableView.setItems(eleveData);

        showEleveData(null);
        eleveTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldvalue, newvalue) -> showEleveData(newvalue));
    }

    public void showEleveData (Eleve eleve) {
        if (eleve != null) {
            nomLabel.setText(eleve.getNom());
            prenomLabel.setText(eleve.getPrenom());
            classeLabel.setText(eleve.getClasse().getNomClasse());
        } else {
            nomLabel.setText("");
            prenomLabel.setText("");
            classeLabel.setText("");
        }
    }

}
