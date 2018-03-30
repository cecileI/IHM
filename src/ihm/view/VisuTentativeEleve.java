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
 *
 * @author Cécile
 */
public class VisuTentativeEleve extends JPanel{
    private JLabel lblNomEleve,lblPrenomEleve,lblClasseEleve,numeroExercice;
    
    private JButton retourMenu; // va renvoyer sur MenuEleve
    private JPanel entete; // contient petite entete + num exo + bouton retourMenu + nom, prenom, classe
    private ArrayList<Tentative> tentative;
    private ViewVisuTentativeEleve maJTable;
    private MenuEleve menuEleve;
    private Eleve eleve;
    private controllerTentative controlTent;
    
    private JLabel imageTortue;
    private JLabel imageCahier;
    private JPanel petiteEntete;
    private JPanel imageEntete;
    private JPanel texteEntete;
    
    public VisuTentativeEleve(Eleve eleve,String titreExercice) {
                  
        this.setLayout(new BorderLayout()); 
        this.setPreferredSize(new Dimension(500,500));
       // controlTent = new controllerTentative(maJTable,tentative ,menuEleve);
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
        
        numeroExercice = new JLabel(titreExercice);
        numeroExercice.setHorizontalAlignment(SwingConstants.CENTER);
        numeroExercice.setFont(new Font("Arial",Font.BOLD,20));
         
        
        imageCahier = new JLabel();
        imageCahier.setIcon(new ImageIcon(InterfaceDebut.class.getResource("/images/cahier.png")));
        imageCahier.setHorizontalAlignment(SwingConstants.CENTER);
        //Bouton Menu
        retourMenu= new JButton("Menu");
        retourMenu.setPreferredSize(new Dimension(150,50));   
       // retourMenu.addActionListener(controlTent); 
        entete.add(petiteEntete);
        entete.add(numeroExercice);
        entete.add(retourMenu);
        this.maJTable = new ViewVisuTentativeEleve(menuEleve,eleve);
        
        this.setLayout(new BorderLayout());
        this.add(entete, BorderLayout.NORTH);
        this.add(maJTable, BorderLayout.CENTER);
        this.add(imageCahier, BorderLayout.SOUTH);

        this.setVisible(true);
        
}    
    public JButton getMenu() {
        return retourMenu;
    }
    
        public Eleve getCurrentEleve() {
        return eleve;
    }
}
