package ihm.view;

import ihm.view.*;
import ihm.controler.*;
import ihm.model.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * Panel affichant la liste des Exercices après que le professeur ait cliqué sur Modifier Exercice dans le MenuProfesseur
 * le panel JTree reste le même que celui du Menu Elève
 * le panel Menu (en haut) et le panel du milieu affichant la liste des exercices change par rapport au MenuProfesseur
 * il faut cliquer sur un exercice pour ensuite pouvoir le modifier et ouvrir le panel AjoutExerciceProf 
 * @author Group 7
 */
public class ListeExercicesProf extends JPanel {
    private JPanel panelDroite;
    private JPanel panelHaut; 
    private JLabel labelBlanc;
    private JButton retourMenu;
    
    private JPanel listeEx;
    private JLabel listedesExos;
    private JButton modifierEx;
    
    private ArrayList <Exercice> listeExo;
    private ViewTableExercices maJTable;
    private Exercice currentExercice;
    
    //panel pour Modifier Exercice
    private ModifExerciceProf panmodif;
    //private Exercice currentExercice;
    
    public ListeExercicesProf(){
        //pour instancier le controllerListeExercicesProf et appeler les ActionEvent en cliquant sur les boutons
        controllerListeExercicesProf controlProf = new controllerListeExercicesProf(this);      
        
        //Partie Menu en haut = JPanel : panelHaut = un Label vide + Button retourMenu
        JPanel panelHaut = new JPanel();
        panelHaut.setPreferredSize(new Dimension(600,50));
        panelHaut.setLayout(new GridLayout(1,2)); //1 ligne et 2 colonnes
        
        JLabel labelBlanc = new JLabel("");
        labelBlanc.setHorizontalAlignment(SwingConstants.CENTER);       
        
        retourMenu = new JButton("Menu");
        retourMenu.setPreferredSize(new Dimension(20,10));
        retourMenu.addActionListener(controlProf);
        
        panelHaut.add(labelBlanc);
        panelHaut.add(retourMenu); 
        
        //Partie Liste des Exercices avec affichage de la JTable!
        listeEx = new JPanel();
        listeEx.setLayout(new BorderLayout());
        listeEx.setPreferredSize(new Dimension(600,500));
        listedesExos = new JLabel("Liste des exercices : Sélectionnez un Exercice");
        
        modifierEx = new JButton("Modifier cet exercice");
        modifierEx.setEnabled(false);   
        modifierEx.addActionListener(controlProf);
        
        maJTable = new ViewTableExercices(this);
                        
        listeEx.add(listedesExos,BorderLayout.NORTH);
        listeEx.add(modifierEx,BorderLayout.EAST);
        listeEx.add(maJTable,BorderLayout.NORTH);
        
        //Assemblage final des deux panels à droite:
        panelDroite = new JPanel();
        panelDroite.setLayout(new BorderLayout());
        panelDroite.add(panelHaut,BorderLayout.NORTH);
        panelDroite.add(listeEx,BorderLayout.SOUTH);
        
        this.setLayout(new BorderLayout());
        this.add(panelDroite,BorderLayout.CENTER);
        this.setVisible(true);
    }   
    
    
    /*
    * Cette fonction  permet de récupérer l'exercice sélectionné dans la JTable
    *@param ListeExercicesProf : interface listexo
    *@param node : exercice sélectionné
    */
    public void afficheInfo(ListeExercicesProf this,Exercice node) {
	if (node instanceof Exercice) {
            currentExercice = node;
            update();
	}
    }
    /*
    * Cette fonction permet d'activer le button Modifier Exercice
    * quand on a sélectionné un exercice 
    */
    public void update(){
        if (currentExercice != null){
            modifierEx.setEnabled(true);
        }
    }   
       
    
    /*
    *@getters pour les panels
    * utilisés dans le action listener dans controllerMenuProfesseur
    */
    public JPanel getPanelHaut() {
        return panelHaut;
    }
    public JPanel getListeEx() {
        return listeEx;
    } 
    public JPanel getPanelDroite() {
        return panelDroite;
    }
    public ModifExerciceProf getPanmodif() {
        return panmodif;
    }
    
    
    //getters pour les Buttons
    public JButton getRetourMenu() {
        return retourMenu;
    }
    public JButton getModifierEx() {
        return modifierEx;
    }  
    
}