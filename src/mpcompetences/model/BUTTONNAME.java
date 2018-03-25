/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.model;

/**
 *
 * @author Paul
 */
public enum BUTTONNAME {
    Eleve("Eleve"),
    Classe("Classe"),
    Competence("Competence"),
    Resultat("Resultat");

    private final String nom;

    private BUTTONNAME(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
