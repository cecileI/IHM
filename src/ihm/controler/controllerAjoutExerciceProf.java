package ihm.controler;

import ihm.model.Canvas;
import ihm.model.TortueCouleur;
import ihm.model.TortueG;
import ihm.model.TortueRapide;
import ihm.view.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

/**
 * ControllerAjoutExerciceProf contient les ActionEvent des boutons du panel AjoutExerciceProf
 * Les Boutons de AjoutExerciceProf sont Valider et Menu
 * @author Diane
 */
public class controllerAjoutExerciceProf implements ActionListener {
    private AjoutExerciceProf monmenu;
    private TortueG tortue;
    private TortueRapide tortueR;
    private TortueCouleur tortueC;
     
      public controllerAjoutExerciceProf(AjoutExerciceProf menu){
        this.monmenu = menu;
    }

   @Override
    public void actionPerformed (ActionEvent e) {     
        
        //Ne concerne pas les tortues
        //JButton Menu: ouvre le panel du MenuProfesseur à la place du panel AjoutExerciceProf(retour au Menu)
        if (e.getSource() == monmenu.getMenu()){
            monmenu.getPanelHaut().remove(monmenu.getPanelHaut());
            monmenu.getGauche().remove(monmenu.getGauche());
            monmenu.getCentre().remove(monmenu.getCentre());
            monmenu.getDroite().remove(monmenu.getDroite());
            monmenu.getBas().remove(monmenu.getBas());
            //monmenu.add(monmenu.getPanDroite(),BorderLayout.CENTER);           
            monmenu.repaint();
            monmenu.validate();           

        }else if(e.getSource()==monmenu.getExecuter()){ // en selectionnant executer
            //
        }else if(e.getSource()==monmenu.getValider()){ // en selectionnant valider
            //
        }
        //TORTUES : OK!
        // Boutons Tortue Rapide, Classique, Couleur 
        if (e.getSource()==monmenu.gettRapide()){
            //Creation de la TortueRapide et affichage Canvas
            TortueRapide tortueRapide = new TortueRapide();
            JPanel canv = Canvas.getCanvasPanel();
            monmenu.getCentre().add(canv);
            monmenu.repaint();
            monmenu.validate();
            
             //retire les Boutons pour la Couleur (si précédement cliquer sur TortueCoul)
            monmenu.getBlack().setEnabled(false); 
            monmenu.getRed().setEnabled(false);
            monmenu.getYellow().setEnabled(false);
            monmenu.getBlue().setEnabled(false);
            monmenu.getGreen().setEnabled(false);
            monmenu.getMagenta().setEnabled(false);
            
        }else if(e.getSource()==monmenu.gettClassique()){
            //Creation de la Tortue et affichage Canvas
            TortueG tortueG = new TortueG();
            JPanel canv = Canvas.getCanvasPanel();
            monmenu.getCentre().add(canv);
            monmenu.repaint();
            monmenu.validate();
            
            //retire les Boutons pour la Couleur (si précédement cliquer sur TortueCoul)
            monmenu.getBlack().setEnabled(false); 
            monmenu.getRed().setEnabled(false);
            monmenu.getYellow().setEnabled(false);
            monmenu.getBlue().setEnabled(false);
            monmenu.getGreen().setEnabled(false);
            monmenu.getMagenta().setEnabled(false);
            
        }else if(e.getSource()==monmenu.gettCouleur()){
            //Creation de la TortueCouleur et affichage Canvas
            TortueCouleur tortueCoul = new TortueCouleur();
            JPanel canv = Canvas.getCanvasPanel();
            monmenu.getCentre().add(canv);
            monmenu.repaint();
            monmenu.validate();
            
            //mise à dispo des Boutons pour la Couleur
            monmenu.getBlack().setEnabled(true); 
            monmenu.getRed().setEnabled(true);
            monmenu.getYellow().setEnabled(true);
            monmenu.getBlue().setEnabled(true);
            monmenu.getGreen().setEnabled(true);
            monmenu.getMagenta().setEnabled(true);            
        }
           
        //Buttons Tourner, Avancer, Ecrire Exétuter, Valider pour Tortue
        if (e.getSource()==monmenu.getTourner()){ 
            System.out.println("tourne");                
                
            monmenu.getTortueCoul().tourner();
            monmenu.repaint();
            monmenu.validate();
      
        }else if(e.getSource()==monmenu.getAvancer()){
            monmenu.getTortueCoul().avancer();
            
        }else if(e.getSource()==monmenu.getEcrire()){
            if (monmenu.getTortueCoul().enTrace()==false){
                monmenu.getTortueCoul().tracer(true);
            }else{
                monmenu.getTortueCoul().tracer(false);
            }
            
        }else if(e.getSource()==monmenu.getExecuter()){
            System.out.println("Button Exécuter en cours de construction");
            //monmenu.getTortue().executer();
            
        }else if(e.getSource()==monmenu.getValider()){            
            System.out.println("Button Valider en cours de construction");
            //monmenu.getTortue().valider();
        }
    
        
        //if TortueCouleur
            if(e.getSource()==monmenu.getBlack()){
                monmenu.getTortueCoul().setCouleur("black");
                
            }else if(e.getSource()==monmenu.getBlue()){
                monmenu.getTortueCoul().setCouleur("blue");
                
            }else if(e.getSource()==monmenu.getGreen()){
                monmenu.getTortueCoul().setCouleur("green");
                
            }else if(e.getSource()==monmenu.getRed()){
                monmenu.getTortueCoul().setCouleur("red");
                
            }else if(e.getSource()==monmenu.getMagenta()){
                monmenu.getTortueCoul().setCouleur("magenta");
                
            }else if(e.getSource()==monmenu.getYellow()){
                System.out.println("coucou");
                monmenu.getTortueCoul().setCouleur("yellow");
                
            }
        
            
        
    }

    public TortueG getTortue() {
        return tortue;
    }
    public TortueRapide getTortueR() {
        return tortueR;
    }
    public TortueCouleur getTortueC() {
        return tortueC;
    }
}