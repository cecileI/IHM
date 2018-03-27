package ihm.controler;

import ihm.view.*;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControllerAjoutExerciceProf contient les ActionEvent des boutons du panel AjoutExerciceProf
 * Les Boutons de AjoutExerciceProf sont Valider et Menu
 * @author Diane
 */
public class controllerAjoutExerciceProf implements ActionListener {
    private AjoutExerciceProf monmenu;     
     
      public controllerAjoutExerciceProf(AjoutExerciceProf menu){
        this.monmenu = menu;
    }

   @Override
    public void actionPerformed (ActionEvent e) {
        
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
            
       //Ne concerne pas les tortues
        if (e.getSource()==monmenu.getMenu()){ //en appuyant sur le bouton menu
            //MenuEleve menuEleve = new MenuEleve(); 
            
        }else if(e.getSource()==monmenu.getExecuter()){ // en selectionnant executer
            //
        }else if(e.getSource()==monmenu.getValider()){ // en selectionnant valider
            //
        }
        
        //si tortue couleur
        if (monmenu.getModeTortue().equals("couleur")){
                        
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
                
            }else if(e.getSource()==monmenu.getTourner()){ // en appuyant sur le bouton tourner
                monmenu.getTortueCoul().tourner();
                
            }else if(e.getSource()==monmenu.getAvancer()){ // en appuyant sur le bouton avancer
                monmenu.getTortueCoul().avancer();
                //.append("avancer")
            }else if(e.getSource()==monmenu.getEcrire()){ // en appuyant sur le bouton ecrire
                if (monmenu.getTortueCoul().enTrace()==false){
                    monmenu.getTortueCoul().tracer(true);
                }else{
                    monmenu.getTortueCoul().tracer(false);
                }
            }
        }else{ // si tortue rapide ou classique
            if(e.getSource()==monmenu.getTourner()){ // en appuyant sur le bouton tourner
                monmenu.getTortue().tourner();
            
            }else if(e.getSource()==monmenu.getAvancer()){ // en appuyant sur le bouton avancer
                monmenu.getTortue().avancer();
                //.append("avancer")
            
            }else if(e.getSource()==monmenu.getEcrire()){ // en appuyant sur le bouton ecrire
                if (monmenu.getTortue().enTrace()==false){
                    monmenu.getTortue().tracer(true);
                }else{
                    monmenu.getTortue().tracer(false);
                }
            }
        }
    }
   }
}
