package ihm.controler;

import ihm.view.InterfaceDebut;
import ihm.view.MenuEleve;
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
            System.out.println("sout");
            InterfaceDebut app = new InterfaceDebut();
        }
    }
    
}
