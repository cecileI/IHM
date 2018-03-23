/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.view;

import ihm.model.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 *
 * @author Clara
 */
public class TentativeEleve extends JFrame{
    //entete
    private JLabel lblNomEleve;
    private JLabel lblPrenomEleve;
    private JLabel lblClasseEleve;
    private JButton menu;
    private JPanel petiteEntete;
    private JPanel entete;
    
    //Tentative
    private JPanel tentative; //panel sous l'entete
    
    //private modele;
    private Canvas can;
    private JTextArea lignesCode;
    
    //petit panel de boutons
    private JPanel petitPanelBoutons;
    private JPanel panelBoutons;
    private JButton tourner;
    private JButton avancer;
    private JButton ecrire;
   
    //grand panel de boutons
    private JPanel grandPanelBoutons;
    private JPanel panelBasBoutons;
    private JButton tortueRapide;
    private JButton tortueClassique;
    private JButton tortueCouleur;
    private JComboBox couleurs;
    private JButton valider;
    private JButton executer;
    
    private TortueG tortueG;

           
    public TentativeEleve(String nomE, String prenomE, String classeE){
        
        this.getContentPane().setLayout(new BorderLayout());
        this.setSize(750,500);  //largeur, hauteur
  
        //------------------------------------
        // Partie entete 
        //------------------------------------

        //Bouton Menu
        menu = new JButton("Menu");
        menu.setPreferredSize(new Dimension(20,10));   
        menu.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //réoriente vers le menu élève
                    //MenuEleve menueleve = new MenuEleve();
                }
            }); 
        //infos élève
        lblNomEleve = new JLabel(nomE + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblPrenomEleve = new JLabel(prenomE);
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblClasseEleve = new JLabel(classeE);
        lblClasseEleve.setFont(new Font("Arial",Font.BOLD,15));
        
        petiteEntete = new JPanel();
        petiteEntete.setLayout(new GridLayout(3,1));        
        petiteEntete.add(lblNomEleve);
        petiteEntete.add(lblPrenomEleve);
        petiteEntete.add(lblClasseEleve);
        
        entete = new JPanel();
        entete.setLayout(new GridLayout(1,2));//1ligne 2 colonnes
        entete.add(petiteEntete);
        entete.add(menu);
        
//---------------------------------------------------------
//               Partie Faire une tentative
//---------------------------------------------------------
        tentative = new JPanel();
        tentative.setPreferredSize(new Dimension(550,400));
        tentative.setLayout(new GridLayout(2,3)); //2lignes 3 colonne
        
        
        //modèle du professeur
        JLabel modele = new JLabel("Le modele");
        
        
        //lignes de code produites par l'élève
        lignesCode = new JTextArea();
        
        
        //visualisation directe de la tentative de l'élève
        
        tortueG = new TortueG();
        
        JPanel tentativeEleve = new JPanel();
        tentativeEleve = ihm.model.Canvas.getCanvasPanel();      
        tentativeEleve.setPreferredSize(new Dimension(400,300));
       
        
        
        //petit panel de boutons
        tourner = new JButton("Tourner");
        tourner.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                //
            }
        });
        
        avancer = new JButton("Avancer");
        avancer.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                //
            }
        });
        
        ecrire = new JButton("Ecrire");
        ecrire.addActionListener(new ActionListener () {
            public void actionPerformed (ActionEvent e) {
                //
            }
        });
        
        
        petitPanelBoutons = new JPanel();
        petitPanelBoutons.setLayout(new GridLayout(1,2));
        petitPanelBoutons.add(tourner);
        petitPanelBoutons.add(avancer);
        panelBoutons = new JPanel();
        panelBoutons.setLayout(new GridLayout(2,1));
        panelBoutons.add(petitPanelBoutons);
        panelBoutons.add(ecrire);
        
        
        
        
        // Grand panel de boutons
        tortueRapide = new JButton ("Tortue Rapide");
        tortueRapide.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //changer pour Trapide();
                }
            }); 
    
        tortueClassique = new JButton ("Tortue Classique");
        tortueClassique.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //changer pour Tclassique();
                }
            }); 
    
        tortueCouleur = new JButton ("Tortue Couleur");
        tortueCouleur.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //changer pour Tcouleur();
                }
            }); 
        
        couleurs = new JComboBox();
		//Couleur.setFont(font);
		couleurs.addItem("black");
		couleurs.addItem("red");
		couleurs.addItem("blue");
		couleurs.addItem("green");
		couleurs.addItem("yellow");
		couleurs.addItem("magenta");
	
    
        executer = new JButton ("Executer");
        executer.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //changer execute();
                }
            }); 
        
        valider = new JButton ("Valider");
        valider.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //changer execute();
                }
            }); 
        
        
        
        grandPanelBoutons = new JPanel();
        grandPanelBoutons.setLayout(new GridLayout(4,1));//7llignes 1 colonne
        grandPanelBoutons.add(tortueRapide);
        grandPanelBoutons.add(tortueClassique);
        grandPanelBoutons.add(tortueCouleur);
        grandPanelBoutons.add(couleurs);
        
        panelBasBoutons = new JPanel();
        panelBasBoutons.setLayout(new GridLayout(2,1));
        panelBasBoutons.add(executer);
        panelBasBoutons.add(valider);

        tentative.add(modele);
        tentative.add(tentativeEleve);
        tentative.add(grandPanelBoutons);
        
        tentative.add(lignesCode);
        tentative.add(panelBoutons);
        tentative.add(panelBasBoutons);
        
        
        this.add(entete, BorderLayout.NORTH);
        this.add(tentative, BorderLayout.SOUTH);
       
        this.setVisible(true); 
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    
    }
    
    
}
