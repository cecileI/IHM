package ihm.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cece1
 */
public class Tentative {
    private int idTentative;
    private int idEleve;
    private int idExercice;
    private String statutTentative;
    private int idProf;
    private String modeleEleve;

    public Tentative(int idTentative, int idEleve, int idExercice, String statutTentative, int idProf, String modeleEleve) {
        this.idTentative = idTentative;
        this.idEleve = idEleve;
        this.idExercice = idExercice;
        this.statutTentative = statutTentative;
        this.idProf = idProf;
        this.modeleEleve = modeleEleve;
    }

    public int getIdTentative() {
        return idTentative;
    }

    public void setIdTentative(int idTentative) {
        this.idTentative = idTentative;
    }

    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
    }

    public int getIdExercice() {
        return idExercice;
    }

    public void setIdExercice(int idExercice) {
        this.idExercice = idExercice;
    }

    public String getStatutTentative() {
        return statutTentative;
    }

    public void setStatutTentative(String statutTentative) {
        this.statutTentative = statutTentative;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public String getModeleEleve() {
        return modeleEleve;
    }

    public void setModeleEleve(String modeleEleve) {
        this.modeleEleve = modeleEleve;
    }
    
    
    
    
    
    
}
