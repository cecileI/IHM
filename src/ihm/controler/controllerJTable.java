package ihm.controler;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import ihm.view.*;

/**
 * Création du controllerJTable
 * @author Kelly 
 */
public class controllerJTable implements ListSelectionListener{
    private JTable jtable;
    private MenuEleve menueleve;
    private MenuProfesseur menuprof;
    
 /**
 * Constructeur du controllerJTable
 * @author Kelly 
 */
      public controllerTable(JTable jtable, MenuEleve me) {
      this.jtable = jtable;
      this.menueleve = me;
	}

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
    }
    
}
