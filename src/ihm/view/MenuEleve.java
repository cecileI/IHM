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
 * @author Group7
 */
public class MenuEleve extends JFrame{
    
    private JLabel lblNomEleve;
    private JLabel lblPrenomEleve;
    private JLabel lblClasseEleve;
    private JLabel menu;
    
    private JButton deconnexion;
    
    private JPanel entete;
    private JPanel petiteEntete;
    private JPanel exercices;
    private JPanel actionsExo;
    private JPanel panelBas;
    private JPanel general;

    private JLabel mesExercices;
    private JLabel listeExercices;
  
    private JPanel tentative; 
    private JLabel nexo;
    private JButton faireTentative;
    private JButton visualiserTentative;
    
    private ViewTableExercicesEleves maJTable;
    
    private Exercice currentExercice;
    
    public MenuEleve (String nomEleve, String prenomEleve, String classeEleve){
        
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("LOGO Groupe 7");
        this.setSize(750,500);
        
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
        
        //partie entete
        entete = new JPanel();
        entete.setLayout(new BorderLayout());
        
        menu = new JLabel("MENU");
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.setFont(new Font("Arial",Font.BOLD,20));
        
        deconnexion = new JButton("Deconnexion");
        deconnexion.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut();
                    dispose();
                }
            });
        
        entete.add(petiteEntete, BorderLayout.WEST);
        entete.add(menu, BorderLayout.CENTER);
        entete.add(deconnexion, BorderLayout.EAST);
        
        
        
        //Partie Mes Exercices
        exercices = new JPanel();
        //Exercices.setPreferredSize(new Dimension(350,450)); //largeur hauteur
        exercices.setLayout(new GridLayout(2,1));  
        
        mesExercices = new JLabel("Mes Exercices");
        mesExercices.setVerticalAlignment(SwingConstants.CENTER);
        mesExercices.setFont(new Font("Arial",Font.BOLD,30));
        
        this.maJTable = new ViewTableExercicesEleves(this);
        
        exercices.add(mesExercices);
        exercices.add(maJTable); 
                
        //Partie Tentatives
        tentative = new JPanel();
        tentative.setLayout(new GridLayout(3,1));
              
        nexo = new JLabel("N° Exercice");
        nexo.setVerticalAlignment(SwingConstants.CENTER);
        tentative.add(nexo);        
        
        faireTentative = new JButton("Faire une tentative");
        faireTentative.setEnabled(false);
        faireTentative.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    InterfaceDebut app = new InterfaceDebut(); //changer pour nouvelle tentative!!
                }
            }); 
              
        visualiserTentative = new JButton("Visualiser mes tentatives");
        visualiserTentative.setEnabled(false);
        visualiserTentative.setHorizontalAlignment(SwingConstants.CENTER);
        visualiserTentative.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    InterfaceDebut app = new InterfaceDebut(); //changer pour VisualiserTentative!!
                }
            }); 
        
        tentative.add(faireTentative);
        tentative.add(visualiserTentative);
       
        
        //Partie du bas         
        panelBas = new JPanel();
        panelBas.setPreferredSize(new Dimension(725,325));   //largeur, hauteur
        panelBas.setLayout(new GridLayout(1,2)); //1 ligne et 2 colonnes
        panelBas.add(exercices);
        panelBas.add(tentative);
        
        
        //Partie Général
        general = new JPanel();
        general.add(entete,BorderLayout.NORTH);
        general.add(panelBas,BorderLayout.SOUTH);
                    
        this.add(general);
        this.add(entete, BorderLayout.NORTH);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /*
    * Cette fonction  permet de récupérer l'exercice sélectionné 
    * dans la JTable
    *@param MenuEleve : interface menu eleve
    *@param node : exercice sélectionné
    */
    public void afficheInfo(MenuEleve this,Exercice node) {
	if (node instanceof Exercice) {
            currentExercice = node;
            nexo.setText(currentExercice.getTitre());
            update();
	}
    }
    /*
    * Cette fonction permet de rendre cliquable les boutons 
    * Faire Tentative et Visualiser Tentative 
    * quand on a sélectionné un exercice 
    */
    public void update(){
        if (currentExercice != null){
            faireTentative.setEnabled(true);
            visualiserTentative.setEnabled(true);
        }
    }
    
    /*
    *@return bouton faire tentative
    */
    public JButton getFaireTentative() {
        return faireTentative;
    }

    /*
    *@return bouton visualiser tentative
    */
    public JButton getVisualiserTentative() {
        return visualiserTentative;
    }
    
    
    
    
}
