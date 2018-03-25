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
public enum CYCLE {
    Cycle3("Cycle3"),
    Cycle4("Cycle4");

    private final String nom;

    private CYCLE(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
