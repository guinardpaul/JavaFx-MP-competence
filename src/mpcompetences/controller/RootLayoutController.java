/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.controller;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import mpcompetences.MainApp;
import mpcompetences.controller.classe.ClasseOverviewController;
import mpcompetences.controller.competence.CompetenceOverviewController;
import mpcompetences.controller.eleve.EleveOverviewController;
import mpcompetences.controller.resultat.ResultatOverviewController;
import mpcompetences.model.enums.BUTTONNAME;
import mpcompetences.utils.FileHandler;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class RootLayoutController {

    private final String VIEWS_DIR = "/mpcompetences/views/";
    private MainApp mainApp;
    private FileHandler fileHandler;
    @FXML
    private BottomNavigationButton classeMenuButton;
    @FXML
    private BottomNavigationButton eleveMenuButton;
    @FXML
    private BottomNavigationButton competenceMenuButton;
    @FXML
    private BottomNavigationButton resultatMenuButton;

    public RootLayoutController () {
        fileHandler = new FileHandler();
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp (MainApp mainApp) {
        this.mainApp = mainApp;
        handleMenuClasse();
    }

    public void setMenuButtonSelected (String buttonName) {
        if (buttonName == BUTTONNAME.Eleve.getNom()) {
            eleveMenuButton.setSelected(true);
        } else if (buttonName == BUTTONNAME.Classe.getNom()) {
            classeMenuButton.setSelected(true);
        } else if (buttonName == BUTTONNAME.Competence.getNom()) {
            competenceMenuButton.setSelected(true);
        } else if (buttonName == BUTTONNAME.Resultat.getNom()) {
            resultatMenuButton.setSelected(true);
        }
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize () {
    }

    @FXML
    private void handleMenuClasse () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(VIEWS_DIR + "classe/ClasseOverview.fxml"));
            AnchorPane classeOverview = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(classeOverview);
            classeMenuButton.setSelected(true);

            // Give the controller access to the main app.
            ClasseOverviewController controller = loader.getController();
            controller.setMainApp(mainApp);
            controller.setRootController(this);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMenuEleve () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(VIEWS_DIR + "eleve/EleveOverview.fxml"));
            AnchorPane eleveOverview = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(eleveOverview);

            // Give the controller access to the main app.
            EleveOverviewController controller = loader.getController();
            controller.setMainApp(mainApp);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMenuCompetence () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(VIEWS_DIR + "competence/CompetenceOverview.fxml"));
            AnchorPane competenceOverview = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(competenceOverview);

            // Give the controller access to the main app.
            CompetenceOverviewController controller = loader.getController();
            controller.setMainApp(mainApp);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleMenuResultat () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(VIEWS_DIR + "resultat/ResultatOverview.fxml"));
            AnchorPane resultatOverview = (AnchorPane) loader.load();

            mainApp.rootLayout.setCenter(resultatOverview);

            // Give the controller access to the main app.
            ResultatOverviewController controller = loader.getController();
            controller.setMainApp(mainApp);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen () {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            fileHandler.loadClasseDataFromFile(file);
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave () {
        File classeFile = fileHandler.getFilePath();
        if (classeFile != null) {
            fileHandler.saveClasseDataToFile(classeFile);
        } else {
            handleSaveAs();
        }
    }

    private void handleSaveAs () {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
            // Make sure it has the correct extension
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            fileHandler.saveClasseDataToFile(file);
        }
    }

    @FXML
    private void handleClose () {
        System.exit(0);
    }

}
