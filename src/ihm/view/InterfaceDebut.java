/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Group7
 */
public class InterfaceDebut extends JFrame {
    
    private JPanel panelGeneral;
    private JPanel panelEleve;
    private JPanel panelProf;
    
    private JLabel jeSuis;
    
    private JLabel unEleve;
    private JTextField prenomEleve;
    private JTextField nomEleve;
    private JTextField classeEleve;
    
    private JLabel unProfesseur;
    private JTextField prenomProf;
    private JTextField nomProf;
    private JTextField motDePasse;
    
    private JButton validEleve;
    private JButton validProf;
    
    public InterfaceDebut(){
        
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("LOGO Groupe 7");
        this.setSize(750,500);
        
        //Partie eleve
        panelEleve = new JPanel();
        panelEleve.setLayout(new GridLayout(5,1)); //5lignes et 1 colonne
        
        unEleve = new JLabel("Un elève");
        unEleve.setHorizontalAlignment(SwingConstants.CENTER);
        unEleve.setFont(new Font("Arial",Font.BOLD,30));
        panelEleve.add(unEleve);
        
        prenomEleve = new JTextField("Mon Prénom");
        prenomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        prenomEleve.setPreferredSize( new Dimension( 100, 50 ) );
        panelEleve.add(prenomEleve);
        
        nomEleve = new JTextField("Mon Nom");
        nomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(nomEleve);
        
        classeEleve = new JTextField("Ma Classe");
        classeEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(classeEleve);
        
        validEleve = new JButton("Valider");
        validEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(validEleve);

        //Partie prof
        panelProf = new JPanel();
        panelProf.setLayout(new GridLayout(5,1)); //5lignes et 1 colonne
        
        unProfesseur = new JLabel("Un professeur");
        unProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
        unProfesseur.setFont(new Font("Arial",Font.BOLD,30));
        panelProf.add(unProfesseur);
        
        prenomProf = new JTextField("Prénom");
        prenomProf.setHorizontalAlignment(SwingConstants.CENTER);
        prenomProf.setPreferredSize( new Dimension( 100, 50 ) );
        panelProf.add(prenomProf);
        
        nomProf = new JTextField("Nom");
        nomProf.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(nomProf);
        
        motDePasse = new JTextField("Mot de passe");
        motDePasse.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(motDePasse);
        
        validProf = new JButton("Valider");
        validProf.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(validProf);
        validProf.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees du prof et appelle la fonction de verif pour connexion
                    String prenomP = prenomProf.getText();
                    String nomP = nomProf.getText();
                    String mdp = motDePasse.getText();
                    ConnexionProf(prenomP, nomP, mdp);
                }
            }); 
        
        //Partie générale
        jeSuis = new JLabel("Je suis");
        jeSuis.setHorizontalAlignment(SwingConstants.CENTER);
        jeSuis.setFont(new Font("Arial",Font.BOLD,50));
        panelGeneral = new JPanel();
        panelGeneral.setLayout(new GridLayout(1,3));
        panelGeneral.add(panelEleve);
        JLabel labelBlanc = new JLabel("");
        panelGeneral.add(labelBlanc);
        panelGeneral.add(panelProf);
        
        this.add(jeSuis, BorderLayout.NORTH);
        this.add(panelGeneral);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    
    public static void main(String[] args) {
        InterfaceDebut interfaceDebut = new InterfaceDebut();
    }
    
    
}


