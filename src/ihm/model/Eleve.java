package ihm.model;

/**
 * Classe Eleve contenant tous les paramètres d'un élèves, permettant de gérer les élèves
 * @author Group7
 */
public class Eleve {
    private String nomEleve;
    private String prenomEleve;
    private Classe niveau;


    //Constructeur de la classe Eleve
    public Eleve(String nomEleve, String prenomEleve, Classe niveau) {
        this.nomEleve = nomEleve;
        this.prenomEleve = prenomEleve;
        this.niveau = niveau;
    }

    public String getNomEleve() {
        return nomEleve;
    }

    public void setNomEleve(String nomEleve) {
        this.nomEleve = nomEleve;
    }

    public String getPrenomEleve() {
        return prenomEleve;
    }

    public void setPrenomEleve(String prenomEleve) {
        this.prenomEleve = prenomEleve;
    }

    public Classe getNiveau() {
        return niveau;
    }

    public void setNiveau(Classe niveau) {
        this.niveau = niveau;
    }
    
    public String toString (){
        return (prenomEleve +" "+ nomEleve);
    }
}
