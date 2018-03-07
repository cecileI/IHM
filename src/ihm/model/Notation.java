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
public class Notation {
    
    private String statutExercice;
    private String commentaireExercice;

    public Notation(String statutExercice, String commentaireExercice) {
        this.statutExercice = statutExercice;
        this.commentaireExercice = commentaireExercice;
    }

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
