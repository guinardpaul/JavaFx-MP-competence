/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.controller.classe;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import mpcompetences.MainApp;
import mpcompetences.controller.RootLayoutController;
import mpcompetences.controller.eleve.EleveOverviewController;
import mpcompetences.model.BUTTONNAME;
import mpcompetences.model.CYCLE;
import mpcompetences.model.Classe;

/**
 * FXML classe overview controller
 *
 * @author Paul
 */
public class ClasseOverviewController {

    private MainApp mainApp;
    private RootLayoutController rootLayoutController;
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
    public void initialize() {
        nomClasseColumn.setCellValueFactory(cellData -> cellData.getValue().nomClasseProperty());
        cycleColumn.setCellValueFactory(cellData -> cellData.getValue().cycleProperty());

        initClasseTableData();
    }

    private void initClasseTableData() {
        // TODO: Sample Data a remplacer par backend data
        classeData.add(new Classe("6°", CYCLE.Cycle3.getNom()));
        classeData.add(new Classe("5°", CYCLE.Cycle3.getNom()));
        classeData.add(new Classe("3°", CYCLE.Cycle4.getNom()));
        classeTableView.setItems(classeData);

        showClasseDetails(null);

        classeTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showClasseDetails(newValue));
    }

    private void showClasseDetails(Classe classe) {
        if (classe == null) {
            classeLabel.setText("");
            cycleLabel.setText("");
        } else {
            classeLabel.setText(classe.getNomClasse());
            cycleLabel.setText(classe.getCycle());
        }
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    public void setRootController(RootLayoutController rootLayoutController) {
        this.rootLayoutController = rootLayoutController;
    }

    @FXML
    private void handleNewClasse() {
        //TODO
    }

    @FXML
    private void handleUpdateClasse() {
        //TODO
    }

    @FXML
    private void handleDeleteClasse() {
        //TODO: call un service pour enlever la classe de la BDD
        Classe selectedClasse = classeTableView.getSelectionModel().getSelectedItem();
        if (selectedClasse != null) {
            classeData.remove(selectedClasse);
        }
    }

    @FXML
    private void handleConsulterEleves() {
        Classe selectedClasse = classeTableView.getSelectionModel().getSelectedItem();
        if (selectedClasse != null) {
            try {
                // TODO: passer selectedClasse comme argument pour charger la classe
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource(mainApp.VIEWS_DIR + "eleve/EleveOverview.fxml"));
                AnchorPane eleveOverview = (AnchorPane) loader.load();

                mainApp.rootLayout.setCenter(eleveOverview);
                rootLayoutController.setMenuButtonSelected(BUTTONNAME.Eleve.getNom());

                // Give the controller access to the main app.
                EleveOverviewController controller = loader.getController();
                controller.setMainApp(mainApp);
            } catch (IOException ex) {
                Logger.getLogger(ClasseOverviewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
