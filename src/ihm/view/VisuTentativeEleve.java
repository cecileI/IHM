package ihm.view;

import ihm.controler.*;
import ihm.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


/**
 * This Interface allows us to visualize with a table the statut of all tentatives of the exercices did by a student.
 * @author Group 7
 */
public class VisuTentativeEleve extends JPanel{
    private JLabel lblNomEleve,lblPrenomEleve,lblClasseEleve;
    
    private JButton retourMenu; // va renvoyer sur MenuEleve
    private JPanel entete; // contient petite entete + num exo + bouton retourMenu + nom, prenom, classe
    private JPanel general;
    private ArrayList<Tentative> tentative;
    private ViewVisuTentativeEleve maJTable;
    private MenuEleve menuEleve;
    private Eleve eleve;
    
    private JLabel imageTortue;
    private JLabel imageCahier;
    private JPanel petiteEntete;
    private JPanel imageEntete;
    private JPanel texteEntete;
    
    /*
    * Constructeur de la classe VisuTentativeEleve
    * @param Eleve est l'élève courant
    */
    public VisuTentativeEleve(Eleve eleve) {
        this.eleve=eleve;          
        this.setLayout(new BorderLayout()); 
        this.setPreferredSize(new Dimension(500,500));
        ControllerTentativeAction controlTentAct = new ControllerTentativeAction(this);
        entete=new JPanel();
        imageEntete = new JPanel();
        texteEntete = new JPanel();
        texteEntete.setLayout(new GridLayout(3,2)); 
        
        imageTortue = new JLabel();
        imageTortue.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/tortue.png")));
        imageTortue.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel blanc = new JLabel("");
        JLabel blanc2 = new JLabel("");
        
        lblNomEleve = new JLabel(eleve.getNomEleve() + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        
        lblPrenomEleve = new JLabel(eleve.getPrenomEleve());
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        
        lblClasseEleve = new JLabel(eleve.getNiveau().toString());
        lblClasseEleve.setFont(new Font("Arial",Font.BOLD,15));
        
        
        imageEntete.add(imageTortue);
        texteEntete.add(lblNomEleve);
        texteEntete.add(lblPrenomEleve);
        texteEntete.add(blanc);
        texteEntete.add(blanc2);
        texteEntete.add(lblClasseEleve);
        
        petiteEntete = new JPanel();
        petiteEntete.add(imageEntete,BorderLayout.WEST);
        petiteEntete.add(texteEntete,BorderLayout.EAST);
        
        //partie entete
        entete = new JPanel();
        entete.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 0));         
        
        imageCahier = new JLabel();
        imageCahier.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/cahier.png")));
        imageCahier.setHorizontalAlignment(SwingConstants.CENTER);
        //Bouton Menu
        retourMenu= new JButton("Menu");
        retourMenu.setPreferredSize(new Dimension(150,50));   
        retourMenu.addActionListener(controlTentAct); 
        entete.add(petiteEntete);
        entete.add(retourMenu);
        this.maJTable = new ViewVisuTentativeEleve(menuEleve,eleve);
        
        general = new JPanel();
        general.setLayout(new BorderLayout());
        general.add(entete, BorderLayout.NORTH);
        general.add(maJTable, BorderLayout.CENTER);
        general.add(imageCahier, BorderLayout.SOUTH);
        
        this.setLayout(new BorderLayout());
        this.add(general, BorderLayout.CENTER);
        this.setVisible(true);
        
}    
    public JButton getRetourMenu() {
        return retourMenu;
    }
    
    public Eleve getCurrentEleve() {
        return eleve;
    }
    
    public JPanel getGeneral(){
        return general;
    }
}
