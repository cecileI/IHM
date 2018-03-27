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
            tentativeEleve.getTortueG().tourner();
            
        }else if(e.getSource()==tentativeEleve.getAvancer()){ // en appuyant sur le bouton avancer
            tentativeEleve.getTortueG().avancer();
            //.append("avancer")
            
        }else if(e.getSource()==tentativeEleve.getEcrire()){ // en appuyant sur le bouton ecrire
            if (tentativeEleve.getTortueG().enTrace()==false){
                tentativeEleve.getTortueG().tracer(true);
            }else{
                tentativeEleve.getTortueG().tracer(false);
            }
      
        }else if(e.getSource()==tentativeEleve.getExecuter()){ // en selectionnant la tortue rapide
            //
        }else if(e.getSource()==tentativeEleve.getValider()){ // en selectionnant la tortue rapide
            //
        }
        
    }
    
}
