package ihm.model;

/**
 * Classe Eleve contenant tous les paramètres d'un élèves, permettant de gérer les élèves
 * @author Group7
 */
public class Eleve {
    private int idEleve;
    private String nomEleve;
    private String prenomEleve;
    private Classe niveau;


    //Constructeur de la classe Eleve
    public Eleve(int idEleve, String nomEleve, String prenomEleve, Classe niveau) {
        this.idEleve = idEleve;
        this.nomEleve = nomEleve;
        this.prenomEleve = prenomEleve;
        this.niveau = niveau;
    }

    //getters-setters des paramètres
    public int getIdEleve() {
        return idEleve;
    }

    public void setIdEleve(int idEleve) {
        this.idEleve = idEleve;
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
