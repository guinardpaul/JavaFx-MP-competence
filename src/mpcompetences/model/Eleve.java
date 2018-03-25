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
public class Eleve {

    private final StringProperty nom;
    private final StringProperty prenom;
    private final StringProperty classe;

    public Eleve() {
        this(null, null, null);
    }

    public Eleve(String nom, String prenom, String classe) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.classe = new SimpleStringProperty(classe);
    }

    public String getClasse() {
        return classe.get();
    }

    public void setClasse(String value) {
        classe.set(value);
    }

    public StringProperty classeProperty() {
        return classe;
    }

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String value) {
        prenom.set(value);
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String value) {
        nom.set(value);
    }

    public StringProperty nomProperty() {
        return nom;
    }

}
