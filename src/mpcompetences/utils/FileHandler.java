/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.utils;

import java.io.File;
import java.util.prefs.Preferences;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import mpcompetences.MainApp;
import mpcompetences.model.wrapper.ClasseListWrapper;

/**
 *
 * @author Paul
 */
public class FileHandler {

    private final String FILE_PATH = "filepath";
    private MainApp mainApp;

    public void setMainApp (MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Returns the Classe file preference, i.e. the file that was last opened.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     *
     * @return
     */
    public File getFilePath () {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        String filePath = prefs.get(FILE_PATH, null);
        if (filePath != null) {
            return new File(filePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setFilePath (File file) {
        Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
            prefs.put(FILE_PATH, file.getPath());
        } else {
            prefs.remove(FILE_PATH);
        }
    }

    /**
     * Loads person data from the specified file. The current person data will
     * be replaced.
     *
     * @param file
     */
    public void loadClasseDataFromFile (File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ClasseListWrapper.class);
            Unmarshaller um = context.createUnmarshaller();

            // Reading XML from the file and unmarshalling.
            ClasseListWrapper wrapper = (ClasseListWrapper) um.unmarshal(file);

            mainApp.getClasseData().clear();
            mainApp.getClasseData().addAll(wrapper.getClasses());

            // Save the file path to the registry.
            setFilePath(file);

        } catch (JAXBException e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not load data");
            alert.setContentText("Could not load data from file:\n" + file.getPath());

            alert.showAndWait();
        }
    }

    /**
     * Saves the current person data to the specified file.
     *
     * @param file
     */
    public void saveClasseDataToFile (File file) {
        try {
            JAXBContext context = JAXBContext
                    .newInstance(ClasseListWrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Wrapping our person data.
            ClasseListWrapper wrapper = new ClasseListWrapper();
            wrapper.setClasses(mainApp.getClasseData());

            // Marshalling and saving XML to the file.
            m.marshal(wrapper, file);

            // Save the file path to the registry.
            setFilePath(file);
        } catch (JAXBException e) { // catches ANY exception
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Could not save data");
            alert.setContentText("Could not save data to file:\n" + file.getPath());

            alert.showAndWait();
        }
    }
}
