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
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *  Cette classe permet de créé une fenetre qui permettra a l'élève d'acceder à ces fonctionnalitées
 * @author Goup7
 */
public class MenuProfesseur extends JFrame {
   
    //JPanel
    private JPanel panGeneral; //panel général qui regroupe toutes les informations de la Jframe
    private JPanel panDroite; //panel à droite qui sera modifier par des nouveaux panel
    private JPanel panHaut; //panel de deconnection et panel blanc
    private JPanel panExercice; //panel qui regroupe les boutons création et modification exercice
    
    //JButton
    private JButton creerExercice; //bouton création exercice
    private JButton modifierExercice; //bouton modification exercice
    private JButton deconnection; //bouton deconnection
    
    //JTree
    private ViewJTree panTree; //panel à gauche Jtree
    private JTextField txtNom;
           
    public MenuProfesseur(){
              
        //Partie JTree à gauche 
            panTree=new ViewJTree();
            panTree.createTree();
            //panTree.setPreferredSize(new Dimension(140,450));
                       
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
            //Bouton création exercice
        creerExercice = new JButton("Créer un Exercice");
        creerExercice.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    AjoutExerciceProf app = new AjoutExerciceProf();
                }
            }); 
            //Bouton modification exercice
        modifierExercice = new JButton("Modifier un Exercice");
        //ModifierExercice.setHorizontalAlignment(SwingConstants.CENTER);
        modifierExercice.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    ListeExercicesProf panel = new ListeExercicesProf();
                    
                }
            });      
        // En haut : un blanc et bouton deconnection      
        txtNom = new JTextField("");
        txtNom.setHorizontalAlignment(SwingConstants.CENTER);
        
        panHaut = new JPanel();
        panHaut.setPreferredSize(new Dimension(550,50));
        panHaut.setLayout(new GridLayout(1,2));
        panHaut.add(txtNom); //JLabel blanc
        panHaut.add(deconnection);   //JPanel Deconnection   
        
        //panExercice qui contient les boutons créer et modifier
        JLabel blanc1 = new JLabel("");
        blanc1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc2 = new JLabel("");
        blanc2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc3 = new JLabel("");
        blanc3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc4 = new JLabel("");
        blanc4.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc5 = new JLabel("");
        blanc5.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc6 = new JLabel("");
        blanc6.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        panExercice = new JPanel();
        panExercice.setPreferredSize(new Dimension(550,400));
        panExercice.setLayout(new GridLayout(4,2));
        panExercice.add(blanc1);
        panExercice.add(blanc2);
        panExercice.add(creerExercice); //JButton créer exercice
        panExercice.add(modifierExercice); //JButton modifier exercice
        panExercice.add(blanc3);
        panExercice.add(blanc4);
        panExercice.add(blanc5);
        panExercice.add(blanc6);
        
        //panDroite qui contient panHaut et panExercice
        panDroite = new JPanel();
        panDroite.setPreferredSize(new Dimension(550,450));
        panDroite.add(panHaut);
        panDroite.add(panExercice);
        
        panGeneral = new JPanel();
        panGeneral.setLayout(new BorderLayout()); 
        panGeneral.add(panTree,BorderLayout.WEST);     //ajout du JTree au menu (à gauche)
        panGeneral.add(panDroite,BorderLayout.EAST);   //ajout du panel général au menu
        
        this.add(panGeneral);
        
        //this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("Menu Professeur");
        this.setSize(750,500);  //largeur, hauteur
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);        
    }    
    
    public JTextField gettxtNom(){
        return(txtNom);
    }
}
