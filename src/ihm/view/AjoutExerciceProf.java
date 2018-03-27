package ihm.view;

import ihm.view.*;
import ihm.model.*;
import ihm.controler.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Interface pour permettre au Professeur de créer un Exercice
 * Les boutons sont: Valider, Menu, 
 * @author Diane
 */
public class AjoutExerciceProf extends JPanel {
    //panel final appelé par le controllerMenuProfesseur (tout sauf le JTree)
    private JPanel general;
    
    //entête avec Menu et Titre "Créer un Exercice"
    private JPanel panelHaut;
    private JLabel creerExercice;
    private JButton menu;
    
    
    //Pour la Création de l'exercice
    //Panel à gauche
    private JPanel gauche;
    private JTextField titre; 
    private JButton tRapide;
    private JButton tClassique;
    private JButton tCouleur;
    private JComboBox couleur;
    
    //panel central
    private JPanel centre;
    private JPanel canv;
    
    //panel à droite
    private JPanel droite;
    private JButton tourner;
    private JButton avancer;
    private JButton ecrire;
    private JButton executer;
    private JButton valider;
    
    //panel pour couleur    
    private JPanel couleurs;
    private JButton black;
    private JButton red;
    private JButton blue;
    private JButton green;
    private JButton yellow;
    private JButton magenta;

    //panel en bas
    private JPanel bas;
    private JTextArea ligneCode;   
    
    
    private String modeTortue;
    private TortueG currentTortue;
    
    //panel pour retourner au MenuProfesseur
    private MenuProfesseur panDroite;
    
    //private String modeTortue;
    //private TortueG currentTortue;
    private TortueCouleur currentTortueCoul;
    private Exercice currentExercice;
    
    
    private controllerAjoutExerciceProf controlexprof;
   
    public AjoutExerciceProf(){
        //pour instancier le controllerAjoutExerciceProf et appeler les ActionEvent en cliquant sur les boutons
        controllerAjoutExerciceProf controlProf = new controllerAjoutExerciceProf(this);   
        setLayout(new BorderLayout());        
        
        
//---------------------------------------------------------
//                      Entête: panelHaut
//---------------------------------------------------------
        panelHaut = new JPanel();
        panelHaut.setPreferredSize(new Dimension(600,50));
        panelHaut.setLayout(new GridLayout(1,2));
        
        //Boutton Menu
        creerExercice = new JLabel ("Création d'un Exercice");
        creerExercice.setFont(new Font("Arial",Font.BOLD,20));

        menu = new JButton("Menu");
        menu.setPreferredSize(new Dimension(20,10));   
        menu.addActionListener(controlexprof); //ne fonctionne pas!!! à revoir!
             
        panelHaut.add(creerExercice,BorderLayout.CENTER);
        panelHaut.add(menu);
        
//---------------------------------------------------------
//               Ajout d'un Exercice: panelGauche
//---------------------------------------------------------
        gauche = new JPanel();
        gauche.setPreferredSize(new Dimension(200,400));
        gauche.setLayout(new GridLayout(6,2)); //5 lignes, 1 colonne

        titre = new JTextField("Titre");      
    
        tRapide = new JButton ("Tortue Rapide");
        tRapide.addActionListener(controlexprof);
    
        tClassique = new JButton ("Tortue Classique");
        tClassique.addActionListener(controlexprof);
            
        tCouleur = new JButton ("Tortue Couleur");
        tCouleur.addActionListener(controlexprof);        
        
        couleur = new JComboBox();
		couleur.addItem("Rouge");                
		couleur.addItem("Bleu");
		couleur.addItem("Vert");
		couleur.addItem("Cyan");
		couleur.addItem("Orange");
		couleur.addItem("Jaune");
		couleur.addItem("Violet");
		couleur.addItem("Noir");
		couleur.addItem("Blanc");
        couleur.addActionListener(controlexprof);
        

//Ajout des Couleurs!
     
        red = new JButton("rouge");
        magenta = new JButton("magenta");
        yellow = new JButton("jaune");
        green = new JButton("vert");
        blue = new JButton("bleu");
        black = new JButton ("noir");
        
        black.setEnabled(false); //mise à dispo du choix de la couleur
        red.setEnabled(false);
        yellow.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        magenta.setEnabled(false);
        
        //récupération du type de la tortue pour cet exercice
//        modeTortue = currentExercice.getModeTortue();
//                
//        //creation de la tortue
//        if(modeTortue.equals("normal")){
//            currentTortue = new TortueG(); //creation d'une tortue classique
//            
//        }else if(modeTortue.equals("couleur")){
//            currentTortueCoul = new TortueCouleur(); //creation d'une tortue couleur
//            black.setEnabled(true); //mise à dispo du choix de la couleur
//            black.addActionListener(controlexprof);
//            red.setEnabled(true);
//            red.addActionListener(controlexprof);
//            yellow.setEnabled(true);
//            yellow.addActionListener(controlexprof);
//            blue.setEnabled(true);
//            blue.addActionListener(controlexprof);
//            green.setEnabled(true);
//            green.addActionListener(controlexprof);
//            magenta.setEnabled(true);
//            magenta.addActionListener(controlexprof);
//        }else if(modeTortue.equals("rapide")){
//            currentTortue = new TortueRapide(); //creation d'une tortue couleur
//        }
        
        gauche.add(titre);
        gauche.add(tRapide);
        gauche.add(tClassique);
        gauche.add(tCouleur);
        gauche.add(couleur);
        gauche.add(red);
        gauche.add(magenta);
        gauche.add(yellow);
        gauche.add(green);
        gauche.add(blue);
        gauche.add(black);
        
//---------------------------------------------------------
//               Ajout d'un Exercice: panelCentral
//--------------------------------------------------------- 
        centre = new JPanel();
        centre.setPreferredSize(new Dimension(300,400));
        centre.setLayout(new GridLayout(1,1)); //2 lignes, 1 colonne
       
        JPanel canv = Canvas.getCanvasPanel();  

        centre.add(canv);
        
//---------------------------------------------------------
//               Ajout d'un Exercice: panelDroite
//---------------------------------------------------------
        droite = new JPanel();
        droite.setPreferredSize(new Dimension(100,400));
        droite.setLayout(new GridLayout(5,1)); //5 lignes, 1 colonne
        
        tourner = new JButton ("Tourner");
        tourner.addActionListener(controlexprof);
        
        avancer = new JButton ("Avancer");
        avancer.addActionListener(controlexprof);
    
        ecrire = new JButton ("Ecrire");
        ecrire.addActionListener(controlexprof);
    
        executer = new JButton ("Executer");
        executer.addActionListener(controlexprof);
                
        valider = new JButton ("VALIDER");
        valider.addActionListener(controlexprof);

        droite.add(tourner);
        droite.add(avancer);
        droite.add(ecrire);
        droite.add(executer);
        droite.add(valider);
        
        

//---------------------------------------------------------
//               Ajout d'un Exercice: panelBas
//---------------------------------------------------------
        bas = new JPanel();
        bas.setPreferredSize(new Dimension(400,100));
        bas.setLayout(new GridLayout(1,1)); //1 ligne, 1 colonne
        
        //lignes de code produites par l'élève
        ligneCode = new JTextArea();              
        
        bas.add(ligneCode);        
//---------------------------------------------------------
//               Assemblage final de tous les panels
//---------------------------------------------------------    
                            
        add(panelHaut,BorderLayout.NORTH);
        add(gauche,BorderLayout.WEST);
        add(centre,BorderLayout.CENTER);
        add(droite,BorderLayout.EAST);
  
        add(bas,BorderLayout.SOUTH);
        
        this.setVisible(true); 

        
        
    }    

    //getters pout les panels

    public JPanel getPanelHaut() {
        return panelHaut;
    }
    public JPanel getGauche() {
        return gauche;
    }
    public JPanel getCentre() {
        return centre;
    }
    public JPanel getDroite() {
        return droite;
    }
    public JPanel getBas() {
        return bas;
    }
    public JPanel getCanv() {
        return canv;
    }    
    public JPanel getGeneral() {
        return general;
    }
    public JPanel getPanDroite() {
        return panDroite;
    }
    
    //getters pour les buttons

    public JButton getMenu() {
        return menu;
    }
    public JTextField getTitre() {
        return titre;
    }
    public JButton gettRapide() {
        return tRapide;
    }
    public JButton gettClassique() {
        return tClassique;
    }
    public JButton gettCouleur() {
        return tCouleur;
    }
    public JComboBox getCouleur() {
        return couleur;
    }
    public JButton getValider() {
        return valider;
    }
    public JButton getTourner() {
        return tourner;
    }
    public JButton getAvancer() {
        return avancer;
    }
    public JButton getEcrire() {
        return ecrire;
    }
    public JButton getExecuter() {
        return executer;
    }
    public JTextArea getLigneCode() {
        return ligneCode;
    }
    
    
    //concerne la tortue
    
    public TortueG getTortue(){
        return currentTortue;
    }
    
     public String getModeTortue() {
        return modeTortue;
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
