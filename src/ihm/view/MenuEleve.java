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
public class MenuEleve extends JPanel{
    
    private JLabel lblNomEleve;
    private JLabel lblPrenomEleve;
    private JLabel lblClasseEleve;
    private JLabel menu;
    private JLabel imageTortue;
    
    private JButton deconnexion;
    
    private JPanel entete; //Info elève Menu et deconnexion
    private JPanel petiteEntete; // info élève
    private JPanel exercices; // JTable exercice
    private JPanel actionsExo;
    private JPanel panelBas;
    private JPanel general;
    private JPanel imageEntete;
    private JPanel texteEntete;
            
    private JLabel mesExercices;
    private JLabel listeExercices;
  
    private JPanel tentative; 
    private JLabel nexo;
    private JButton faireTentative;
    private JButton visualiserTentative;
    
    private ViewTableExercicesEleves maJTable;
    
    private Exercice currentExercice;
    private Tentative currentTentative;
    private Eleve monCurrentEleve;
    
    private static controllerMenuEleve controlEleve;
    
    public MenuEleve (Eleve currentEleve){
        
        this.setLayout(new BorderLayout());
        this.setSize(900,600);
        
        monCurrentEleve = currentEleve;
        
        controlEleve = new controllerMenuEleve(this);
        
        //Partie petite entete
        
        imageEntete = new JPanel();
        texteEntete = new JPanel();
        texteEntete.setLayout(new GridLayout(3,2)); 
        
        
       
        
        imageTortue = new JLabel();
        imageTortue.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue.png")));
        imageTortue.setHorizontalAlignment(SwingConstants.CENTER);
        lblNomEleve = new JLabel(currentEleve.getNomEleve() + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblPrenomEleve = new JLabel(currentEleve.getPrenomEleve());
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblClasseEleve = new JLabel(currentEleve.getNiveau().getNiveau());
        lblClasseEleve.setFont(new Font("Arial",Font.BOLD,15));
        JLabel blanc = new JLabel("");
        JLabel blanc2 = new JLabel("");
        imageEntete.add(imageTortue);
        texteEntete.add(lblNomEleve);
        texteEntete.add(lblPrenomEleve);
        texteEntete.add(blanc);
        texteEntete.add(blanc2);
        texteEntete.add(lblClasseEleve);
        
        petiteEntete = new JPanel();
        petiteEntete.add(imageEntete,BorderLayout.WEST);
        petiteEntete.add(texteEntete,BorderLayout.EAST);
        
        
        
        
        //partie entete
        entete = new JPanel();
        entete.setLayout(new FlowLayout(FlowLayout.RIGHT, 140, 0)); 
       // entete.setLayout(new BorderLayout());
        
        menu = new JLabel("MENU");
        menu.setFont(new Font("Arial",Font.BOLD,30));
        
        //bouton deconnexion
        deconnexion = new JButton("Deconnexion");
        deconnexion.addActionListener(controlEleve);
        
        entete.add(petiteEntete);
        entete.add(menu);
        entete.add(deconnexion);
        
        
        
        //Partie Mes Exercices
        exercices = new JPanel();
        //Exercices.setPreferredSize(new Dimension(350,450)); //largeur hauteur
        exercices.setLayout(new GridLayout(2,1));  
        
        mesExercices = new JLabel("Mes Exercices");
        mesExercices.setVerticalAlignment(SwingConstants.CENTER);
        mesExercices.setFont(new Font("Arial",Font.BOLD,30));
        
        this.maJTable = new ViewTableExercicesEleves(this);
        exercices.setPreferredSize(new Dimension(500,500));
        exercices.add(mesExercices);
        exercices.add(maJTable); 
                
        //Partie Tentatives
        tentative = new JPanel();
        tentative.setPreferredSize(new Dimension(200,100));
        tentative.setLayout(new GridLayout(3,1));
              
        nexo = new JLabel("N° Exercice");
        nexo.setVerticalAlignment(SwingConstants.CENTER);
        tentative.add(nexo);        
        
        faireTentative = new JButton("Faire une tentative");
        faireTentative.setPreferredSize(new Dimension(150,50));
        faireTentative.setEnabled(false);
        //faireTentative.addActionListener(controlEleve);
        faireTentative.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    
                    TentativeEleve tent = new TentativeEleve(currentEleve, currentExercice);
                    
                }
            }); 
        
        visualiserTentative = new JButton("Visualiser mes tentatives");
        visualiserTentative.setEnabled(false);
        visualiserTentative.setHorizontalAlignment(SwingConstants.CENTER);
        visualiserTentative.addActionListener(controlEleve);
        
        tentative.add(faireTentative);
        tentative.add(visualiserTentative);
       
        
        //Partie du bas         
        panelBas = new JPanel();
        panelBas.setPreferredSize(new Dimension(725,325));   //largeur, hauteur
        panelBas.setLayout(new BorderLayout()); //1 ligne et 2 colonnes
        panelBas.add(tentative,BorderLayout.SOUTH);
        panelBas.add(exercices,BorderLayout.CENTER);
        
        
        //Partie Général
        general = new JPanel();
        general.add(entete,BorderLayout.NORTH);
        general.add(panelBas,BorderLayout.CENTER);
                    
        this.add(general, BorderLayout.CENTER);
        
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
        //this.setLocationRelativeTo(null);
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
    
        public void afficheInfoTentative(MenuEleve this,Tentative node) {
	if (node instanceof Tentative) {
            currentTentative = node;
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
    *@return bouton faire tentative
    */
    public JButton getDeconnexion() {
        return deconnexion;
    }

    /*
    *@return bouton visualiser tentative
    */
    public JButton getVisualiserTentative() {
        return visualiserTentative;
    }
    
    public Eleve getCurrentEleve(){
        return monCurrentEleve;
    }
    
    public String getCurrentExercice(){
        return currentExercice.getTitre();
    }
    
    public JPanel getGeneral(){
        return general;
    }
    
}
