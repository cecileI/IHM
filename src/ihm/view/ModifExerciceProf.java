package ihm.view;

import ihm.controler.*;

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
 * Crée le Panel permettant à un Professeur de Modifier un Exercice
 * @author Diane
 */
public class ModifExerciceProf extends JPanel{
    private JButton CreerExercice;
    private JButton ModifierExercice;
           
    public ModifExerciceProf(){
        setLayout(new BorderLayout());
        //pour instancier le controllerModifExerciceProf et appeler les ActionEvent en cliquant sur les boutons
        controllerModifExerciceProf controlProf = new controllerModifExerciceProf(this);   
        
        //Partie Exercice
        setLayout(new GridLayout(2,1));                      
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
        
        add(CreerExercice);
        add(ModifierExercice);
    }    
}
