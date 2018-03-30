package ihm.view;
import ihm.controler.*;
import ihm.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 * La Classe InterfaceDebut de type JFrame permet de lancer la première fenêtre de l'application
 * Cette JFrame permet de se connecter sur l'application en tant qu'élève ou professeur
 * @author Group7
 */
public class InterfaceDebut extends JFrame {
    
    private JPanel panelGeneral;
    private JPanel panelEleve;
    private JPanel panelProf;
    private JPanel panelGlobal;
    
    private JLabel jeSuis;
    private JLabel message;
    private JLabel imageProf;
    private JLabel imageEleve;
    
    private JLabel unEleve;
    private JTextField prenomEleve;
    private JTextField nomEleve;
    private JTextField classeEleve;
    
    private JLabel unProfesseur;
    private JTextField prenomProf;
    private JTextField nomProf;
    private JTextField motDePasse;
    
    private JButton validEleve;
    private JButton validProf;

    
    public InterfaceDebut(){
        
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("LOGO Groupe 7"); //Titre de la JFrame 
        this.setSize(900,600);          //largeur, hauteur
        this.setResizable(false);       //impossible de changer la taille de la JFrame
        //pour instancier le controllerInterfaceDebut et appeler les ActionEvent en cliquant sur les boutons
        controllerInterfaceDebut controlinterf = new controllerInterfaceDebut(this);

        //Partie ELEVE, à gauche
        panelEleve = new JPanel();
        panelEleve.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 3)); 
        
        unEleve = new JLabel("Un élève");
        unEleve.setHorizontalAlignment(SwingConstants.CENTER);
        unEleve.setFont(new Font("Arial",Font.BOLD,30));
        panelEleve.add(unEleve);
        
        imageEleve = new JLabel();
        imageEleve.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/eleve.png")));
        imageEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(imageEleve);
        
        prenomEleve = new JTextField("Xavier");
        prenomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        prenomEleve.setFont(new Font("Arial",Font.PLAIN,20));
        prenomEleve.setPreferredSize( new Dimension( 100, 50 ) );
        panelEleve.add(prenomEleve);
        
        nomEleve = new JTextField("Poalon");
        nomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        nomEleve.setFont(new Font("Arial",Font.PLAIN,20));
        nomEleve.setPreferredSize( new Dimension( 100, 50 ) );
        panelEleve.add(nomEleve);
        
        classeEleve = new JTextField("CE1");
        classeEleve.setHorizontalAlignment(SwingConstants.CENTER);
        classeEleve.setFont(new Font("Arial",Font.PLAIN,20));
        classeEleve.setPreferredSize( new Dimension( 100, 50 ) );
        panelEleve.add(classeEleve);
        
        validEleve = new JButton();
        validEleve.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/valider.png")));
        validEleve.setEnabled(true);
        validEleve.setBackground(Color.white);
        validEleve.setHorizontalAlignment(SwingConstants.CENTER); 
        validEleve.setOpaque(false);
        validEleve.setContentAreaFilled(false);
        validEleve.setBorderPainted(false);
        panelEleve.add(validEleve);
        validEleve.addActionListener(controlinterf); 
        

        //Partie PROFESSEUR, à droite
        panelProf = new JPanel();
        panelProf.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 3));  
        unProfesseur = new JLabel("Un professeur");
        unProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
        unProfesseur.setFont(new Font("Arial",Font.BOLD,30));
        panelProf.add(unProfesseur);        
        
        imageProf = new JLabel();
        imageProf.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/prof.png")));
        imageProf.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(imageProf);
        
        prenomProf = new JTextField("Charles");
        prenomProf.setHorizontalAlignment(SwingConstants.CENTER);
        prenomProf.setFont(new Font("Arial",Font.PLAIN,20));
        prenomProf.setPreferredSize( new Dimension( 100, 50 ) );
        panelProf.add(prenomProf);
        
        nomProf = new JTextField("Abot");
        nomProf.setHorizontalAlignment(SwingConstants.CENTER);
        nomProf.setFont(new Font("Arial",Font.PLAIN,20));
        nomProf.setPreferredSize( new Dimension( 100, 50 ) );
        panelProf.add(nomProf);
        
        motDePasse = new JTextField("1234");
        motDePasse.setHorizontalAlignment(SwingConstants.CENTER);
        motDePasse.setFont(new Font("Arial",Font.PLAIN,20));
        motDePasse.setPreferredSize( new Dimension( 100, 50 ) );
        panelProf.add(motDePasse);
        
        validProf = new JButton();
        validProf.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/valider.png")));
        validProf.setEnabled(true);
        validProf.setBackground(Color.white);
        validProf.setHorizontalAlignment(SwingConstants.CENTER);
        validProf.setOpaque(false);
        validProf.setContentAreaFilled(false);
        validProf.setBorderPainted(false);
        panelProf.add(validProf);
        validProf.addActionListener(controlinterf); 
        
        //Partie générale: Haut et Elève/Professeur
        jeSuis = new JLabel("Je suis");
        jeSuis.setHorizontalAlignment(SwingConstants.CENTER);
        jeSuis.setFont(new Font("Arial",Font.BOLD,50));
        panelGeneral = new JPanel();
        panelGeneral.setLayout(new GridLayout(1,3));
        panelGeneral.add(panelEleve);
        JLabel labelBlanc = new JLabel("");
        panelGeneral.add(labelBlanc);
        panelGeneral.add(panelProf);
        
        panelGlobal = new JPanel();
        panelGlobal.setLayout(new BorderLayout());
        panelGlobal.setPreferredSize(new Dimension(750,500));
        panelGlobal.add(jeSuis, BorderLayout.NORTH);
        panelGlobal.add(panelGeneral, BorderLayout.CENTER);
        
        this.add(panelGlobal);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
 
    public void refresh(JPanel nouveauPanel){
        JFrame nouvFrame = this;
        panelGlobal.remove(jeSuis);
        panelGlobal.remove(panelGeneral);
        panelGlobal.add(nouveauPanel, BorderLayout.CENTER);
        nouvFrame.repaint(); 
        nouvFrame.validate();
        //return(nouvFrame);
    }
    
    //getters
    public JButton getvalidEleve(){
        return validEleve;
    }
    
    public JTextField getprenomEleve(){
        return prenomEleve;
    }
    
    public JTextField getnomEleve(){
        return nomEleve;
    }
    
    public JTextField getclasseEleve(){
        return classeEleve;
    }
    
    public JLabel getmessage(){
        return message;
    }

    public JButton getvalidProf(){
        return validProf;
    }
    
    public JTextField getprenomProf(){
        return prenomProf;
    }
    
    public JTextField getnomProf(){
        return nomProf;
    }
    
    public JTextField getmotDePasse(){
        return motDePasse;
    } 
}
