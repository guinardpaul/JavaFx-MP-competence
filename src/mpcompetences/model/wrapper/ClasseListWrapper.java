/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpcompetences.model.wrapper;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import mpcompetences.model.Classe;

/**
 *
 * @author Paul
 */
@XmlRootElement(name = "classes")
public class ClasseListWrapper {

    private List<Classe> classes;

    @XmlElement(name = "classe")
    public List<Classe> getClasses () {
        return classes;
    }

    public void setClasses (List<Classe> classes) {
        this.classes = classes;
    }

}
