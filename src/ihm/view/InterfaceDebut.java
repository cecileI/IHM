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
 * @author Group7
 */
public class InterfaceDebut extends JFrame {
    
    private JPanel panelGeneral;
    private JPanel panelEleve;
    private JPanel panelProf;
    
    private JLabel jeSuis;
    private JLabel message;
    
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
        
        unEleve = new JLabel("Un élève");
        unEleve.setHorizontalAlignment(SwingConstants.CENTER);
        unEleve.setFont(new Font("Arial",Font.BOLD,30));
        panelEleve.add(unEleve);
        
        prenomEleve = new JTextField("Xavier");
        prenomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        prenomEleve.setPreferredSize( new Dimension( 100, 50 ) );
        panelEleve.add(prenomEleve);
        
        nomEleve = new JTextField("Poalon");
        nomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(nomEleve);
        
        classeEleve = new JTextField("CE1");
        classeEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(classeEleve);
        
        validEleve = new JButton("Valider");
        validEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(validEleve);
        validEleve.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    String prenomE = prenomEleve.getText();
                    String nomE = nomEleve.getText();
                    String classe = classeEleve.getText();

                    if (controllerConnexion.connexionEleve(prenomE, nomE, classe)==true){
                        //MenuEleve interfaceEleve = new MenuEleve(nomE,prenomE,classe);
                        
                        TentativeEleve tent = new TentativeEleve(nomE,prenomE,classe);
                        
                        //ferme la fenetre de connexion
                        System.out.println("connexion reussie");
                        dispose();
                    }else{
                        message = new JLabel();
                        message.setText("Connexion refusée");
                    }
                }
            }); 
        

        //Partie prof
        panelProf = new JPanel();
        panelProf.setLayout(new GridLayout(5,1)); //5lignes et 1 colonne
        
        unProfesseur = new JLabel("Un professeur");
        unProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
        unProfesseur.setFont(new Font("Arial",Font.BOLD,30));
        panelProf.add(unProfesseur);
        
        prenomProf = new JTextField("Charles");
        prenomProf.setHorizontalAlignment(SwingConstants.CENTER);
        prenomProf.setPreferredSize( new Dimension( 100, 50 ) );
        panelProf.add(prenomProf);
        
        nomProf = new JTextField("Abot");
        nomProf.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(nomProf);
        
        motDePasse = new JTextField("1234");
        motDePasse.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(motDePasse);
        
        validProf = new JButton("Valider");
        validProf.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(validProf);
        validProf.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees du prof 
                    String prenomP = prenomProf.getText();
                    String nomP = nomProf.getText();
                    String mdp = motDePasse.getText();

                    if (controllerConnexion.connexionProf(prenomP, nomP, mdp)==true){
                        System.out.println("connexion reussie");
                        MenuProfesseur menuProf = new MenuProfesseur();  //ouvre Menu Professeur
                        
                    }else{
                        message = new JLabel();
                        message.setText("Connexion refusée");
                    }
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
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
 
}


