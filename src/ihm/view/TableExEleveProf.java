/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.view;

import ihm.controler.InfoBDD;
import ihm.controler.controllerTableExEleveProf;
import ihm.controler.controllerTentative;
import ihm.model.Eleve;
import ihm.model.Tentative;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;

/**
 * Cette classe permet de créer le JPanel qui affiche les exercices d'un élève, le nombre de tentatives associées
 * à l'exercice et le statut de l'exercice
 * @author clarisse
 */
public class TableExEleveProf extends JScrollPane{
    private TableMod tableMod;
    private JTable jtable;
    private MenuProfesseur menuProf;
    private ListSelectionModel listSelectionModel;
    private static Eleve currentEleve;
    private ListSelectionModel e;
    
    public TableExEleveProf(MenuProfesseur menuProf, Eleve currentEleve){
        this.menuProf=menuProf;
        this.currentEleve=currentEleve;
        tableMod = new TableMod(); //création de la tableMod
        jtable = new JTable(tableMod); //création de la jtable
        jtable.setAutoCreateRowSorter(true);
        jtable.setCellSelectionEnabled(true);
        ListSelectionModel selectcellule = jtable.getSelectionModel();
        selectcellule.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.add(jtable);
        this.setViewportView(jtable);
        
        listSelectionModel = jtable.getSelectionModel();
        listSelectionModel.addListSelectionListener(new controllerTableExEleveProf(jtable,tableMod.getTentatives(),menuProf));
        
        
    }
    
    
    /**
     * Sous-classe pour créer la JTable des exercices propre à un élève
     */
    public static class TableMod extends AbstractTableModel {
        
        private ArrayList<Tentative> tentatives;
        private String[] menubar = {"N°Exercice","N°Tentatives","Statut"};
        
        /**
         * Constructeur de tablemod
         */
        public TableMod(){
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
       
//        /**
//         * Cette fonction définie les différentes colonnes de la jtable
//         * @param rowIndex num de la ligne
//         * @param columnIndex num de la colonne
//         * @return Object
//         */
//        public Object getValueAtTentative(int rowIndex, int columnIndex) {
//        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            System.out.println("columnIndex :"+columnIndex);
	    if  (columnIndex==0) {
                return tentatives.get(rowIndex).getIdExercice();
            }else if (columnIndex ==1){
		return tentatives.get(rowIndex).getIdTentative();}
            else if (columnIndex==2) {
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
