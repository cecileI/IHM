package ihm.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Group7
 */
public class InterfaceEleve extends JFrame{
    
    private JLabel lblNomEleve;
    private JLabel lblPrenomEleve;
    private JLabel lblClasseEleve;
    private JLabel menu;
    
    private JButton deconnexion;
    
    private JTable mesExos;
    
    private JPanel entete;
    private JPanel petiteEntete;
    private JPanel exercices;
    private JPanel actionsExo;
    private JPanel panelGeneral;
    
    public InterfaceEleve (String nomEleve, String prenomEleve, String classeEleve){
        
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("LOGO Groupe 7");
        this.setSize(750,500);
        
        //Partie petite entete
        petiteEntete = new JPanel();
        petiteEntete.setLayout(new GridLayout(2,2)); //2lignes et 1 colonne
        
        lblNomEleve = new JLabel(nomEleve + "  ");
        lblNomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblPrenomEleve = new JLabel(prenomEleve);
        lblPrenomEleve.setFont(new Font("Arial",Font.BOLD,15));
        lblClasseEleve = new JLabel(classeEleve);
        lblClasseEleve.setFont(new Font("Arial",Font.BOLD,15));
        petiteEntete.add(lblNomEleve);
        petiteEntete.add(lblPrenomEleve);
        petiteEntete.add(lblClasseEleve);
        
        //partie entete
        entete = new JPanel();
        entete.setLayout(new BorderLayout());
        
        menu = new JLabel("MENU");
        menu.setHorizontalAlignment(SwingConstants.CENTER);
        menu.setFont(new Font("Arial",Font.BOLD,20));
        
        deconnexion = new JButton("Deconnexion");
        deconnexion.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //appel de linterface fin
                }
            });
        
        entete.add(petiteEntete, BorderLayout.WEST);
        entete.add(menu, BorderLayout.CENTER);
        entete.add(deconnexion, BorderLayout.EAST);
        
        //
        this.add(entete, BorderLayout.NORTH);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    
}
