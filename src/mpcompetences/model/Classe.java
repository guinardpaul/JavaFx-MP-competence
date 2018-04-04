/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model Classe
 *
 * @author Paul
 */
public class Classe {

    private final StringProperty nomClasse;
    private final StringProperty cycle;

    public Classe() {
        this(null, null);
    }

    public Classe(String nomClasse, String cycle) {
        this.nomClasse = new SimpleStringProperty(nomClasse);
        this.cycle = new SimpleStringProperty(cycle);
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

    public String getNomClasse() {
        return nomClasse.get();
    }

    public void setNomClasse(String value) {
        nomClasse.set(value);
    }

    public StringProperty nomClasseProperty() {
        return nomClasse;
    }

    @Override
    public String toString() {
        return nomClasse.getValue();
    }

}
