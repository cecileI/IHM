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
            //Tentative(int idTentative, int idEleve, int idExercice, String statutTentative,String modeleEleve)
            //int idE = recupIdEleve(tentativeEleve.getCurrentEleve());
            int idEx = tentativeEleve.getCurrentExercice().getIdEx();
            //InfoBDD.saveTentEleve();
        }
        
        //si tortue couleur
        if (tentativeEleve.getModeTortue().equals("couleur")){
                        
            if(e.getSource()==tentativeEleve.getBlack()){
                tentativeEleve.getTortueCoul().setCouleur("black"); //redefinie la couleur du trait
                tentativeEleve.getLignesCode().append("couleur : noir\n"); //ecrit dans la console de l'interface
                tentativeEleve.getScriptTentative().add("black"); //ajoute à la liste des actions de l'élève pour cette tentative
                //permet de garder le scroll en bas pour voir les nouvelles lignes qui s'ajoutent
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                
            }else if(e.getSource()==tentativeEleve.getBlue()){
                tentativeEleve.getTortueCoul().setCouleur("blue");
                tentativeEleve.getLignesCode().append("couleur : bleu\n");
                tentativeEleve.getScriptTentative().add("blue");
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                
            }else if(e.getSource()==tentativeEleve.getGreen()){
                tentativeEleve.getTortueCoul().setCouleur("green");
                tentativeEleve.getLignesCode().append("couleur : vert\n");
                tentativeEleve.getScriptTentative().add("green");
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                
            }else if(e.getSource()==tentativeEleve.getRed()){
                tentativeEleve.getTortueCoul().setCouleur("red");
                tentativeEleve.getLignesCode().append("couleur : rouge\n");
                tentativeEleve.getScriptTentative().add("red");
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                
            }else if(e.getSource()==tentativeEleve.getMagenta()){
                tentativeEleve.getTortueCoul().setCouleur("magenta");
                tentativeEleve.getLignesCode().append("couleur : magenta\n");
                tentativeEleve.getScriptTentative().add("magenta");
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                
            }else if(e.getSource()==tentativeEleve.getYellow()){
                tentativeEleve.getTortueCoul().setCouleur("yellow");
                tentativeEleve.getLignesCode().append("couleur : jaune\n");
                tentativeEleve.getScriptTentative().add("yellow");
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                
            }else if(e.getSource()==tentativeEleve.getTourner()){ // en appuyant sur le bouton tourner
                tentativeEleve.getTortueCoul().tourner();
                tentativeEleve.getLignesCode().append("tourner\n");
                tentativeEleve.getScriptTentative().add("tourner");
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                
            }else if(e.getSource()==tentativeEleve.getAvancer()){ // en appuyant sur le bouton avancer
                tentativeEleve.getTortueCoul().avancer();
                tentativeEleve.getLignesCode().append("avancer\n");
                tentativeEleve.getScriptTentative().add("avancer");                
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                
                
            }else if(e.getSource()==tentativeEleve.getEcrire()){ // en appuyant sur le bouton ecrire
                if (tentativeEleve.getTortueCoul().enTrace()==false){
                    tentativeEleve.getTortueCoul().tracer(true);
                    tentativeEleve.getLignesCode().append("écrire\n");
                    tentativeEleve.getScriptTentative().add("écrire");
                    tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                }else{
                    tentativeEleve.getTortueCoul().tracer(false);
                    tentativeEleve.getLignesCode().append("ne pas écrire\n");
                    tentativeEleve.getScriptTentative().add("ne pas écrire");
                    tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                }
            }
        }else{ // si tortue rapide ou classique
            if(e.getSource()==tentativeEleve.getTourner()){ // en appuyant sur le bouton tourner
                tentativeEleve.getTortue().tourner();
                tentativeEleve.getLignesCode().append("tourner\n");
                tentativeEleve.getScriptTentative().add("tourner");
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
            
            }else if(e.getSource()==tentativeEleve.getAvancer()){ // en appuyant sur le bouton avancer
                tentativeEleve.getTortue().avancer();
                tentativeEleve.getLignesCode().append("avancer\n");
                tentativeEleve.getScriptTentative().add("avancer");
                tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());

            
            }else if(e.getSource()==tentativeEleve.getEcrire()){ // en appuyant sur le bouton ecrire
                if (tentativeEleve.getTortue().enTrace()==false){
                    tentativeEleve.getTortue().tracer(true);
                    tentativeEleve.getLignesCode().append("écrire\n");
                    tentativeEleve.getScriptTentative().add("écrire");
                    tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                }else{
                    tentativeEleve.getTortue().tracer(false);
                    tentativeEleve.getLignesCode().append("ne pas écrire\n");
                    tentativeEleve.getScriptTentative().add("ne pas écrire");
                    tentativeEleve.getListScroller().getVerticalScrollBar().setValue(tentativeEleve.getListScroller().getVerticalScrollBar().getMaximum());
                }
            }
        }
        
    }
    
}
