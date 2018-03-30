package ihm.view;

import ihm.controler.controllerTentativeEleve;
import ihm.model.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
    private JPanel imageEntete;
    private JPanel texteEntete;
    private JLabel imageTortue;
    private JPanel directionPanel;
    private JPanel directionPaneNord;

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

    private JPanel general;
    
    private Eleve currentEleve;
    private Exercice currentExercice;
    
    private Canvas myCanvas;
    
    private JScrollPane listScroller;
    private ArrayList<String> scriptTentative; //suite des boutons sur lesquels l'élève à cliquer
    
    
    private controllerTentativeEleve controlTentEl;
           
    public TentativeEleve(Eleve currentEleve, Exercice currentExercice){
        
        this.setLayout(new BorderLayout());
        this.setSize(750,500);  //largeur, hauteur
        
        this.currentExercice = currentExercice;
        this.currentEleve = currentEleve;
        
        controlTentEl = new controllerTentativeEleve(this);
        
        scriptTentative = new ArrayList<String>();
        //------------------------------------
        // Partie entete 
        //------------------------------------

        //Bouton Menu
        menu = new JButton("Menu");
        menu.setPreferredSize(new Dimension(150,50));   
        menu.addActionListener(controlTentEl); 
        
        
        
        imageEntete = new JPanel();
        texteEntete = new JPanel();
        texteEntete.setLayout(new GridLayout(3,2));
        imageTortue = new JLabel();
        imageTortue.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue.png")));
        imageTortue.setHorizontalAlignment(SwingConstants.CENTER);
        
        //infos élève
        lblNomEleve = new JLabel(currentEleve.getNomEleve() + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblPrenomEleve = new JLabel(currentEleve.getPrenomEleve());
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblClasseEleve = new JLabel(currentEleve.getNiveau().getNiveau());
        lblClasseEleve.setFont(new Font("Arial",Font.BOLD,15));
        JLabel blanc = new JLabel("");
        JLabel blanc2 = new JLabel("");
        petiteEntete = new JPanel();
        petiteEntete.add(imageEntete,BorderLayout.WEST);
        petiteEntete.add(texteEntete,BorderLayout.EAST);     
        texteEntete.add(lblNomEleve);
        texteEntete.add(lblPrenomEleve);
        texteEntete.add(blanc);
        texteEntete.add(blanc2);
        texteEntete.add(lblClasseEleve);
        imageEntete.add(imageTortue);
        
        
        entete = new JPanel();
        entete.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 3));
        entete.add(petiteEntete);
        entete.add(menu);
        
//---------------------------------------------------------
//               Partie Faire une tentative
//---------------------------------------------------------
        //modèle du professeur
        //pas encore effectif
        JLabel modele = new JLabel("Le modele");
        
        //lignes de code produites par l'élève
        lignesCode = new JTextArea("Tu peux trouver toutes tes \nactions ici : \n");
        lignesCode.setFont(new Font("Arial",Font.BOLD,12));
        lignesCode.setEditable(false); //on ne peut pas ecrire dedans
        lignesCode.setLineWrap(true); //revient à la ligne
        listScroller = new JScrollPane(lignesCode); //scrollpane contenant le jtextarea des lignes de codes
        listScroller.setPreferredSize(new Dimension(250, 80));
        listScroller.setMinimumSize(new Dimension(250, 80));
        listScroller.setAlignmentX(LEFT_ALIGNMENT);
        
        //panel de gauche avec le modele du prof et les lignes de code produites par l'élève
        tentative = new JPanel();
        tentative.setPreferredSize(new Dimension(200,100));
        tentative.setLayout(new GridLayout(2,1));
        
        tentative.add(modele);
        tentative.add(listScroller);
        
        //Grand panel Boutons à droite
        couleurs = new JPanel();
        couleurs.setLayout(new GridLayout(3,2));
        black = new JButton();
            black.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue_noire.png")));
            black.setContentAreaFilled(false);
        red = new JButton();
            red.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue_rouge.png")));
            red.setContentAreaFilled(false);
        blue = new JButton();
            blue.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue_bleue.png")));
            blue.setContentAreaFilled(false);
        green = new JButton();
            green.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue_verte.png")));
            green.setContentAreaFilled(false);
        yellow = new JButton();
            yellow.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue_jaune.png")));
            yellow.setContentAreaFilled(false);
        magenta = new JButton();
            magenta.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue_magenta.png")));
            magenta.setContentAreaFilled(false);
        
//        validEleve.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/valider.png")));
//        validEleve.setEnabled(true);
//        validEleve.setBackground(Color.white);
//        validEleve.setHorizontalAlignment(SwingConstants.CENTER); 
//        validEleve.setOpaque(false);
//        validEleve.setContentAreaFilled(false);
//        validEleve.setBorderPainted(false);
        
        
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

        
        directionPanel   = new JPanel ();
        directionPaneNord   = new JPanel ();
        //directionPanel.setLayout(new GridLayout(2,1));
        
        
        executer = new JButton ("");
        executer.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue_valider.png")));
        executer.setEnabled(true);
        executer.setBackground(Color.white);
        executer.setHorizontalAlignment(SwingConstants.CENTER); 
        executer.setOpaque(false);
        executer.setContentAreaFilled(false);
        executer.setBorderPainted(false);
        executer.addActionListener(controlTentEl); 
        
        valider = new JButton ("");
        valider.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/valider.png")));
        valider.setEnabled(true);
        valider.setBackground(Color.white);
        valider.setHorizontalAlignment(SwingConstants.CENTER); 
        valider.setOpaque(false);
        valider.setContentAreaFilled(false);
        valider.setBorderPainted(false);
        valider.addActionListener(controlTentEl); 
        
       
        
        tourner = new JButton("");
        tourner.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tourne.png")));
        tourner.setEnabled(true);
        tourner.setBackground(Color.white);
        tourner.setHorizontalAlignment(SwingConstants.CENTER); 
        tourner.setOpaque(false);
        tourner.setContentAreaFilled(false);
        tourner.setBorderPainted(false);
        tourner.addActionListener(controlTentEl); 
        
        avancer = new JButton("");
        avancer.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/fleche.png")));
        avancer.setEnabled(true);
        avancer.setBackground(Color.white);
        avancer.setHorizontalAlignment(SwingConstants.CENTER); 
        avancer.setOpaque(false);
        avancer.setContentAreaFilled(false);
        avancer.setBorderPainted(false);
        avancer.addActionListener(controlTentEl); 
        
        ecrire = new JButton("");
        ecrire.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/crayon.png")));
        ecrire.setEnabled(true);
        ecrire.setBackground(Color.white);
        ecrire.setHorizontalAlignment(SwingConstants.CENTER); 
        ecrire.setOpaque(false);
        ecrire.setContentAreaFilled(false);
        ecrire.setBorderPainted(false);
        ecrire.addActionListener(controlTentEl); 
        directionPaneNord.add(avancer);
        directionPanel.add(tourner,BorderLayout.WEST);
        directionPanel.add(ecrire,BorderLayout.EAST); 
        
        
        grandPanelBoutons = new JPanel();
        grandPanelBoutons.setLayout(new GridLayout(3,1));//4llignes 1 colonne
        grandPanelBoutons.add(couleurs);
        
        //panelBasBoutons = new JPanel();
        //panelBasBoutons.setLayout(new GridLayout(2,1));
        grandPanelBoutons.add(directionPaneNord);
        grandPanelBoutons.add(directionPanel);
        
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

        

        
        petitPanelBoutons = new JPanel();
        petitPanelBoutons.setLayout(new FlowLayout(FlowLayout.CENTER, 200, 3)); 
        petitPanelBoutons.add(executer);
        petitPanelBoutons.add(valider);
        panelBoutons = new JPanel();
        //panelBoutons.setLayout(new GridLayout(2,1));
        panelBoutons.add(petitPanelBoutons);
        //panelBoutons.add(ecrire);
        

        

        //tentative.add(modele);
        //tentative.add(canv);
        //tentative.add(grandPanelBoutons);
        
        //tentative.add(lignesCode);
        //tentative.add(panelBoutons);
        //tentative.add(panelBasBoutons);
        
        general = new JPanel();
        general.setLayout(new BorderLayout());
        
        general.add(tentative, BorderLayout.WEST);
        general.add(canv, BorderLayout.CENTER);
        general.add(panelBoutons, BorderLayout.SOUTH);
        general.add(grandPanelBoutons, BorderLayout.EAST);
        general.add(entete, BorderLayout.NORTH);
        
        this.add(general);
        
        this.setVisible(true); 

    }

    public String getModeTortue() {
        return modeTortue;
    }

    public Eleve getCurrentEleve() {
        return currentEleve;
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

    public JPanel getGeneral() {
        return general;
    }

    public JTextArea getLignesCode() {
        return lignesCode;
    }

    public ArrayList<String> getScriptTentative() {
        return scriptTentative;
    }

    public JScrollPane getListScroller() {
        return listScroller;
    }

    public Exercice getCurrentExercice() {
        return currentExercice;
    }
    
    
    
            
}
