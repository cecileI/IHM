/*
 *This class allows to view tentatives achieved by a student
 */
package ihm.view;

import ihm.controler.InfoBDD;
import ihm.controler.controllerTentative;
import ihm.model.Eleve;
import ihm.model.Tentative;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Cécile
 */
public class ViewVisuTentativeEleve extends JScrollPane {
    
    private TableMod tableMod;
    private JTable jtable;
    private MenuEleve menuEleve;
    private ListSelectionModel listSelectionModel;
    //private static Eleve eleve;
   // private String nomEleve, prenomEleve,classeEleve;
        
    
     /**
      * Constructeur de la view de la jtable
     * Cette fonction permet de créer une JTable des exercices dans le menu Eleve
     * @param menuEleve : l'interface du menu eleve
     */
    public ViewVisuTentativeEleve(MenuEleve menuEleve,Eleve currentEleve){
             
        this.menuEleve = menuEleve;
        tableMod = new TableMod(currentEleve); //création de la tableMod
        jtable = new JTable(tableMod); //création de la jtable
        jtable.setAutoCreateRowSorter(true);
        jtable.setCellSelectionEnabled(true);
        ListSelectionModel selectcellule = jtable.getSelectionModel();
        selectcellule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.add(jtable);
        this.setViewportView(jtable);
        
        //pour avoir une action lorque l'on clique sur un élément dans la jtable
        listSelectionModel = jtable.getSelectionModel();
        listSelectionModel.addListSelectionListener(new controllerTentative(jtable,tableMod.getTentatives(),menuEleve));
    }



    /**
     * Sous-classe pour créer la JTable des tentatives propre à un élève
     */
    public static class TableMod extends AbstractTableModel {
        
        private ArrayList<Tentative> tentatives;
        private String[] menubar = {"N°","Statut"};
        private Eleve eleve;
        /**
         * Constructeur de tablemod
         */
        public TableMod(Eleve currentEleve){
            eleve = currentEleve; 
            this.tentatives = InfoBDD.selectionListTentativeUnEleve(currentEleve);
        }

        /**
         * getter de la liste des exercices
         * @return la liste des exercices
         */
        public ArrayList<Tentative> getTentatives() {
            return tentatives;
        }

        public String getColumnName (int columnIndex) {
            return menubar[columnIndex];
        }
                
        public int getRowCount() {
          return tentatives.size();
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
        
        public Object getValueAt(int rowIndex, int columnIndex){
            throw new UnsupportedOperationException("Not supported yet . ");
        }
        
        public Object getValueAtTentative(int rowIndex, int columnIndex) {

	    if  (columnIndex==0) {
		return tentatives.get(rowIndex).getIdTentative();}
            else if (columnIndex==1) {
		return tentatives.get(rowIndex).getStatutTentative();}
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
