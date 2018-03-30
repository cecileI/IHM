/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.view;

import ihm.controler.*;
import ihm.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author group 7
 */
public class VisuTableExEleveProf extends JPanel{
   
    private TableExEleveProf maJTable;
    private MenuProfesseur menuProf;
    //private Eleve eleve;
    
public VisuTableExEleveProf(Eleve monEleve){
             
        this.setSize(750,500);
        this.setLayout(new BorderLayout());

        
        this.maJTable = new TableExEleveProf(menuProf, monEleve);
        this.add(maJTable, BorderLayout.CENTER);    

        this.setVisible(true);
}    
}
