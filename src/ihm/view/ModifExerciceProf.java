package ihm.view;

import ihm.controler.*;
import ihm.model.Canvas;
import ihm.model.TortueCouleur;
import ihm.model.TortueG;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * Crée le Panel permettant à un Professeur de Modifier un Exercice
 * @author Group 7
 */
public class ModifExerciceProf extends JPanel{
    //panel final appelé par le controllerListeExercice (tout sauf le JTree)
    private JPanel general;
    
    //entête avec Menu et Titre "Modifier un Exercice"
    private JPanel panelHaut;
    private JLabel creerExercice;
    private JButton menu;    
    
    //Pour la Modification de l'exercice
    //Panel à gauche
    private JPanel gauche;
    private JTextField titre; 
    private JButton tRapide;
    private JButton tClassique;
    private JButton tCouleur;
    //private JComboBox couleur; --> pas le temps de faire fonctionner la JComboBox correctement: JButtons à la place
    
    //panel central
    private JPanel centre;
    private JPanel canv; //panel central qui affiche la tortue
    
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
   
    //tortue
    private String modeTortue;
    private TortueG currentTortue;    
    private TortueCouleur currentTortueCoul;
    //private Exercice currentExercice;
    private Canvas myCanvas;    
    
    //controller avec Action Performed
    private controllerModifExerciceProf controlexprof;
    
    //panel pour retourner au MenuProfesseur
    private MenuProfesseur panDroite;
           
    public ModifExerciceProf(){
setLayout(new BorderLayout());
        
        //pour instancier le controllerModifExerciceProf et appeler les ActionEvent en cliquant sur les boutons
        controllerModifExerciceProf controlProf = new controllerModifExerciceProf(this);
        
//---------------------------------------------------------
//                      Entête: panelHaut
//---------------------------------------------------------
        panelHaut = new JPanel();
        panelHaut.setPreferredSize(new Dimension(600,50));
        panelHaut.setLayout(new GridLayout(1,2));
        
        //Boutton Menu
        creerExercice = new JLabel ("Modification de l'Exercice");
        creerExercice.setFont(new Font("Arial",Font.BOLD,20));

        menu = new JButton("Menu");
        menu.setPreferredSize(new Dimension(20,10));   
        menu.addActionListener(controlexprof); //ne fonctionne pas!!! à revoir!
             
        panelHaut.add(creerExercice,BorderLayout.CENTER);
        panelHaut.add(menu);
        
//---------------------------------------------------------
//               Modification d'un Exercice: panelGauche
//---------------------------------------------------------
        gauche = new JPanel();
        gauche.setPreferredSize(new Dimension(200,400));
        gauche.setLayout(new GridLayout(5,2)); //5 lignes, 2 colonnes

        titre = new JTextField("Titre");
    
        tRapide = new JButton ("Tortue Rapide");
        tRapide.addActionListener(controlexprof);
    
        tClassique = new JButton ("Tortue Classique");
        tClassique.addActionListener(controlexprof);
            
        tCouleur = new JButton ("Tortue Couleur");
        tCouleur.addActionListener(controlexprof);        
               

//Ajout des Buttons pour les Couleurs!

        red = new JButton("");
        red.setBackground(Color.RED);
        red.setIcon(new ImageIcon(AjoutExerciceProf.class.getResource("/images/rouge.JPG")));
        magenta = new JButton("");
        magenta.setBackground(Color.MAGENTA);
        magenta.setIcon(new ImageIcon(AjoutExerciceProf.class.getResource("/images/magenta.JPG")));
        yellow = new JButton("");
        yellow.setBackground(Color.YELLOW);
        yellow.setIcon(new ImageIcon(AjoutExerciceProf.class.getResource("/images/jaune.JPG")));
        green = new JButton("");
        green.setBackground(Color.GREEN);
        green.setIcon(new ImageIcon(AjoutExerciceProf.class.getResource("/images/vert.JPG")));
        blue = new JButton("");
        blue.setBackground(Color.BLUE);        
        blue.setIcon(new ImageIcon(AjoutExerciceProf.class.getResource("/images/bleu.JPG")));
        black = new JButton ("");
        black.setBackground(Color.BLACK);
        black.setIcon(new ImageIcon(AjoutExerciceProf.class.getResource("/images/noir.JPG")));
        
        black.setEnabled(false); //mise à dispo du choix de la couleur
        red.setEnabled(false);
        yellow.setEnabled(false);
        blue.setEnabled(false);
        green.setEnabled(false);
        magenta.setEnabled(false);
        
        //récupération du type de la tortue pour cet exercice
        //modeTortue = currentExercice.getModeTortue();
                
        //creation de la tortue
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
        gauche.add(red);
        gauche.add(magenta);
        gauche.add(yellow);
        gauche.add(green);
        gauche.add(blue);
        gauche.add(black);
        
//---------------------------------------------------------
//               Modification d'un Exercice: panelCentral
//--------------------------------------------------------- 
        centre = new JPanel();
        centre.setPreferredSize(new Dimension(300,400));
        centre.setLayout(new GridLayout(1,1)); //2 lignes, 1 colonne
       
        //Créé le panel qui affiche la tortue
        JPanel canv = Canvas.getCanvasPanel();  

        centre.add(canv);
        
//---------------------------------------------------------
//               Modification d'un Exercice: panelDroite
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
                
        valider = new JButton ("VALIDER MODIFICATION");
        valider.addActionListener(controlexprof);

        droite.add(tourner);
        droite.add(avancer);
        droite.add(ecrire);
        droite.add(executer);
        droite.add(valider);       

//---------------------------------------------------------
//               Modification d'un Exercice: panelBas
//---------------------------------------------------------
        bas = new JPanel();
        bas.setPreferredSize(new Dimension(400,100));
        bas.setLayout(new GridLayout(1,1)); //1 ligne, 1 colonne
        
        //lignes de code entrées par le professeur
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

    
    //getters pour les panels
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
    
    //getters pour les Buttons
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
    
    
    //getters concernant la tortue    
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
