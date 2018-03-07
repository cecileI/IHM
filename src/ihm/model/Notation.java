package ihm.model;

/**
 * Classe Notation contenant tous les paramètres relatifs à la notation des exercices
 * Permet de gérer la notation des exercices
 * @author Group7
 */
public class Notation {
    
    private String statutExercice;
    private String commentaireExercice;

    //Constructeur de la classe Notation
    public Notation(String statutExercice, String commentaireExercice) {
        this.statutExercice = statutExercice;
        this.commentaireExercice = commentaireExercice;
    }

    //getters-setters des paramètres
    public String getStatutExercice() {
        return statutExercice;
    }

    public void setStatutExercice(String statutExercice) {
        this.statutExercice = statutExercice;
    }

    public String getCommentaireExercice() {
        return commentaireExercice;
    }

    public void setCommentaireExercice(String commentaireExercice) {
        this.commentaireExercice = commentaireExercice;
    }
    
        
}
