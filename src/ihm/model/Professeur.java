/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.model;

/**
 *
 * @author Group7
 */
public class Professeur {
    private int idProf;
    private String nomProf;
    private String prenomProf;
    private String mdpProf;

    public Professeur(int idProf, String nomProf, String prenomProf, String mdpProf) {
        this.idProf = idProf;
        this.nomProf = nomProf;
        this.prenomProf = prenomProf;
        this.mdpProf = mdpProf;
    }

    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
    }

    public String getMdpProf() {
        return mdpProf;
    }

    public void setMdpProf(String mdpProf) {
        this.mdpProf = mdpProf;
    }
    
    
    
}
