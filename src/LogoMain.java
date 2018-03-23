import ihm.controler.InfoBDD;
import ihm.model.Classe;
import ihm.view.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The class to lanch the application
 * @author Group7
 */
public class LogoMain{
    
    /**
     * The constructor of the class LogoMain
     * @param args The user do not have to put argument. This parameter is for 
     * user with command line version of the application.
     */
    public static void main (String[] args){

        
        //InterfaceDebut app = new InterfaceDebut();

        System.out.println(InfoBDD.selectionListClasse());
        for (Classe laclasse : InfoBDD.selectionListClasse()){
            System.out.println(InfoBDD.selectionListEleveClasse(laclasse));
        }
        //Classe classeCE1=new Classe("CE1");
        //Classe classeCP=new Classe("CP");
         //InterfaceDebut app = new InterfaceDebut();
        //MenuEleve app = new MenuEleve();

        InterfaceDebut app = new InterfaceDebut();

        //MenuEleve app = new MenuEleve();
        //MenuProfesseur app = new MenuProfesseur();
        //AjoutExerciceProf app = new AjoutExerciceProf();

   

        //ModifExerciceProf app = new ModifExerciceProf();

    }
}
