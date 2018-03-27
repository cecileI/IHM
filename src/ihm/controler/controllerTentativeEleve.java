/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import ihm.view.MenuEleve;
import ihm.view.TentativeEleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Clara
 */
public class controllerTentativeEleve implements ActionListener{
    
    private TentativeEleve tentativeEleve;
    
    public controllerTentativeEleve(TentativeEleve tentativeEleve){
        this.tentativeEleve = tentativeEleve;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        if (e.getSource()==tentativeEleve.getMenu()){ //en appuyant sur le bouton menu
            //MenuEleve menuEleve = new MenuEleve(); 
            
        }else if(e.getSource()==tentativeEleve.getTourner()){ // en appuyant sur le bouton tourner
            tentativeEleve.getTortue().tourner();
            
        }else if(e.getSource()==tentativeEleve.getAvancer()){ // en appuyant sur le bouton avancer
            tentativeEleve.getTortue().avancer();
            //.append("avancer")
            
        }else if(e.getSource()==tentativeEleve.getEcrire()){ // en appuyant sur le bouton ecrire
            if (tentativeEleve.getTortue().enTrace()==false){
                tentativeEleve.getTortue().tracer(true);
            }else{
                tentativeEleve.getTortue().tracer(false);
            }
        }else if(e.getSource()==tentativeEleve.getExecuter()){ // en selectionnant executer
            //
        }else if(e.getSource()==tentativeEleve.getValider()){ // en selectionnant valider
            //
        }
        if (tentativeEleve.getModeTortue()=="couleur"){
                        
            if(e.getSource()==tentativeEleve.getBlack()){
                tentativeEleve.getTortue().setCouleur("black");
            }else if(e.getSource()==tentativeEleve.getBlue()){
                tentativeEleve.getTortue().setCouleur("blue");
            }else if(e.getSource()==tentativeEleve.getGreen()){
                tentativeEleve.getTortue().setCouleur("green");
            }else if(e.getSource()==tentativeEleve.getRed()){
                tentativeEleve.getTortue().setCouleur("red");
            }else if(e.getSource()==tentativeEleve.getMagenta()){
                tentativeEleve.getTortue().setCouleur("magenta");
            }else if(e.getSource()==tentativeEleve.getYellow()){
                tentativeEleve.getTortue().setCouleur("yellow");

            }
        }
        
    }
    
}
