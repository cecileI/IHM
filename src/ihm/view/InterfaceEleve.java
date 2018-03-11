package ihm.view;

import ihm.controler.*;
import ihm.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Goup7
 */
public class InterfaceEleve extends JFrame {
   
    private JPanel General;
    private JPanel PanelHaut;
    private JPanel PanelBas;
    
    private JLabel Menu;
    
    private JPanel Eleve;
    private JLabel nomEleve;
    //private JLabel prenomEleve; que Nom et Classe de l'élève? cf schéma
    private JLabel classeEleve;
    
    private JPanel Exercices; 
    private JLabel MesExercices;
    private JLabel ListeExercices;
  
    private JPanel Tentative; 
    private JLabel nexo;
    private JButton FaireTentative;
    private JButton VisualiserTentative;
    
    //private JPanel Deconnect; 
    private JButton deconnection;
   
        
    public InterfaceEleve(){
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("Menu Eleve");
        this.setSize(750,500);  //largeur, hauteur
        
        //Partie Eleve
        Eleve = new JPanel();
        Eleve.setLayout(new GridLayout(2,1)); //3 lignes et 1 colonne
                
        nomEleve = new JLabel("Nom élève");
        //nomEleve.setHorizontalAlignment(SwingConstants.WEST);
        //nomEleve.setPreferredSize( new Dimension( 50, 25 ) );
        //nomEleve.setFont(new Font("Arial",Font.BOLD,10));
        Eleve.add(nomEleve);
        
//        prenomEleve = new JLabel("Prénom");
//        Eleve.add(prenomEleve);
      
        classeEleve = new JLabel("Classe élève");
        Eleve.add(classeEleve);
        
        
        //Boutton Deconnection
        deconnection = new JButton("Deconnection");
        deconnection.setPreferredSize(new Dimension(20,10));
             
       
        deconnection.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //réoriente vers InterfaceDebut
                    InterfaceDebut app = new InterfaceDebut();
                }
            }); 
        
        
        //Partie Mes Exercices
        Exercices = new JPanel();
        //Exercices.setPreferredSize(new Dimension(350,450)); //largeur hauteur
        //Exercices.setLayout(new GridLayout(2,1));  
        
        MesExercices = new JLabel("Mes Exercices");
        //MesExercices.setVerticalAlignment(SwingConstants.CENTER);
        MesExercices.setFont(new Font("Arial",Font.BOLD,30));
        Exercices.add(MesExercices);
        
        
          
        
        ListeExercices = new JLabel("Liste des Exercices"); //changer pour connection avec BDD! et requete de la liste des exercices
        //ListeExercices.setVerticalAlignment(SwingConstants.CENTER);
        ListeExercices.setFont(new Font("Arial",Font.BOLD,15));
        //ListeExercices.setBounds(25, 25, 300, 300);
        Exercices.add(ListeExercices);
                
        //Partie Tentatives
        Tentative = new JPanel();
        Tentative.setLayout(new GridLayout(3,1));
              
        nexo = new JLabel("N° Exercice");
        Tentative.add(nexo);        
        
        FaireTentative = new JButton("Faire une tentative");
        FaireTentative.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    InterfaceDebut app = new InterfaceDebut(); //changer pour nouvelle tentative!!
                }
            }); 
              
        VisualiserTentative = new JButton("Visualiser mes tentatives");
        VisualiserTentative.setHorizontalAlignment(SwingConstants.CENTER);
        VisualiserTentative.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    InterfaceDebut app = new InterfaceDebut(); //changer pour VisualiserTentative!!
                }
            }); 
        
        Tentative.add(FaireTentative);
        Tentative.add(VisualiserTentative);
       
        //Partie supérieur de la Frame 
        PanelHaut = new JPanel();
        PanelHaut.setPreferredSize(new Dimension(700,50));
        PanelHaut.setLayout(new GridLayout(1,3));
        PanelHaut.add(Eleve);
                
        Menu = new JLabel("Menu");
        Menu.setHorizontalAlignment(SwingConstants.CENTER);
        Menu.setFont(new Font("Arial",Font.BOLD,30));
        PanelHaut.add(Menu);
        
        //this.add(deconnection, BorderLayout.LINE_END);
        PanelHaut.add(deconnection);
        
        
        //Partie du bas         
        PanelBas = new JPanel();
        PanelBas.setPreferredSize(new Dimension(725,325));   //largeur, hauteur
        PanelBas.setLayout(new GridLayout(1,2)); //1 ligne et 2 colonnes
        PanelBas.add(Exercices);
        PanelBas.add(Tentative);
        
        
        //Partie Général
        General = new JPanel();
        General.add(PanelHaut,BorderLayout.NORTH);
        General.add(PanelBas,BorderLayout.SOUTH);
                    
        this.add(General);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }    
}
