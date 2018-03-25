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
import mpcompetences.model.Eleve;

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
    private TableColumn<Eleve, String> classeColumn;
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
    public void initialize() {
        nomColumn.setCellValueFactory(cellData -> cellData.getValue().nomProperty());
        prenomColumn.setCellValueFactory(cellData -> cellData.getValue().prenomProperty());
        classeColumn.setCellValueFactory(cellData -> cellData.getValue().classeProperty());

    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

}
