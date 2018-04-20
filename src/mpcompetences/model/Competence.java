/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Paul
 */
public class Competence {

    private final StringProperty ref;
    private final StringProperty cycle;
    private final StringProperty description;

    public Competence() {
        this(null, null, null);
    }

    public Competence(String ref, String description, String cycle) {
        this.ref = new SimpleStringProperty(ref);
        this.description = new SimpleStringProperty(description);
        this.cycle = new SimpleStringProperty(cycle);
    }

    public String getRef() {
        return ref.get();
    }

    public void setRef(String value) {
        ref.set(value);
    }

    public StringProperty refProperty() {
        return ref;
    }

    public String getCycle() {
        return cycle.get();
    }

    public void setCycle(String value) {
        cycle.set(value);
    }

    public StringProperty cycleProperty() {
        return cycle;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String value) {
        description.set(value);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

}
