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
        
        //Ne concerne pas les tortues
        if (e.getSource()==tentativeEleve.getMenu()){ //en appuyant sur le bouton menu
            MenuEleve interfaceEleve = new MenuEleve(tentativeEleve.getCurrentEleve());
            tentativeEleve.remove(tentativeEleve.getGeneral());
            tentativeEleve.add(interfaceEleve);
            tentativeEleve.repaint();
            tentativeEleve.validate();
            
        }else if(e.getSource()==tentativeEleve.getExecuter()){ // en selectionnant executer
            //
        }else if(e.getSource()==tentativeEleve.getValider()){ // en selectionnant valider
            //
        }
        
        //si tortue couleur
        if (tentativeEleve.getModeTortue().equals("couleur")){
                        
            if(e.getSource()==tentativeEleve.getBlack()){
                tentativeEleve.getTortueCoul().setCouleur("black");
                
            }else if(e.getSource()==tentativeEleve.getBlue()){
                tentativeEleve.getTortueCoul().setCouleur("blue");
                
            }else if(e.getSource()==tentativeEleve.getGreen()){
                tentativeEleve.getTortueCoul().setCouleur("green");
                
            }else if(e.getSource()==tentativeEleve.getRed()){
                tentativeEleve.getTortueCoul().setCouleur("red");
                
            }else if(e.getSource()==tentativeEleve.getMagenta()){
                tentativeEleve.getTortueCoul().setCouleur("magenta");
                
            }else if(e.getSource()==tentativeEleve.getYellow()){
                System.out.println("coucou");
                tentativeEleve.getTortueCoul().setCouleur("yellow");
                
            }else if(e.getSource()==tentativeEleve.getTourner()){ // en appuyant sur le bouton tourner
                tentativeEleve.getTortueCoul().tourner();
                
            }else if(e.getSource()==tentativeEleve.getAvancer()){ // en appuyant sur le bouton avancer
                tentativeEleve.getTortueCoul().avancer();
                //.append("avancer")
            }else if(e.getSource()==tentativeEleve.getEcrire()){ // en appuyant sur le bouton ecrire
                if (tentativeEleve.getTortueCoul().enTrace()==false){
                    tentativeEleve.getTortueCoul().tracer(true);
                }else{
                    tentativeEleve.getTortueCoul().tracer(false);
                }
            }
        }else{ // si tortue rapide ou classique
            if(e.getSource()==tentativeEleve.getTourner()){ // en appuyant sur le bouton tourner
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
            }
        }
        
    }
    
}
