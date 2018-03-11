package ihm.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Group7
 */
public class InterfaceAjoutExercice extends JFrame {
    private JPanel General;
    private JPanel Droite;
    
                
    private JPanel Tree; 
    private JLabel Arbre;
    
    private JPanel PanelHaut;
    private JLabel CreerExercice;    
    private JButton Menu;
    
    private JPanel Exercice; 
    private JTextField Titre;
    private JButton Valider;
    private JButton Trapide;
    private JButton Tclassique;
    private JButton Tcouleur;
    private JComboBox Couleur;

    private JButton Tourner;
    private JButton Avancer;
    private JButton Ecrire;
    private JButton Executer;
    private JLabel lignecode;
   
           
    public InterfaceAjoutExercice(){
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("Ajout Exercice");
        this.setSize(750,500);  //largeur, hauteur
        

        //Partie JTree à gauche 
        Tree = new JPanel();
        Tree.setPreferredSize(new Dimension(140,450));
        Arbre = new JLabel("Affichage du JTree");
        //Arbre.setVerticalAlignment(SwingConstants.CENTER);
        //Arbre.setFont(new Font("Arial",Font.BOLD,15));
        Tree.add(Arbre);     
        
        
        //Boutton Menu
        Menu = new JButton("Menu");
        Menu.setPreferredSize(new Dimension(20,10));   
        Menu.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //réoriente vers InterfaceDebut
                    InterfaceProfesseur app = new InterfaceProfesseur();
                }
            }); 
        
        
//---------------------------------------------------------
//               Partie Ajout d'un Exercice
//---------------------------------------------------------
        Exercice = new JPanel();
        Exercice.setPreferredSize(new Dimension(550,400));
        Exercice.setLayout(new GridLayout(6,3));
        
        Titre = new JTextField("Titre");
        
        
        Valider = new JButton ("Valider Exercice");
        Valider.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut(); //changer pour nouveau exercice! addExercice();
                }
            }); 
    
        Trapide = new JButton ("Tortue Rapide");
        Trapide.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut(); //changer pour Trapide();
                }
            }); 
    
        Tclassique = new JButton ("Tortue Classique");
        Tclassique.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut(); //changer pour Tclassique();
                }
            }); 
    
        Tcouleur = new JButton ("Tortue Couleur");
        Tcouleur.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut(); //changer pour Tcouleur();
                }
            }); 
        
        Couleur = new JComboBox();
		//Couleur.setFont(font);
		Couleur.addItem("Rouge");
		Couleur.addItem("Bleu");
		Couleur.addItem("Vert");
		Couleur.addItem("Cyan");
		Couleur.addItem("Orange");
		Couleur.addItem("Jaune");
		Couleur.addItem("Violet");
		Couleur.addItem("Noir");
		Couleur.addItem("Blanc");
		
    
        Tourner = new JButton ("Tourner");
        Tourner.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut(); // changer pour turn();
                }
            }); 
    
        Avancer = new JButton ("Avancer");
        Avancer.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut(); //changer pour avance();
                }
            }); 
    
        Ecrire = new JButton ("Ecrire");
        Ecrire.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut(); //changer tracer();
                }
            }); 
    
        Executer = new JButton ("Executer");
        Executer.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    InterfaceDebut app = new InterfaceDebut(); //changer execute();
                }
            }); 
        
        lignecode = new JLabel("ligne de code");
        lignecode.setHorizontalAlignment(SwingConstants.CENTER);
        lignecode.setFont(new Font("Arial",Font.BOLD,15));
        
       
        Exercice.add(Titre);
        Exercice.add(Valider);
        Exercice.add(Trapide);
        Exercice.add(Tclassique);
        Exercice.add(Tcouleur);
        Exercice.add(Couleur);
        Exercice.add(Tourner);
        Exercice.add(Avancer);
        Exercice.add(Ecrire);
        Exercice.add(Executer);
        Exercice.add(lignecode);        

       
        //Partie droite de la Frame
        Droite = new JPanel();
        Droite.setPreferredSize(new Dimension(550,450));
        PanelHaut = new JPanel();
        PanelHaut.setPreferredSize(new Dimension(550,50));
        PanelHaut.setLayout(new GridLayout(1,2));
                
        CreerExercice = new JLabel("Creer un Exercice");
        CreerExercice.setHorizontalAlignment(SwingConstants.CENTER);
        CreerExercice.setFont(new Font("Arial",Font.BOLD,20));
        PanelHaut.add(CreerExercice);
        PanelHaut.add(Menu);
        
        Droite.add(PanelHaut);
        Droite.add(Exercice);
                
        
        //Partie Général
        General = new JPanel();
        General.add(Tree,BorderLayout.WEST);
        General.add(Droite,BorderLayout.EAST);
                            
        this.add(General);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }    
}
