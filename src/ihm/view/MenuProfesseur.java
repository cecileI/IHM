package ihm.view;

import ihm.view.*;
import ihm.controler.InfoBDD;
import ihm.controler.controllerJTree;
import ihm.controler.controllerMenuProfesseur;
import ihm.model.Classe;
import ihm.model.Eleve;
import ihm.model.Exercice;

import ihm.model.Tentative;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.accessibility.AccessibleContext;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 * Cette classe permet de créer un panel deuis l'InterfaceDebut permettant au Professeur d'accéder à son Menu
 * Cela permet au professeur de choisir entre Créer un Exercice ou Modifier un Exercice 
 * et donc d'ouvrir le panel correspondant
 * @author Goup7
 */
public class MenuProfesseur extends JPanel {
   
    //JPanel
    private JPanel panGeneral; //panel général qui regroupe toutes les informations du JPanel
    private JPanel panDroite; //panel à droite qui sera modifier par des nouveaux panel
    private JPanel panHaut; //panel de deconnection et panel blanc puis label prenom et nom élève
    private JPanel panExercice; //panel qui regroupe les boutons création et modification exercice
    
    //JButton
    private JButton creerExercice; //bouton création exercice
    private JButton modifierExercice; //bouton modification exercice
    private JButton deconnexion; //bouton deconnection
    
    //JTree
    private JPanel panTree; //panel à gauche Jtree
    private JLabel lblEleve;
    private JLabel txtNom, txtPrenom;
    private JTree tree;
    private DefaultMutableTreeNode racine;
    private Eleve currentEleve;
    private Classe currentClasse;
    private Tentative currentTentative;
    
    //panel pour Créer un exercice
    private AjoutExerciceProf panCreer;
    private Exercice currentExercice;
    
    //panel pour Modifier un exercice
    private ListeExercicesProf panliste;
           
    public MenuProfesseur(){
        //pour instancier le controllerMenuProfesseur et appeler les ActionEvent en cliquant sur les boutons
        controllerMenuProfesseur controlProf = new controllerMenuProfesseur(this);
        panliste = new ListeExercicesProf();
        panCreer = new AjoutExerciceProf(); //this.getCurrentExercice());
        
        //Partie JTree à gauche 
            racine = new DefaultMutableTreeNode("Classes"); // creation racine
            createTree();
            tree = new JTree(racine);  // creation arbre à partir de  racine
            tree.setShowsRootHandles(true);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            
            tree.addTreeSelectionListener(new controllerJTree(this.tree, this));
            
            panTree=new JPanel();
            panTree.add(tree);
            //panTree.setPreferredSize(new Dimension(140,450));

        //Boutton Deconnection
        deconnexion = new JButton("Deconnexion");
        deconnexion.setPreferredSize(new Dimension(150,50));
        deconnexion.addActionListener(controlProf);
        

        //Partie Exercice     
            //Bouton création exercice
        creerExercice = new JButton("Créer un Exercice");
        creerExercice.addActionListener(controlProf); 
        
            //Bouton modification exercice
        modifierExercice = new JButton("Modifier un Exercice");
        modifierExercice.addActionListener(controlProf);
        
        JLabel blanc0 = new JLabel("");
        blanc0.setHorizontalAlignment(SwingConstants.CENTER);
        
        //Panel de déconnexion qui sera modifier avec le panel du nom et du prenom de l'élève
        panHaut = new JPanel();
        panHaut.setPreferredSize(new Dimension(550,50));
        panHaut.setLayout(new BorderLayout(1,3));
        panHaut.add(blanc0, BorderLayout.CENTER);
        //panHaut.add(lblEleve);
        panHaut.add(deconnexion, BorderLayout.EAST);   //JPanel Deconnection  
        
            //Panel du nom et du prenom qui s'affiche quand on sélectionne un élève dans le JTree
            txtNom = new JLabel();
            txtNom.setText("Nom");
            txtNom.setPreferredSize(new Dimension(150,150));
            txtPrenom =new JLabel();
            txtPrenom.setText("Prenom");
            txtPrenom.setPreferredSize(new Dimension(150,150));
        
        //panExercice qui contient les boutons créer et modifier
        JLabel blanc1 = new JLabel("");
        blanc1.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc2 = new JLabel("");
        blanc2.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc3 = new JLabel("");
        blanc3.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc4 = new JLabel("");
        blanc4.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc5 = new JLabel("");
        blanc5.setHorizontalAlignment(SwingConstants.CENTER);
        JLabel blanc6 = new JLabel("");
        blanc6.setHorizontalAlignment(SwingConstants.CENTER);        
        
        panExercice = new JPanel();
        panExercice.setPreferredSize(new Dimension(550,500));
        panExercice.setLayout(new GridLayout(4,2));
        panExercice.add(blanc1);
        panExercice.add(blanc2);
        panExercice.add(creerExercice); //JButton créer exercice
        panExercice.add(modifierExercice); //JButton modifier exercice
        panExercice.add(blanc3);
        panExercice.add(blanc4);
        panExercice.add(blanc5);
        panExercice.add(blanc6);
        
        //panDroite qui contient panHaut et panExercice
        panDroite = new JPanel();
        panDroite.setPreferredSize(new Dimension(550,500));
        panDroite.add(panHaut);
        panDroite.add(panExercice);
        
        panGeneral = new JPanel();
        panGeneral.setLayout(new BorderLayout()); 
        panGeneral.add(panTree,BorderLayout.WEST);     //ajout du JTree au menu (à gauche)
        panGeneral.add(panDroite,BorderLayout.EAST);   //ajout du panel général au menu
        
        this.setLayout(new BorderLayout());
        this.add(panGeneral, BorderLayout.CENTER);        

        //this.getContentPane().setLayout(new BorderLayout()); 
                
        this.setVisible(true);        
    }    
    
    /*
    * Fonction de création de l'arbre 
    * Il est composé de classes et d'élèves
    */
    public void createTree(){
        //on parcourt toutes les classes
        for (Classe laclasse : InfoBDD.selectionListClasse()){ //liste de classe 
            //on crée de nouveaux noeuds
            DefaultMutableTreeNode nodeClasse = new DefaultMutableTreeNode(laclasse);
            //on parcourt tous les eleves de la classe
            for (Eleve leleve : InfoBDD.selectionListEleveClasse (laclasse)){
                //on crée de nouveaux noeuds
                DefaultMutableTreeNode nodeEleve = new DefaultMutableTreeNode(leleve); //.getNomEleve()
                
                //on ajoute les eleves à l'arbre
                nodeClasse.add(nodeEleve);
            }
            //on ajoute les classes à l'arbre
            racine.add(nodeClasse);
        } 
    }
    
    /*
    * Cette fonction est appelée apres avoir cliqué sur un élément dans le ViewJTree
    * La fenetre est mise a jour en fonction de l'élément choisi (Eleve ou Classe)
    * @param selected Node : l'élément choisi dans l'arbre
    */
    public void controllerJTreeCall(Object node){
        if (node instanceof Eleve) { //si l'élément choisi est un élève
            currentEleve = (Eleve)node; //l'élève courant est celui sélectionné
            //String currentNiveau =  currentEleve.getNiveau(); //la classe courante est celle de l'élève sélectionné
            currentClasse= currentEleve.getNiveau();
            update(); //mis à jour
            
        }else if(node instanceof Classe){ //si l'élément choisi est une classe
            currentEleve = null; //il n'y a pas d'élève courant
            currentClasse = (Classe)node; // la classe courante est celle sélectionnée
            update(); //mis à jour
            
        }else{
            System.out.println("Erreur");
        }
    }
    
    /*
    *Après avoir cliqué sur un élément (ex : dans le ViewJTree)
    *Fonction qui permet la mise a jour de l'interface
    */
    public void update(){
        
        if (currentEleve != null) {
           
            panHaut.remove(txtNom);
            panHaut.remove(txtPrenom);
            panExercice.remove(creerExercice);
            panExercice.remove(modifierExercice);
            
            txtNom.setText(currentEleve.getNomEleve()); // Nom de l'eleve
            txtPrenom.setText(currentEleve.getPrenomEleve()); //Prenom de l'eleve
            
            panHaut.add(txtNom, BorderLayout.WEST);
            panHaut.add(txtPrenom, BorderLayout.CENTER);
            panHaut.add(deconnexion, BorderLayout.EAST);   //JPanel Deconnection 
            VisuTableExEleveProf tableExEleveProf = new VisuTableExEleveProf(currentEleve);
            panExercice.add(tableExEleveProf);
            this.repaint();
            this.validate();
            
        }else{
            System.out.print("Erreur");
        }
    }
    
    public void afficheInfoTentativeProf(MenuProfesseur this,Tentative node) {
	if (node instanceof Tentative) {
            currentTentative = node;
            update();
	}
    }
    
    public JButton getDeconnexion(){
        return deconnexion;
    }    
    public JButton getcreerExercice(){
        return creerExercice;
    }
    public JButton getmodifierExercice(){
        return modifierExercice;
    }
    
    public JPanel getpanDroite(){
        return panDroite;
    }
    
    public JPanel getpanGeneral(){
        return panGeneral;
    }
    
    public JPanel getpanliste(){
        return panliste;
    }
    
    public JPanel getpanExercice(){
        return panExercice;
    }
    
    public JPanel getpanHaut(){
        return panHaut;
    }

    public AjoutExerciceProf getPanCreer() {
        return panCreer;
    }
    public Exercice getCurrentExercice(){
        return currentExercice;
    }   
}
