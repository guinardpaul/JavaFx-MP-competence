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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import mpcompetences.controller.RootLayoutController;
import mpcompetences.model.Classe;
import mpcompetences.model.enums.CYCLE;
import mpcompetences.utils.FileHandler;

/**
 *
 * @author Paul
 */
public class MainApp extends Application {

    public static final String VIEWS_DIR = "/mpcompetences/views/";
    private Stage primaryStage;
    public BorderPane rootLayout;
    private FileHandler fileHandler;
    private final ObservableList<Classe> classeData = FXCollections.observableArrayList();

    public MainApp() {
        fileHandler = new FileHandler();

        classeData.add(new Classe("6°", CYCLE.Cycle3.getNom()));
        classeData.add(new Classe("5°", CYCLE.Cycle3.getNom()));
        classeData.add(new Classe("3°", CYCLE.Cycle4.getNom()));
    }

    public ObservableList<Classe> getClasseData() {
        return classeData;
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MP-Competences");
        this.primaryStage.setMaximized(true);

        initRootLayout();
    }

    private void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(this.getClass().getResource(VIEWS_DIR + "RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Give the controller access to the main app.
            RootLayoutController controller = loader.getController();
            controller.setMainApp(this);
            controller.setFileHandler(fileHandler);

            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Try to load last opened person file.
//        File file = fileHandler.getFilePath();
//        if (file != null) {
//            fileHandler.loadClasseDataFromFile(file);
//        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public Window getPrimaryStage() {
        return primaryStage;
    }

}
