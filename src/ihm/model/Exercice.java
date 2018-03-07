package ihm.model;

/**
 * Classe Exercice contenant tous les paramètres d'un exercice, permettant de gérer les exercices
 * @author Group7
 */
public class Exercice {
   
    private int idEx;
    private String titre;
    private String modele;
    private String consigne;
    private String modeTortue;  //rapidité de la tortue

    //Constructeur de la classe Exercice
    public Exercice(int idEx, String titre, String modele, String consigne, String modeTortue) {
        this.idEx = idEx;
        this.titre = titre;
        this.modele = modele;
        this.consigne = consigne;
        this.modeTortue = modeTortue;
    }

    //getters-setters des paramètres
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
