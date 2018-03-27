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
 * @author Cécile
 */
public class VisuTentativeEleve extends JPanel{
    private JLabel lblNomEleve,lblPrenomEleve,lblClasseEleve,numeroExercice;
    
    private JButton retourMenu; // va renvoyer sur MenuEleve
    private JPanel entete; // contient petite entete + num exo + bouton retourMenu + nom, prenom, classe
    
    private ViewVisuTentativeEleve maJTable;
    private MenuEleve menuEleve;
    private Eleve eleve;
    
    public VisuTentativeEleve(Eleve eleve,String titreExercice) {
                  
        this.setLayout(new BorderLayout()); 
        this.setPreferredSize(new Dimension(500,500));
     
        entete=new JPanel();
        
        lblNomEleve = new JLabel(eleve.getNomEleve() + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        
        lblPrenomEleve = new JLabel(eleve.getPrenomEleve());
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        
        lblClasseEleve = new JLabel(eleve.getNiveau().toString());
        lblClasseEleve.setFont(new Font("Arial",Font.BOLD,15));
        
        entete.add(lblNomEleve,BorderLayout.NORTH);
        entete.add(lblPrenomEleve,BorderLayout.NORTH);
        entete.add(lblClasseEleve,BorderLayout.NORTH);
         
        numeroExercice = new JLabel(titreExercice);
        numeroExercice.setHorizontalAlignment(SwingConstants.CENTER);
        numeroExercice.setFont(new Font("Arial",Font.BOLD,20));
        
        retourMenu= new JButton("Retour Menu");
        retourMenu.addActionListener(
                new ActionListener(){
                public void actionPerformed (ActionEvent e) {
                    //réoriente vers MenuEleve
                    //MenuEleve app = new MenuEleve(eleve);
                }
        
            });
        entete.add(numeroExercice);
        entete.add(retourMenu);
        this.maJTable = new ViewVisuTentativeEleve(menuEleve,eleve);
        
        this.setLayout(new BorderLayout());
        this.add(entete, BorderLayout.NORTH);
        this.add(maJTable, BorderLayout.CENTER);

        this.setVisible(true);
}    
}
