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
 *
 * @author Group7
 */
public class InterfaceDebut extends JFrame {
    
    private JPanel panelGeneral;
    private JPanel panelEleve;
    private JPanel panelProf;
    private JPanel panelGlobal;
    
    private JLabel jeSuis;
    private JLabel message;
    
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

    private static controllerInterfaceDebut controlInterf;
    public InterfaceDebut(){
        
        controlInterf = new controllerInterfaceDebut(this);
        
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("LOGO Groupe 7");
        this.setSize(750,500);
        
        //Partie eleve
        panelEleve = new JPanel();
        panelEleve.setLayout(new GridLayout(5,1)); //5lignes et 1 colonne
        
        unEleve = new JLabel("Un élève");
        unEleve.setHorizontalAlignment(SwingConstants.CENTER);
        unEleve.setFont(new Font("Arial",Font.BOLD,30));
        panelEleve.add(unEleve);
        
        prenomEleve = new JTextField("Xavier");
        prenomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        prenomEleve.setPreferredSize( new Dimension( 100, 50 ) );
        panelEleve.add(prenomEleve);
        
        nomEleve = new JTextField("Poalon");
        nomEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(nomEleve);
        
        classeEleve = new JTextField("CE1");
        classeEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(classeEleve);
        
        message = new JLabel();
        validEleve = new JButton("Valider");
        validEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(validEleve);
        validEleve.addActionListener(controlInterf); 
        

        //Partie prof
        panelProf = new JPanel();
        panelProf.setLayout(new GridLayout(5,1)); //5lignes et 1 colonne
        
        unProfesseur = new JLabel("Un professeur");
        unProfesseur.setHorizontalAlignment(SwingConstants.CENTER);
        unProfesseur.setFont(new Font("Arial",Font.BOLD,30));
        panelProf.add(unProfesseur);
        
        prenomProf = new JTextField("Charles");
        prenomProf.setHorizontalAlignment(SwingConstants.CENTER);
        prenomProf.setPreferredSize( new Dimension( 100, 50 ) );
        panelProf.add(prenomProf);
        
        nomProf = new JTextField("Abot");
        nomProf.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(nomProf);
        
        motDePasse = new JTextField("1234");
        motDePasse.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(motDePasse);
        
        validProf = new JButton("Valider");
        validProf.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(validProf);
        validProf.addActionListener(controlInterf); 
        
        //Partie générale
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


