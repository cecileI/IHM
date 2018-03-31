package ihm.view;

import ihm.controler.InfoBDD;
import ihm.controler.controllerExerciceProf;
import ihm.model.Exercice;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 * Cette classe permet d'afficher tout les exercices afin que le professeur sélectionne un exercice existant pour le modifier
 * @author Group 7
 */
public class ViewTableExercices extends JScrollPane {
    
    private TableMod tableMod;
    private JTable jtable;
    private ListeExercicesProf listexo;
    private ListSelectionModel listSelectionModel;
    
    
     /**
      * Constructeur de la view de la jtable
      * @param listexo : l'interface ListeExercicesProf
     * Cette fonction permet de créer une JTable avec la liste des Exercices de la BDD
     */
      public ViewTableExercices(ListeExercicesProf listexo){
        this.listexo = listexo;
        tableMod = new ViewTableExercices.TableMod(); //création de la tableMod
        jtable = new JTable(tableMod); //création de la jtable
        jtable.setAutoCreateRowSorter(true);
        jtable.setCellSelectionEnabled(true);
        ListSelectionModel selectcellule = jtable.getSelectionModel();
        selectcellule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.add(jtable);
        this.setViewportView(jtable);
        
        //pour avoir une action lorque l'on clique sur un élément dans la jtable
        listSelectionModel = jtable.getSelectionModel();
        listSelectionModel.addListSelectionListener(new controllerExerciceProf(jtable,tableMod.getExercices(),listexo));
     }
      
      /**
     * Sous-classe pour créer la JTable des exercices
     */
    public static class TableMod extends AbstractTableModel {
        
        private ArrayList<Exercice> exercices;
        private String[] menubar = {"Exercices"};
        
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
