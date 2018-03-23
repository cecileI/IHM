package ihm.view;

import ihm.controler.InfoBDD;
import ihm.controler.controllerJTree;
import ihm.controler.controllerMenuProfesseur;
import ihm.model.Classe;
import ihm.model.Eleve;
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
 *  Cette classe permet de créé une fenetre qui permettra a l'élève d'acceder à ces fonctionnalitées
 * @author Goup7
 */
public class MenuProfesseur extends JFrame {
   
    //JPanel
    private JPanel panGeneral; //panel général qui regroupe toutes les informations de la Jframe
    private JPanel panDroite; //panel à droite qui sera modifier par des nouveaux panel
    private JPanel panHaut; //panel de deconnection et panel blanc
    private JPanel panExercice; //panel qui regroupe les boutons création et modification exercice
    
    //JButton
    private JButton creerExercice; //bouton création exercice
    private JButton modifierExercice; //bouton modification exercice
    private JButton deconnexion; //bouton deconnection
    
    //JTree
    private JPanel panTree; //panel à gauche Jtree
    private JLabel lblEleve;
    private JTextField txtNom, txtPrenom;
    private JTree tree;
    private DefaultMutableTreeNode racine;
    private Eleve currentEleve;
    private Classe currentClasse;
    
    //redimensionner pour refresh
    private ListeExercicesProf panliste;
           
    public MenuProfesseur(){
        controllerMenuProfesseur controlProf = new controllerMenuProfesseur(this);
              
        //Partie JTree à gauche 
            racine = new DefaultMutableTreeNode("Gphy"); // creation racine
            createTree();
            tree = new JTree(racine);  // creation arbre à partir de  racine
            tree.setShowsRootHandles(true);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            
            tree.addTreeSelectionListener(new controllerJTree(this.tree, this));
            
            panTree=new JPanel();
            panTree.add(tree);
            //panTree.setPreferredSize(new Dimension(140,450));
                       
            panliste = new ListeExercicesProf();
        //Boutton Deconnection
        deconnexion = new JButton("Deconnexion");
        deconnexion.setPreferredSize(new Dimension(20,10));
        deconnexion.addActionListener(controlProf);
        

        //Partie Exercice     
            //Bouton création exercice
        creerExercice = new JButton("Créer un Exercice");
        creerExercice.addActionListener(controlProf); 
        
        
            //Bouton modification exercice
        modifierExercice = new JButton("Modifier un Exercice");
        modifierExercice.addActionListener(new ActionListener () {
                public void actionPerformed (ActionEvent e) {
                    
                    panDroite.remove(panHaut);
                    panDroite.remove(panExercice);
                    panGeneral.remove(panDroite);
                    panDroite.add(panliste);
                    panGeneral.add(panDroite,BorderLayout.CENTER);
                    repaint();
                    validate();                    
                }
            });      
        JLabel blanc0 = new JLabel("");
        blanc0.setHorizontalAlignment(SwingConstants.CENTER);
        //Le nom et le prénom de l'élève 
        panHaut = new JPanel();
        panHaut.setPreferredSize(new Dimension(550,50));
        panHaut.setLayout(new GridLayout(1,2));
        panHaut.add(blanc0);
        //panHaut.add(lblEleve);
        panHaut.add(deconnexion);   //JPanel Deconnection   
        
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
        panExercice.setPreferredSize(new Dimension(550,400));
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
        panDroite.setPreferredSize(new Dimension(550,450));
        panDroite.add(panHaut);
        panDroite.add(panExercice);
        
        panGeneral = new JPanel();
        panGeneral.setLayout(new BorderLayout()); 
        panGeneral.add(panTree,BorderLayout.WEST);     //ajout du JTree au menu (à gauche)
        panGeneral.add(panDroite,BorderLayout.EAST);   //ajout du panel général au menu
        
        this.add(panGeneral);
        
        //this.getContentPane().setLayout(new BorderLayout()); 
        this.setTitle("Menu Professeur");
        this.setSize(750,500);  //largeur, hauteur
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
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
            txtNom = new JTextField();
            txtNom.setText("Nom");
            txtPrenom =new JTextField();
            txtPrenom.setText("Prenom");

            panHaut.add(txtNom);
            panHaut.add(txtPrenom);
            //panHaut.add(lblEleve);
            panHaut.add(deconnexion);   //JPanel Deconnection   
            
            
            txtNom.setText(currentEleve.getNomEleve()); // Nom de l'eleve
            txtPrenom.setText(currentEleve.getPrenomEleve()); //Prenom de l'eleve
            //String taille = "" + (currentEleve.getClasse().getNombreEleves() + ""); //Calcul de la taille de la classe
            //txtNombreEleves.setText(taille); //Affichage du nombre d'eleves dans la classe
            //txtProf.setText(currentEleve.getClasse().getProf()); //Affichage du nom du prof
            //txtNiveau.setText("" + currentEleve.getNiveau()); // Affichage du niveau de la classe
            //this.viewTable.setData(currentEleve.getClasse()); //mise a jour JTable
            
        //}else if(currentClasse!=null){
            //String taille = "" + (currentClasse.getNombreEleves()); //Calcul de la taille de la classe
            //txtNombreEleves.setText(taille); //Affichage du nombre d'eleves dans la classe
            //txtProf.setText(currentClasse.getProf()); //Affichage du nom du prof
            //txtNiveau.setText("" + currentClasse.getNiveau()); // Affichage du niveau de la classe
            //this.viewTable.setData(currentClasse); //mise a jour JTable
            //txtNom.setText(""); //Vide le champ nom
            //txtPrenom.setText(""); //Vide le champ prenom
            
        }else{
            System.out.print("Erreur");
        }
    }
    
    public JButton getDeconnexion(){
        return deconnexion;
    }
    
    public JButton getcreerExercice(){
        return creerExercice;
    }
}
