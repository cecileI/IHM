/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import ihm.model.Classe;
import ihm.model.Eleve;
import ihm.model.Professeur;
import java.util.ArrayList;

/**
 *
 * @author Clara
 */
public class controllerConnexion {
    
    /*
    * Fonction de connexion pour un professeur
    * @param prenomP : le prénom du professeur qu'il aura rentré
    * @param nomP : le nom du professeur qu'il aura rentré
    * @param mdp : le mot de passe qu'il aura rentré
    * @return boolean : si les identifiants du professeur sont corrects -> true
    */
    public static boolean connexionProf (String prenomP, String nomP, String mdp){
        ArrayList<Professeur> listProf = InfoBDD.selectionListProfesseur(); //recupere la liste des professeurs

        for (Professeur prof : listProf) {
            if ((prof.getNomProf().equals(nomP)) && (prof.getPrenomProf().equals(prenomP)) && (prof.getMdpProf().equals(mdp))){
                return(true); 
            }
        }
        return(false);
    }
    
    /*
    * Fonction de connexion pour un professeur
    * @param prenomE : le prénom de l'eleve qu'il aura rentré
    * @param nomE : le nom de l'eleve qu'il aura rentré
    * @param classe : la classe de l'eleve qu'il aura rentré
    * @return boolean : si les identifiants de l'eleve sont corrects -> true
    */
    public static boolean connexionEleve (String prenomE, String nomE, String classe){
        ArrayList<Eleve> listEleve = InfoBDD.selectionListEleve(); //recupere la liste des élèves
        
        Classe classeEleve = new Classe(classe);
        
        for (Eleve eleve : listEleve){
            if ((eleve.getNomEleve().equals(nomE)) && (eleve.getPrenomEleve().equals(prenomE)) && (eleve.getNiveau().equals(classeEleve.getNiveau()))){
                return(true);
            }
        }
        return(false);
    }
    
    
}
