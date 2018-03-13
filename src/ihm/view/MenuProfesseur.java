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
 * @author Goup7
 */
public class MenuProfesseur extends JFrame {
   
    private JPanel General;
    private JPanel Droite;
    private JPanel PanelHaut;
    private JPanel PanelBas;
  
    private JPanel Tree; 
    private JLabel Arbre;
  
    private JPanel Exercice; 
    private JButton CreerExercice;
    private JButton ModifierExercice;

    private JButton deconnection;
           
    public MenuProfesseur(){
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("Menu Professeur");
        this.setSize(750,500);  //largeur, hauteur
               
        //Partie JTree à gauche 
        Tree = new JPanel();
        Tree.setPreferredSize(new Dimension(140,450));
        Arbre = new JLabel("Affichage du JTree");
        //Arbre.setVerticalAlignment(SwingConstants.CENTER);
        //Arbre.setFont(new Font("Arial",Font.BOLD,15));
        Tree.add(Arbre);         
                       
        //Boutton Deconnection
        deconnection = new JButton("Deconnection");
        deconnection.setPreferredSize(new Dimension(20,10));
        deconnection.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //réoriente vers InterfaceDebut
                    InterfaceDebut app = new InterfaceDebut();
                }
            }); 
        

        //Partie Exercice
        Exercice = new JPanel();
        Exercice.setPreferredSize(new Dimension(550,400));
        Exercice.setLayout(new GridLayout(2,1));
                      
        CreerExercice = new JButton("Créer un Exercice");
        CreerExercice.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    AjoutExerciceProf app = new AjoutExerciceProf(); //changer pour nouveau exercice! addExercice();
                }
            }); 
              
        ModifierExercice = new JButton("Modifier un Exercice");
        //ModifierExercice.setHorizontalAlignment(SwingConstants.CENTER);
        ModifierExercice.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    ModifExerciceProf app = new ModifExerciceProf(); //changer pour modifyExercice();
                }
            }); 
        
        Exercice.add(CreerExercice);
        Exercice.add(ModifierExercice);
       
        //Partie Gauche  = Jtree        
        //Partie Droite de la frame = Haut et Bas
        Droite = new JPanel();
        Droite.setPreferredSize(new Dimension(550,450));
        PanelBas = new JPanel();
        PanelBas.setPreferredSize(new Dimension(550,400));
        PanelHaut = new JPanel();
        PanelHaut.setPreferredSize(new Dimension(550,50));  
        PanelHaut.setLayout(new GridLayout(1,2));
                
        JLabel labelBlanc = new JLabel("");
        labelBlanc.setHorizontalAlignment(SwingConstants.CENTER);
        PanelHaut.add(labelBlanc);
        PanelHaut.add(deconnection);              
        PanelBas.add(Exercice);
        
        Droite.add(PanelHaut);
        Droite.add(PanelBas);
                
        //Partie Général
        General = new JPanel();
        General.setPreferredSize(new Dimension(750,500));
        General.add(Tree,BorderLayout.WEST);
        General.add(Droite,BorderLayout.EAST);
        
        this.add(General);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }    
    
}
