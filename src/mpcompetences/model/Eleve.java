/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Paul
 */
public class Eleve {

    private final StringProperty nom;
    private final StringProperty prenom;
    //  private final StringProperty classe;
    private final ObjectProperty<Classe> classe;

    public Eleve () {
        this(null, null, null);
    }

    public Eleve (String nom, String prenom, Classe classe) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.classe = new SimpleObjectProperty<>(classe);
        //   this.classe = new SimpleStringProperty(classe);
    }

    public Classe getClasse () {
        return classe.get();
    }

    public void setClasse (Classe value) {
        classe.set(value);
    }

    public ObjectProperty classeProperty () {
        return classe;
    }

    public String getPrenom () {
        return prenom.get();
    }

    public void setPrenom (String value) {
        prenom.set(value);
    }

    public StringProperty prenomProperty () {
        return prenom;
    }

    public String getNom () {
        return nom.get();
    }

    public void setNom (String value) {
        nom.set(value);
    }

    public StringProperty nomProperty () {
        return nom;
    }

}
