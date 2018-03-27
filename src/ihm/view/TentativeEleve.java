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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
public class TentativeEleve extends JPanel{
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
    private JPanel couleurs;
    private JButton black;
    private JButton red;
    private JButton blue;
    private JButton green;
    private JButton yellow;
    private JButton magenta;
    
    private JButton valider;
    private JButton executer;
    
    private String modeTortue;
    private TortueG currentTortue;
    private TortueCouleur currentTortueCoul;

    private Canvas myCanvas;
   
    
    private controllerTentativeEleve controlTentEl;
           
    public TentativeEleve(Eleve currentEleve, Exercice currentExercice){
        
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
        lblNomEleve = new JLabel(currentEleve.getNomEleve() + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblPrenomEleve = new JLabel(currentEleve.getPrenomEleve());
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblClasseEleve = new JLabel(currentEleve.getNiveau().getNiveau());
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
        //pas encore effectif
        JLabel modele = new JLabel("Le modele");
        
        //lignes de code produites par l'élève
        lignesCode = new JTextArea();
        
        //panel de gauche avec le modele du prof et les lignes de code produites par l'élève
        tentative = new JPanel();
        tentative.setPreferredSize(new Dimension(200,100));
        tentative.setLayout(new GridLayout(2,1));
        
        tentative.add(modele);
        tentative.add(lignesCode);
        
        //Grand panel Boutons à droite
        
        couleurs = new JPanel();
        couleurs.setLayout(new GridLayout(3,2));
        black = new JButton("noir");
        red = new JButton("rouge");
        blue = new JButton("bleu");
        green = new JButton("vert");
        yellow = new JButton("jaune");
        magenta = new JButton("magenta");
        
        couleurs.add(black);
        couleurs.add(red);
        couleurs.add(blue);
        couleurs.add(green);
        couleurs.add(yellow);
        couleurs.add(magenta);
        
        black.setEnabled(false); //mise à dispo du choix de la couleur
        red.setEnabled(false);
        yellow.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        magenta.setEnabled(false);

        executer = new JButton ("Executer");
        executer.addActionListener(controlTentEl); 
        
        valider = new JButton ("Valider");
        valider.addActionListener(controlTentEl); 
        
       
        grandPanelBoutons = new JPanel();
        grandPanelBoutons.setLayout(new GridLayout(3,1));//4llignes 1 colonne
        grandPanelBoutons.add(couleurs);
        
        //panelBasBoutons = new JPanel();
        //panelBasBoutons.setLayout(new GridLayout(2,1));
        grandPanelBoutons.add(executer);
        grandPanelBoutons.add(valider);
        
        //visualisation directe de la tentative de l'élève  
        
        //récupération du type de la tortue pour cet exercice
        modeTortue = currentExercice.getModeTortue();
        //creation de la tortue
        if(modeTortue.equals("normal")){
            currentTortue = new TortueG(); //creation d'une tortue classique
            
        }else if(modeTortue.equals("couleur")){
            currentTortueCoul = new TortueCouleur(); //creation d'une tortue couleur
            black.setEnabled(true); //mise à dispo du choix de la couleur
            black.addActionListener(controlTentEl);
            red.setEnabled(true);
            red.addActionListener(controlTentEl);
            yellow.setEnabled(true);
            yellow.addActionListener(controlTentEl);
            blue.setEnabled(true);
            blue.addActionListener(controlTentEl);
            green.setEnabled(true);
            green.addActionListener(controlTentEl);
            magenta.setEnabled(true);
            magenta.addActionListener(controlTentEl);
        }else if(modeTortue.equals("rapide")){
            currentTortue = new TortueRapide(); //creation d'une tortue couleur
        }
        //création du canvas
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

    public String getModeTortue() {
        return modeTortue;
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

    public JButton getValider() {
        return valider;
    }

    public JButton getExecuter() {
        return executer;
    }

    public TortueG getTortue(){
        return currentTortue;
    }
    
    public TortueCouleur getTortueCoul(){
        return currentTortueCoul;
    }

    public JButton getBlack() {
        return black;
    }

    public JButton getRed() {
        return red;
    }

    public JButton getBlue() {
        return blue;
    }

    public JButton getGreen() {
        return green;
    }

    public JButton getYellow() {
        return yellow;
    }

    public JButton getMagenta() {
        return magenta;
    }
    

    
            
}
