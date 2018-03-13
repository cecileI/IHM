package ihm.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * Panel affichant la liste des Exercices après que le professeur ait cliqué sur Modifier Exercice
 * le panel JTree reste le même que celui du Menu Elève
 * le panel Menu (en haut) et le panel du milieu affichant la liste des exercices change 
 * @author Group7
 */
public class ListeExercicesProf extends JPanel {
    private JPanel panListeExercices;
    private JPanel panelHaut; 
    private JLabel labelBlanc;
    private JButton retourMenu;
    
    private JPanel listeEx;
    private JLabel listedesExos;
    
    public ListeExercicesProf(){
        //MenuProfesseur.getContentPane().setLayout(new BorderLayout());
        //MenuProfesseur.setTitle("test liste des exercices");
        //this.setSize(750,500);  //largeur, hauteur
        
        //Partie Menu en haut = JPanel : panelHaut = un Label + Button retourMenu
        JPanel panelHaut = new JPanel();
        panelHaut.setPreferredSize(new Dimension(550,50));
        panelHaut.setLayout(new GridLayout(1,2)); //1 ligne et 2 colonnes
        
        JLabel labelBlanc = new JLabel("");
        labelBlanc.setHorizontalAlignment(SwingConstants.CENTER);       
        
        //Boutton Retour
        retourMenu = new JButton("Menu");
        retourMenu.setPreferredSize(new Dimension(20,10));
        retourMenu.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    MenuProfesseur app = new MenuProfesseur();
                }
            });        
        
        panelHaut.add(labelBlanc);
        panelHaut.add(retourMenu); 
        
        //Partie Liste des Exercices       
        listeEx = new JPanel();
        listeEx.setPreferredSize(new Dimension(550,400));
        listedesExos = new JLabel("Liste des exercices");
        //ListedesExos.setVerticalAlignment(SwingConstants.CENTER);
        //ListedesExos.setFont(new Font("Arial",Font.BOLD,15));
        listeEx.add(listedesExos);                      
 
        //Panel Liste des Exercices final = panListeExercices
        panListeExercices = new JPanel();
        //panListeExercices.setSize(750,400);  //largeur, hauteur       
        
        //panListeExercices.setLayout(new GridLayout(1,2)); //1 ligne et 2 colonnes
        
        panListeExercices.add(panelHaut,BorderLayout.NORTH);             
        panListeExercices.add(listeEx,BorderLayout.SOUTH); 
        
        //this.add(panListeExercices);
        
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLocationRelativeTo(null);
        //this.setVisible(true);        
    } 
}
