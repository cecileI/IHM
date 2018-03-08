package ihm.view;

import ihm.controler.*;
import ihm.model.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Group7
 */
public class InterfaceDebut extends JFrame {
    
    private JPanel panelGeneral;
    private JPanel panelEleve;
    private JPanel panelProf;
    
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

    
    public InterfaceDebut(){
        
        this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("LOGO Groupe 7");
        this.setSize(750,500);
        
        message = new JLabel("");
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setFont(new Font("Arial",Font.BOLD,20));
        
        //Partie eleve
        panelEleve = new JPanel();
        panelEleve.setLayout(new GridLayout(5,1)); //5lignes et 1 colonne
        
        unEleve = new JLabel("Un elève");
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
        
        validEleve = new JButton("Valider");
        validEleve.setHorizontalAlignment(SwingConstants.CENTER);
        panelEleve.add(validEleve);
        validEleve.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees de l'eleve
                    String prenomE = prenomEleve.getText();
                    String nomE = nomEleve.getText();
                    String classe = classeEleve.getText();
                    if (connexionEleve(prenomE, nomE, classe)==true){
                        View view = new View();
                        view.createTree();
                        //ferme la fenetre de connexion
                        dispose();
                    }else{
                        message.setText("Connexion refusée");
                    }
                }
            }); 
        

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
        nomProf.setPreferredSize( new Dimension( 100, 50 ) );
        panelProf.add(nomProf);
        
        motDePasse = new JTextField("1234");
        motDePasse.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(motDePasse);
        
        validProf = new JButton("Valider");
        validProf.setHorizontalAlignment(SwingConstants.CENTER);
        panelProf.add(validProf);
        validProf.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    //recupere les donnees du prof 
                    String prenomP = prenomProf.getText();
                    String nomP = nomProf.getText();
                    String mdp = motDePasse.getText();
                    if (connexionProf(prenomP, nomP, mdp)==true){
                        
                        View view = new View();
                        view.createTree();
                        //ferme la fenetre de connexion
                        dispose();
                        
                    }else{
                        message.setText("Connexion refusée");
                    }
                }
            }); 
        
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
        
        
        this.add(jeSuis, BorderLayout.NORTH);
        this.add(panelGeneral);
        this.add(message, BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
    }
    
    /*
    * Fonction de connexion pour un professeur
    * @param prenomP : le prénom du professeur qu'il aura rentré
    * @param nomP : le nom du professeur qu'il aura rentré
    * @param mdp : le mot de passe qu'il aura rentré
    * @return boolean : si les identifiants du professeur sont corrects -> true
    */
    public boolean connexionProf (String prenomP, String nomP, String mdp){
        ArrayList<Professeur> listProf = new ArrayList<Professeur>();
        listProf = InfoBDD.selectionListProfesseur(); //recupere la liste des professeurs
        
        for (Professeur prof : listProf) {
            if (prof.getNomProf().equals(nomP)) {
                if(prof.getPrenomProf().equals(prenomP)){
                    if(prof.getMdpProf().equals(mdp)){
                        return(true);
                    }
                }        
                 
            }
        }
        return(false);
    }
    
    /*
    * Fonction de connexion pour un élève
    * @param prenom P : le prénom du professeur qu'il aura rentré
    * @param
    */
    public boolean connexionEleve (String prenomE, String nomE, String classe){
        ArrayList<Eleve> listEleve = new ArrayList<Eleve>();
        listEleve = InfoBDD.selectionListEleve(); //recupere la liste des élèves
        
        for (Eleve eleve : listEleve){
            if ((eleve.getNomEleve().equals(nomE)) && (eleve.getPrenomEleve().equals(prenomE)) && (eleve.getClasse().getNiveau().equals(classe))){
                return(true);
            }
        }
        return(false);
    }
    
    
}


