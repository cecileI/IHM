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
public class Exercice {
   
    private int idEx;
    private String titre;
    private String modele;
    private String consigne;
    private String modeTortue;  //rapidité de la tortue

    public Exercice(int idEx, String titre, String modele, String consigne, String modeTortue) {
        this.idEx = idEx;
        this.titre = titre;
        this.modele = modele;
        this.consigne = consigne;
        this.modeTortue = modeTortue;
    }

    public int getIdEx() {
        return idEx;
    }

    public void setIdEx(int idEx) {
        this.idEx = idEx;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getConsigne() {
        return consigne;
    }

    public void setConsigne(String consigne) {
        this.consigne = consigne;
    }

    public String getModeTortue() {
        return modeTortue;
    }

    public void setModeTortue(String modeTortue) {
        this.modeTortue = modeTortue;
    }
     
    
}
