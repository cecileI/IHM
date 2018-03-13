package ihm.view;

import ihm.controler.InfoBDD;
import ihm.model.Classe;
import ihm.model.Eleve;
import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author Group7
 */
public class ViewJTree extends JPanel{
    private JTextField txtNombreEleves,txtPrenom,txtNom,txtNiveau,txtProf;
    private JTree tree;
    private DefaultMutableTreeNode racine;
    private Eleve currentEleve;
    private Classe currentClasse;
    
    public ViewJTree(){
            // Tree gestion
            
            racine = new DefaultMutableTreeNode("Gphy"); // creation racine //model.getEcole().getNom()
            tree = new JTree(racine);  // creation arbre à partir de  racine
            tree.setShowsRootHandles(true);
            tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
            this.add(tree);
    }
    
    /*
    * Fonction de création de l'arbre 
    * Il est composé de classes et d'élèves
    */
    public void createTree(){
        //on parcourt toutes las classes
        for (Classe laclasse : InfoBDD.selectionListClasse()){ //liste de classe 
            //on crée de nouveaux noeuds
            System.out.println(laclasse);
            DefaultMutableTreeNode nodeClasse = new DefaultMutableTreeNode(laclasse.getNiveau());
            //on ajoute les classes à l'arbre
            racine.add(nodeClasse);
            //on parcourt tous les eleves
            System.out.println(laclasse.getElevesClasse());
            for (Eleve leleve : laclasse.getElevesClasse()){
                System.out.println(leleve);
                //on crée de nouveaux noeuds
                DefaultMutableTreeNode nodeEleve = new DefaultMutableTreeNode(leleve.getNomEleve());
                //on ajoute les eleves à l'arbre
                nodeClasse.add(nodeEleve);
            }
        } 
    }
    
    /*
    * Cette fonction est appelée apres avoir cliqué sur un élément dans le ViewJTree
    * La fenetre est mise a jour en fonction de l'élément choisi (Eleve ou Classe)
    * @param selected Node : l'élément choisi dans l'arbre
    */
    public void controllerJTreeCall(Object selectedNode){
        if (selectedNode instanceof Eleve) { //si l'élément choisi est un élève
            currentEleve = (Eleve)selectedNode; //l'élève courant est celui sélectionné
            String currentNiveau =  currentEleve.getNiveau(); //la classe courante est celle de l'élève sélectionné
            currentClasse= new Classe(currentNiveau);
            //update();//mis à jour
            
        }else if(selectedNode instanceof Classe){ //si l'élément choisi est une classe
            currentEleve = null; //il n'y a pas d'élève courant
            currentClasse = (Classe)selectedNode; // la classe courante est celle sélectionnée
            //update(); //mis à jour
            
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
            txtNom.setText(currentEleve.getNomEleve()); // Nom de l'eleve
            txtPrenom.setText(currentEleve.getPrenomEleve()); //Prenom de l'eleve
            //String taille = "" + (currentEleve.getClasse().getNombreEleves() + ""); //Calcul de la taille de la classe
            //txtNombreEleves.setText(taille); //Affichage du nombre d'eleves dans la classe
            //txtProf.setText(currentEleve.getClasse().getProf()); //Affichage du nom du prof
            txtNiveau.setText("" + currentEleve.getNiveau()); // Affichage du niveau de la classe
            //this.viewTable.setData(currentEleve.getClasse()); //mise a jour JTable
            
        }else if(currentClasse!=null){
            String taille = "" + (currentClasse.getNombreEleves()); //Calcul de la taille de la classe
            txtNombreEleves.setText(taille); //Affichage du nombre d'eleves dans la classe
            //txtProf.setText(currentClasse.getProf()); //Affichage du nom du prof
            txtNiveau.setText("" + currentClasse.getNiveau()); // Affichage du niveau de la classe
            //this.viewTable.setData(currentClasse); //mise a jour JTable
            txtNom.setText(""); //Vide le champ nom
            txtPrenom.setText(""); //Vide le champ prenom
            
        }else{
            System.out.print("Erreur");
        }
    }
    
}
