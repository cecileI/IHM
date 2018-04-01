package ihm.controler;


import ihm.model.*;
import ihm.view.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ControllerAjoutExerciceProf contient les ActionEvent des boutons du panel AjoutExerciceProf
 * Les Boutons de AjoutExerciceProf sont Valider et Menu
 * @author Group 7
 */
public class controllerAjoutExerciceProf implements ActionListener {
    private AjoutExerciceProf monmenu;
    
    private TortueG currentTortue;
    private TortueCouleur currentTortueCoul;
    private TortueRapide currenttortueRapide;
    private String typetortue;
     
      public controllerAjoutExerciceProf(AjoutExerciceProf menu){
        this.monmenu = menu;
    }

   @Override
    public void actionPerformed (ActionEvent e) {     
        
        //JButton Menu: ouvre le panel du MenuProfesseur à la place du panel AjoutExerciceProf(retour au Menu)
        if (e.getSource() == monmenu.getMenu()){
            MenuProfesseur menuProf = new MenuProfesseur();
            monmenu.remove(monmenu.getGeneral());
            monmenu.add(menuProf);      
            monmenu.repaint();
            monmenu.validate();         
        }
        
        
        //TORTUES : OK!
        // Boutons Tortue Rapide, Classique, Couleur 
        if (e.getSource()==monmenu.gettRapide()){
            //Creation de la TortueRapide et affichage Canvas
            this.typetortue = "rapide";
            currenttortueRapide = new TortueRapide(); //creation d'une tortue rapide            
            JPanel canv = Canvas.getCanvasPanel();
            monmenu.getCentre().add(canv);
            monmenu.getLigneCode().append("tortue : rapide\n"); //ecrit dans la console de l'interface
            
            //permet de garder le scroll en bas pour voir les nouvelles lignes qui s'ajoutent
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            
            //ajoute à la liste des actions du professeur pour cette tentative
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"Tortue : rapide\n");
            
            monmenu.repaint();
           
            //retire les Boutons pour la Couleur (si précédement cliqué sur TortueCoul)
            monmenu.getBlack().setEnabled(false); 
            monmenu.getRed().setEnabled(false);
            monmenu.getYellow().setEnabled(false);
            monmenu.getBlue().setEnabled(false);
            monmenu.getGreen().setEnabled(false);
            monmenu.getMagenta().setEnabled(false);
            
        }else if(e.getSource()==monmenu.gettClassique()){
            //Creation de la Tortue et affichage Canvas
            this.typetortue = "classique";
            currentTortue = new TortueG(); //creation d'une tortue classique
            JPanel canv = Canvas.getCanvasPanel();
            monmenu.getCentre().add(canv);
            monmenu.getLigneCode().append("tortue : classique\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"Tortue : classique\n");
            monmenu.repaint();
            
            //retire les Boutons pour la Couleur (si précédement cliqué sur TortueCoul)
            monmenu.getBlack().setEnabled(false); 
            monmenu.getRed().setEnabled(false);
            monmenu.getYellow().setEnabled(false);
            monmenu.getBlue().setEnabled(false);
            monmenu.getGreen().setEnabled(false);
            monmenu.getMagenta().setEnabled(false);
            
        }else if(e.getSource()==monmenu.gettCouleur()){
            //Creation de la TortueCouleur et affichage Canvas
            this.typetortue = "couleur";
            currentTortueCoul = new TortueCouleur(); //creation d'une tortue couleur
            JPanel canv = Canvas.getCanvasPanel();
            monmenu.getLigneCode().append("tortue : couleur\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            monmenu.getCentre().add(canv);
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"Tortue : couleur\n");
            monmenu.repaint();
            
            //mise à dispo des Boutons pour la Couleur
            monmenu.getBlack().setEnabled(true); 
            monmenu.getRed().setEnabled(true);
            monmenu.getYellow().setEnabled(true);
            monmenu.getBlue().setEnabled(true);
            monmenu.getGreen().setEnabled(true);
            monmenu.getMagenta().setEnabled(true);            
        }
        

//BUTTONS : Tourner, Avancer, Ecrire, Exétuter, Valider par type de Tortue
                
        if (e.getSource()==monmenu.getTourner()){
            monmenu.getLigneCode().append("tourner\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"tourner\n");
            if (typetortue.equals("couleur")){
                this.getCurrentTortueCoul().tourner();
            }else if(typetortue.equals("classique")){
                this.getCurrentTortue().tourner();
            }else if(typetortue.equals("rapide")){
                this.getCurrenttortueRapide().tourner();
            }            
            monmenu.repaint();

      
        }else if(e.getSource()==monmenu.getAvancer()){
            monmenu.getLigneCode().append("avancer\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"avancer\n");
            if (typetortue.equals("couleur")){
                this.getCurrentTortueCoul().avancer();
            }else if(typetortue.equals("classique")){
                this.getCurrentTortue().avancer();
            }else if(typetortue.equals("rapide")){
                this.getCurrenttortueRapide().avancer();
            }                     
            monmenu.repaint();
            
        }else if(e.getSource()==monmenu.getEcrire()){
            if (typetortue.equals("couleur")){
                if (this.getCurrentTortueCoul().enTrace()==false){
                    monmenu.getLigneCode().append("écrire\n");
                    monmenu.setScriptExercice(monmenu.getScriptExercice()+"écrire\n");
                    this.getCurrentTortueCoul().tracer(true);
                }else{
                    monmenu.getLigneCode().append("ne pas écrire\n");
                    monmenu.setScriptExercice(monmenu.getScriptExercice()+"ne pas écrire\n");
                    this.getCurrentTortueCoul().tracer(false);
                }
                
            }else if(typetortue.equals("classique")){
                if (this.getCurrentTortue().enTrace()==false){
                    monmenu.getLigneCode().append("écrire\n");
                    monmenu.setScriptExercice(monmenu.getScriptExercice()+"écrire\n");
                    monmenu.setScriptExercice(monmenu.getScriptExercice()+"ne pas écrire\n");
                    this.getCurrentTortue().tracer(true);
                }else{
                    monmenu.getLigneCode().append("ne pas écrire\n");
                    this.getCurrentTortue().tracer(false);
                }                
               
            }else if(typetortue.equals("rapide")){
                if (this.getCurrenttortueRapide().enTrace()==false){
                    monmenu.getLigneCode().append("écrire\n");
                    monmenu.setScriptExercice(monmenu.getScriptExercice()+"écrire\n");
                    this.getCurrenttortueRapide().tracer(true);
                }else{
                    monmenu.getLigneCode().append("ne pas écrire\n");
                    monmenu.setScriptExercice(monmenu.getScriptExercice()+"ne pas écrire\n");
                    this.getCurrenttortueRapide().tracer(false);
                }
            }
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            monmenu.repaint();
            monmenu.validate();
            
        }else if(e.getSource()==monmenu.getExecuter()){
            monmenu.getLigneCode().append("Button Exécuter en cours de construction\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            //monmenu.getTortue().executer();
            
        }else if(e.getSource()==monmenu.getValider()){
            monmenu.getLigneCode().append("Button Valider en cours de construction, connexion à la BDD\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            //monmenu.getTortue().valider();
            
             //int idEx = monmenu.getCurrentExercice().getIdEx();
            String modele = monmenu.getScriptExercice(); //liste des boutons sur lesquels a cliquer l'eleve
//            if (InfoBDD.saveExProf(monmenu.idEx)){
//                MenuProfesseur interfaceProf = new  MenuProfesseur(monmenu.getCurrentEx());
//                interfaceProf.getMessage().setText("Exercice bien sauvegardé ! ");
//                monmenu.remove(monmenu.getGeneral());
//                monmenu.add(interfaceProf);
//                monmenu.repaint();
//                monmenu.validate();
//                System.out.println("Sauvegarde de l'exercice réussie");
//            }else{
//                JLabel message = new JLabel("Sauvegarde de l'exercice échouée !");
//                System.out.println("Sauvegarde de l'exercice non réussie");
//            } 
            
        }    
        
        //si TortueCouleur
        if(e.getSource()==monmenu.getBlack()){
            monmenu.getLigneCode().append("couleur : noir\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            this.getCurrentTortueCoul().setCouleur("black");
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"black\n");
                
        }else if(e.getSource()==monmenu.getBlue()){
            monmenu.getLigneCode().append("couleur : bleu\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            this.getCurrentTortueCoul().setCouleur("blue");
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"blue\n");
                
        }else if(e.getSource()==monmenu.getGreen()){
            monmenu.getLigneCode().append("couleur : vert\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            this.getCurrentTortueCoul().setCouleur("green");
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"vert\n");
                
        }else if(e.getSource()==monmenu.getRed()){
            monmenu.getLigneCode().append("couleur : rouge\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            this.getCurrentTortueCoul().setCouleur("red");
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"rouge\n");
               
        }else if(e.getSource()==monmenu.getMagenta()){
            monmenu.getLigneCode().append("couleur : magenta\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            this.getCurrentTortueCoul().setCouleur("magenta");
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"magenta\n");
                
        }else if(e.getSource()==monmenu.getYellow()){
            monmenu.getLigneCode().append("couleur : jaune\n");
            monmenu.getListScroller().getVerticalScrollBar().setValue(monmenu.getListScroller().getVerticalScrollBar().getMaximum());
            this.getCurrentTortueCoul().setCouleur("yellow");
            monmenu.setScriptExercice(monmenu.getScriptExercice()+"jaune\n");
        }        
    }

    public TortueG getCurrentTortue() {
        return currentTortue;
    }
    public TortueCouleur getCurrentTortueCoul() {
        return currentTortueCoul;
    }
    public TortueRapide getCurrenttortueRapide() {
        return currenttortueRapide;
    }
}
