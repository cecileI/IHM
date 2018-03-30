package ihm.model;

/**
 * Classe Tentative contenant tous les paramètres pour une tentative, 
 * permettant de gérer les tentatives des exercices
 * @author Group7
 */
public class Tentative {
    private int idTentative;
    private int idEleve;
    private int idExercice;
    private String statutTentative;
    private String modeleEleve;

    //Constructeur de la classe Tentative
    public Tentative(int idTentative, int idEleve, int idExercice, String statutTentative,String modeleEleve) {
        this.idTentative = idTentative;
        this.idEleve = idEleve;
        this.idExercice = idExercice;
        this.statutTentative = statutTentative;
        this.modeleEleve = modeleEleve;
    }

    //getters-setters des paramètres

    public int getIdTentative() {
        return idTentative;
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

    public String getModeleEleve() {
        return modeleEleve;
    }

    public void setModeleEleve(String modeleEleve) {
        this.modeleEleve = modeleEleve;
    }
    
    
    
    
    
    
}
