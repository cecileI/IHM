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
public class ModifExerciceProf extends JPanel{
    private JPanel ModifExeciceProf;
  
    private JPanel Tree; 
    private JLabel Arbre;
  
    private JPanel Exercice; 
    private JButton CreerExercice;
    private JButton ModifierExercice;
           
    public ModifExerciceProf(){
        //this.getContentPane().setLayout(new BorderLayout()); 
        //this.setTitle("Menu Professeur");
        this.setSize(750,400);  //largeur, hauteur
        
               
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
       
                
        ModifExeciceProf = new JPanel();
        ModifExeciceProf.setPreferredSize(new Dimension(725,325));   //largeur, hauteur
        ModifExeciceProf.setLayout(new GridLayout(1,2)); //1 ligne et 2 colonnes
        ModifExeciceProf.add(Tree);
        ModifExeciceProf.add(Exercice);
                            
        this.add(ModifExeciceProf);
        
//        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);        
    }    
}
