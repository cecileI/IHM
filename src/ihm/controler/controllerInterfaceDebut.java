/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import ihm.model.Classe;
import ihm.model.Eleve;
import ihm.view.InterfaceDebut;
import ihm.view.MenuEleve;
import ihm.view.MenuProfesseur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

/**
 * Actions when user click on button in InterfaceDebut
 * @author Group 7
 */
public class controllerInterfaceDebut implements ActionListener {
    private InterfaceDebut moninterf;
    
    public controllerInterfaceDebut(InterfaceDebut interf){
        this.moninterf = interf;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
            //recupere les donnees de l'eleve
            if (e.getSource()==moninterf.getvalidEleve()){
                String prenomE = moninterf.getprenomEleve().getText();
                String nomE = moninterf.getnomEleve().getText();
                String niveau = moninterf.getclasseEleve().getText();
                Classe classe = new Classe(niveau);

                if (controllerConnexion.connexionEleve(prenomE, nomE, niveau)==true){
                    System.out.println("connexion reussie");
                    Eleve currentEleve = new Eleve(nomE,prenomE,classe);
                    MenuEleve interfaceEleve = new MenuEleve(currentEleve);
                    moninterf.refresh(interfaceEleve);
                }else{
                    moninterf.getmessage().setText("Connexion refusée");
                }
            }
            if (e.getSource()==moninterf.getvalidProf()){
                //recupere les donnees du prof 
                String prenomP = moninterf.getprenomProf().getText();
                String nomP = moninterf.getnomProf().getText();
                String mdp = moninterf.getmotDePasse().getText();

                if (controllerConnexion.connexionProf(prenomP, nomP, mdp)==true){
                    System.out.println("connexion reussie");
                    MenuProfesseur menuProf = new MenuProfesseur();  //ouvre Menu Professeur
                    moninterf.refresh(menuProf);
                }else{
                    moninterf.getmessage().setText("Connexion refusée");
                }
            }
    }
}
