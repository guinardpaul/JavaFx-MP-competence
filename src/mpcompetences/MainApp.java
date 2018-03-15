/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import mpcompetences.controller.RootLayoutController;

/**
 *
 * @author Paul
 */
public class MainApp extends Application {

    private final String VIEWS_DIR = "/mpcompetences/views/";
    private Stage primaryStage;
    public BorderPane rootLayout;

    @Override
    public void start (Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MP-Competences");
        this.primaryStage.setMaximized(true);

        initRootLayout();
    }

    private void initRootLayout () {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(VIEWS_DIR + "RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);

            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main (String[] args) {
        launch(args);
    }

}
