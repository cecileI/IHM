/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.view;

import ihm.controler.controllerTentativeEleve;
import ihm.model.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
/**
 *
 * @author Clara
 */
public class TentativeEleve extends JFrame{
    //entete
    private JLabel lblNomEleve;
    private JLabel lblPrenomEleve;
    private JLabel lblClasseEleve;
    private JButton menu;
    private JPanel petiteEntete;
    private JPanel entete;
    
    //Tentative
    private JPanel tentative; //panel sous l'entete
    
    //private modele;
    private Canvas can;
    private JTextArea lignesCode;
    
    //petit panel de boutons
    private JPanel petitPanelBoutons;
    private JPanel panelBoutons;
    private JButton tourner;
    private JButton avancer;
    private JButton ecrire;
   
    //grand panel de boutons
    private JPanel grandPanelBoutons;
    private JPanel panelBasBoutons;
    private JButton tortueRapide;
    private JButton tortueClassique;
    private JButton tortueCouleur;
    private JComboBox couleurs;
    private JButton valider;
    private JButton executer;
    
    private TortueG tortueG;
    private TortueCouleur tortueCoul;
    private TortueRapide tortueRap;

    private Canvas myCanvas;
    
    private controllerTentativeEleve controlTentEl;
           
    public TentativeEleve(String nomE, String prenomE, String classeE){
        
        this.setLayout(new BorderLayout());
        this.setSize(750,500);  //largeur, hauteur
        
        controlTentEl = new controllerTentativeEleve(this);
        
        //------------------------------------
        // Partie entete 
        //------------------------------------

        //Bouton Menu
        menu = new JButton("Menu");
        menu.setPreferredSize(new Dimension(20,10));   
        menu.addActionListener(controlTentEl); 
        
        //infos élève
        lblNomEleve = new JLabel(nomE + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblPrenomEleve = new JLabel(prenomE);
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblClasseEleve = new JLabel(classeE);
        lblClasseEleve.setFont(new Font("Arial",Font.BOLD,15));
        
        petiteEntete = new JPanel();
        petiteEntete.setLayout(new GridLayout(3,1));        
        petiteEntete.add(lblNomEleve);
        petiteEntete.add(lblPrenomEleve);
        petiteEntete.add(lblClasseEleve);
        
        entete = new JPanel();
        entete.setLayout(new GridLayout(1,2));//1ligne 2 colonnes
        entete.add(petiteEntete);
        entete.add(menu);
        
//---------------------------------------------------------
//               Partie Faire une tentative
//---------------------------------------------------------
        //modèle du professeur
        JLabel modele = new JLabel("Le modele");
        
        //lignes de code produites par l'élève
        lignesCode = new JTextArea();
        
        tentative = new JPanel();
        tentative.setPreferredSize(new Dimension(200,100));
        tentative.setLayout(new GridLayout(2,1));
        
        tentative.add(modele);
        tentative.add(lignesCode);
        
        //visualisation directe de la tentative de l'élève      
        tortueG = new TortueG(); //creation d'une tortue classique
        JPanel canv = Canvas.getCanvasPanel();  

        
        //petit panel de boutons
        tourner = new JButton("Tourner");
        tourner.addActionListener(controlTentEl); 
        
        avancer = new JButton("Avancer");
        avancer.addActionListener(controlTentEl); 
        
        ecrire = new JButton("Ecrire");
        ecrire.addActionListener(controlTentEl); 
        
        
        petitPanelBoutons = new JPanel();
        petitPanelBoutons.setLayout(new GridLayout(1,2));
        petitPanelBoutons.add(tourner);
        petitPanelBoutons.add(avancer);
        panelBoutons = new JPanel();
        panelBoutons.setLayout(new GridLayout(2,1));
        panelBoutons.add(petitPanelBoutons);
        panelBoutons.add(ecrire);
        
 
        // Grand panel de boutons
        tortueRapide = new JButton ("Tortue Rapide");
        tortueRapide.addActionListener(controlTentEl); 
    
        tortueClassique = new JButton ("Tortue Classique");
        tortueClassique.addActionListener(controlTentEl); 
    
        tortueCouleur = new JButton ("Tortue Couleur");
        tortueCouleur.addActionListener(controlTentEl); 
        
        couleurs = new JComboBox();
		//Couleur.setFont(font);
		couleurs.addItem("black");
		couleurs.addItem("red");
		couleurs.addItem("blue");
		couleurs.addItem("green");
		couleurs.addItem("yellow");
		couleurs.addItem("magenta");

        executer = new JButton ("Executer");
        executer.addActionListener(controlTentEl); 
        
        valider = new JButton ("Valider");
        valider.addActionListener(controlTentEl); 
        
        
        
        grandPanelBoutons = new JPanel();
        grandPanelBoutons.setLayout(new GridLayout(6,1));//6llignes 1 colonne
        grandPanelBoutons.add(tortueRapide);
        grandPanelBoutons.add(tortueClassique);
        grandPanelBoutons.add(tortueCouleur);
        grandPanelBoutons.add(couleurs);
        
        //panelBasBoutons = new JPanel();
        //panelBasBoutons.setLayout(new GridLayout(2,1));
        grandPanelBoutons.add(executer);
        grandPanelBoutons.add(valider);

        //tentative.add(modele);
        //tentative.add(canv);
        //tentative.add(grandPanelBoutons);
        
        //tentative.add(lignesCode);
        //tentative.add(panelBoutons);
        //tentative.add(panelBasBoutons);
        
        this.add(tentative, BorderLayout.WEST);
        this.add(canv, BorderLayout.CENTER);
        this.add(panelBoutons, BorderLayout.SOUTH);
        this.add(grandPanelBoutons, BorderLayout.EAST);
        this.add(entete, BorderLayout.NORTH);
        
        
        this.setVisible(true); 

    }

    
    
    public JButton getMenu() {
        return menu;
    }

    public JButton getTourner() {
        return tourner;
    }

    public JButton getEcrire() {
        return ecrire;
    }
    
    public JButton getAvancer() {
        return avancer;
    }
    
    public JButton getTortueRapide() {
        return tortueRapide;
    }

    public JButton getTortueClassique() {
        return tortueClassique;
    }

    public JButton getTortueCouleur() {
        return tortueCouleur;
    }

    public JButton getValider() {
        return valider;
    }

    public JButton getExecuter() {
        return executer;
    }

    public TortueG getTortueG() {
        return tortueG;
    }

    public TortueCouleur getTortueCoul() {
        return tortueCoul;
    }

    public TortueRapide getTortueRap() {
        return tortueRap;
    }

    
    
    
    
}
