/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.controller.competence;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import mpcompetences.MainApp;
import mpcompetences.model.Competence;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class CompetenceOverviewController {

    @FXML
    private ChoiceBox<String> selecteCycle;
    @FXML
    private TreeTableView<Competence> competenceTreeTableView;
    @FXML
    private TreeTableColumn<Competence, String> refColumn;
    @FXML
    private TreeTableColumn<Competence, String> descriptionColumn;
    @FXML
    private Label refLabel;
    @FXML
    private Label descriptionLabel;
    @FXML
    private Label cycleLabel;
    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize() {
        refColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>(""));
        descriptionColumn.setCellValueFactory(new TreeItemPropertyValueFactory<>(""));

        initCompetencesTableData();
    }

    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    private void initCompetencesTableData() {
        competenceTreeTableView.setUserData(new Competence("aa", "aa", "c1"));
    }

    public void showEleveData(Competence competence) {
        if (competence != null) {
            refLabel.setText(competence.getRef());
            descriptionLabel.setText(competence.getDescription());
            cycleLabel.setText(competence.getCycle());
        } else {
            refLabel.setText("");
            descriptionLabel.setText("");
            cycleLabel.setText("");
        }
    }

}
