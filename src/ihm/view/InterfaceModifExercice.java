package ihm.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Group7
 */
public class InterfaceModifExercice extends JFrame {
    private JPanel General;
    private JPanel PanelHaut;
    private JPanel PanelBas;
  
    private JPanel Tree; 
    private JLabel Arbre;
  
    private JPanel Exercice; 
    private JButton CreerExercice;
    private JButton ModifierExercice;

    private JButton deconnection;
           
    public InterfaceModifExercice(){
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("Menu Professeur");
        this.setSize(750,500);  //largeur, hauteur
        
        //Boutton Deconnection
        deconnection = new JButton("Deconnection");
        deconnection.setPreferredSize(new Dimension(20,10));
             
       
        deconnection.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //réoriente vers InterfaceDebut
                    InterfaceDebut app = new InterfaceDebut();
                }
            }); 
        
        //Partie JTree
        Tree = new JPanel();
        
        Arbre = new JLabel("Affichage du JTree");
        //Arbre.setVerticalAlignment(SwingConstants.CENTER);
        Arbre.setFont(new Font("Arial",Font.BOLD,30));
        Tree.add(Arbre);        
        

        //Partie Exercice
        Exercice = new JPanel();
        Exercice.setLayout(new GridLayout(2,1));
                      
        CreerExercice = new JButton("Créer un Exercice");
        CreerExercice.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    InterfaceDebut app = new InterfaceDebut(); //changer pour nouveau exercice! addExercice();
                }
            }); 
              
        ModifierExercice = new JButton("Modifier un Exercice");
        ModifierExercice.setHorizontalAlignment(SwingConstants.CENTER);
        ModifierExercice.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    InterfaceDebut app = new InterfaceDebut(); //changer pour modifyExercice();
                }
            }); 
        
        Exercice.add(CreerExercice);
        Exercice.add(ModifierExercice);
       
        //Partie supérieur de la Frame 
        PanelHaut = new JPanel();
        PanelHaut.setPreferredSize(new Dimension(700,50));
        PanelHaut.setLayout(new GridLayout(1,2));
                
        JLabel labelBlanc = new JLabel("");
        labelBlanc.setHorizontalAlignment(SwingConstants.CENTER);
        PanelHaut.add(labelBlanc);
        
        //this.add(deconnection, BorderLayout.LINE_END);
        PanelHaut.add(deconnection);
        
        //Partie du bas         
        PanelBas = new JPanel();
        PanelBas.setPreferredSize(new Dimension(725,325));   //largeur, hauteur
        PanelBas.setLayout(new GridLayout(1,2)); //1 ligne et 2 colonnes
        PanelBas.add(Tree);
        PanelBas.add(Exercice);
        
        
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
