package ihm.view;

import ihm.view.*;
import ihm.model.*;
import ihm.controler.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
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
 * @author group  7
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
    //private TortueG tortueG;    
    private TortueCouleur tortueCoul;
    private TortueRapide tortueRapide;
    private Canvas myCanvas;    
    
    //controller avec Action Performed
    private controllerAjoutExerciceProf controlexprof;
    
    //panel pour retourner au MenuProfesseur
    private MenuProfesseur panDroite;
   
    public AjoutExerciceProf(){ //Exercice currentExercice){
        setLayout(new BorderLayout());
        
        //pour instancier le controllerAjoutExerciceProf et appeler les ActionEvent en cliquant sur les boutons
        controllerAjoutExerciceProf controlexprof = new controllerAjoutExerciceProf(this);
        
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
        gauche.setLayout(new GridLayout(5,2)); //5 lignes, 2 colonnes

        titre = new JTextField("Titre");      
    
        tRapide = new JButton ("<HTML><BODY>Tortue<BR>Rapide</BODY></HTML>"); //pour faire retour à la ligne dans button
        tRapide.addActionListener(controlexprof);            
          
        tClassique = new JButton ("<HTML><BODY>Tortue<BR>Classique</BODY></HTML>");
        tClassique.addActionListener(controlexprof);
            
        tCouleur = new JButton ("<HTML><BODY>Tortue<BR>Couleur</BODY></HTML>");
        tCouleur.addActionListener(controlexprof);        
               

//Ajout des Bttons pour les Couleurs!

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
        
        black.addActionListener(controlexprof);
        red.addActionListener(controlexprof);
        yellow.addActionListener(controlexprof);
        blue.addActionListener(controlexprof);
        green.addActionListener(controlexprof);
        magenta.addActionListener(controlexprof);
        
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
//               Ajout d'un Exercice: panelCentral
//--------------------------------------------------------- 
        centre = new JPanel();
        centre.setPreferredSize(new Dimension(300,400));
        centre.setLayout(new GridLayout(1,1)); //2 lignes, 1 colonne

        //Créé le panel qui affiche la tortue        
        //canv = new JPanel();
        
        //centre.add(canv);
        
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
        
        //lignes de code entrées par le professeur
        ligneCode = new JTextArea();
        ligneCode.setBackground(Color.lightGray);
        
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
//    public TortueG getTortue(){
//        return tortueG;
//    }
    
     
     public String getModeTortue(){
        return modeTortue;
    }
    public TortueCouleur getTortueCoul() {
        return tortueCoul;
    }
    public TortueRapide getTortueRapide() {
        return tortueRapide;
    }

//    public TortueG getTortueG() {
//        return tortueG;
//    }


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
