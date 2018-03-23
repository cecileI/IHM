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
public class VisuTentativeEleve extends JFrame{
    private JLabel lblNomEleve;
    private JLabel lblPrenomEleve;
    private JLabel lblClasseEleve;
    private JLabel numeroExercice,jeSuis;
    
    private JButton retourMenu; // va renvoyer sur MenuEleve
    private JPanel entete; // contient petite entete + num exo + bouton retourMenu
    private JPanel petiteEntete; // contient nom, prenom, classe
   
    private ViewVisuTentativeEleve maJTable;
    private MenuEleve menuEleve;
    //private Eleve eleve;
    
public VisuTentativeEleve(String nomEleve, String prenomEleve, String classeEleve,String titreExercice){
     
    // eleve.setNomEleve(nomEleve);
     //eleve.setPrenomEleve(prenomEleve);
     //eleve.setNiveau(classeEleve); 
             
     this.getContentPane().setLayout(new BorderLayout()); 
     this.setTitle("LOGO Groupe 7");
     this.setSize(750,500);
     this.setLayout(new GridLayout(2,1));
     
     //Partie petite entete
        petiteEntete = new JPanel();
        petiteEntete.setLayout(new GridLayout(2,2)); //2lignes et 1 colonne
        
        lblNomEleve = new JLabel(nomEleve + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblPrenomEleve = new JLabel(prenomEleve);
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblClasseEleve = new JLabel(classeEleve);
        lblClasseEleve.setFont(new Font("Arial",Font.BOLD,15));
        petiteEntete.add(lblNomEleve);
        petiteEntete.add(lblPrenomEleve);
        petiteEntete.add(lblClasseEleve);
        
        
        //Partie entete
        entete=new JPanel();
        entete.setLayout(new GridLayout(1,3));
        
        numeroExercice = new JLabel(titreExercice);
        numeroExercice.setHorizontalAlignment(SwingConstants.CENTER);
        numeroExercice.setFont(new Font("Arial",Font.BOLD,20));
        
        retourMenu= new JButton("Retour Menu");
        retourMenu.addActionListener(new ActionListener(){
                public void actionPerformed (ActionEvent e) {
                    //réoriente vers MenuEleve
                    MenuEleve app = new MenuEleve(nomEleve,prenomEleve,classeEleve);
                }
        
            });
        entete.add(petiteEntete);
        entete.add(numeroExercice);
        entete.add(retourMenu);
        
        this.maJTable = new ViewVisuTentativeEleve(menuEleve);
        this.add(maJTable);
        this.add(entete);
        
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
}    
}
