/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.controller.eleve;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import mpcompetences.MainApp;

/**
 * FXML Controller class
 *
 * @author Paul
 */
public class EleveOverviewController implements Initializable {

    private MainApp mainApp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize (URL url, ResourceBundle rb) {
        // TODO
    }

    public void setMainApp (MainApp mainApp) {
        this.mainApp = mainApp;
    }

}