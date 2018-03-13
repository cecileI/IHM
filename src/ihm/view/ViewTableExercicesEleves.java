package ihm.view;

import ihm.controler.InfoBDD;
import ihm.controler.controllerExerciceEleve;
import ihm.model.Exercice;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Clara
 */
public class ViewTableExercicesEleves extends JScrollPane {
    
    private TableMod tableMod;
    private JTable jtable;
    private MenuEleve menuEleve;
    private ListSelectionModel listSelectionModel;
    
    
     /**
      * Constructeur de la view de la jtable
     * Cette fonction permet de créer une JTable des exercices dans le menu Eleve
     * @param menuEleve : l'interface du menu eleve
     */
    public ViewTableExercicesEleves(MenuEleve menuEleve){
        this.menuEleve = menuEleve;
        tableMod = new TableMod(); //création de la tableMod
        jtable = new JTable(tableMod); //création de la jtable
        jtable.setAutoCreateRowSorter(true);
        jtable.setCellSelectionEnabled(true);
        ListSelectionModel selectcellule = jtable.getSelectionModel();
        selectcellule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.add(jtable);
        this.setViewportView(jtable);
        
        //pour avoir une action lorque l'on clique sur un élément dans la jtable
        listSelectionModel = jtable.getSelectionModel();
        listSelectionModel.addListSelectionListener(new controllerExerciceEleve(jtable,tableMod.getExercices(),menuEleve));
    }



    /**
     * Sous-classe pour créer la JTable des exercices propre à un élève
     */
    public static class TableMod extends AbstractTableModel {
        
        private ArrayList<Exercice> exercices;
        private String[] menubar = {"N°","Exercice"};
        
        /**
         * Constructeur de tablemod
         */
        public TableMod(){
            this.exercices = InfoBDD.selectionListExercice();
        }

        /**
         * getter de la liste des exercices
         * @return la liste des exercices
         */
        public ArrayList<Exercice> getExercices() {
            return exercices;
        }

        public String getColumnName (int columnIndex) {
            return menubar[columnIndex];
        }
                
        public int getRowCount() {
          return exercices.size();
        }

        public int getColumnCount() {
          return menubar.length; 
        }
       
        /**
         * Cette fonction définie les différentes colonnes de la jtable
         * @param rowIndex num de la ligne
         * @param columnIndex num de la colonne
         * @return Object
         */
        public Object getValueAt(int rowIndex, int columnIndex) {

	    if  (columnIndex==0) {
		return exercices.get(rowIndex).getIdEx();}
            else if (columnIndex==1) {
		return exercices.get(rowIndex).getTitre();}
            else { 
                System.out.println("erreur");
                return null;
            }
       }
    }
    /**
     * Getter de la JTable
     * @return JTable
     */
    public JTable getTable(){
        return this.jtable;
    }
}
