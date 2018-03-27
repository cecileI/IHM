package ihm.controler;

import ihm.view.InterfaceDebut;
import ihm.view.MenuEleve;
import ihm.view.TentativeEleve;
import ihm.view.VisuTentativeEleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Goup7
 */


public class controllerMenuEleve implements ActionListener{

    private MenuEleve menuEleve;
    
    public controllerMenuEleve(MenuEleve menuEleve){
        this.menuEleve = menuEleve;
    }
    
    @Override
    public void actionPerformed (ActionEvent e) {
        
        if (e.getSource()== menuEleve.getDeconnexion()){
            InterfaceDebut interfaceDebut = new InterfaceDebut();
            
        }else if(e.getSource()==menuEleve.getFaireTentative()){
            //getEleve
            //TentativeEleve tent = new TentativeEleve(Eleve);
            
        }else if(e.getSource()==menuEleve.getVisualiserTentative()){
            VisuTentativeEleve visuTentEleve = new VisuTentativeEleve(menuEleve.getCurrentEleve(),menuEleve.getCurrentExercice());
            menuEleve.remove(menuEleve.getGeneral());
            menuEleve.add(visuTentEleve);
            menuEleve.repaint();
            menuEleve.validate();
        }
    }
    
}
