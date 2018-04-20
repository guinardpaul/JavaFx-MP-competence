/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.service;

import java.util.List;
import mpcompetences.model.Classe;

/**
 *
 * @author Paul
 */
public interface ClasseService {

    List<Classe> getAllClasses();

    Classe getClasseById(Integer id);

    Classe saveOrUpdateClasse(Classe classe);

    void deleteClasse(Integer id);
}
