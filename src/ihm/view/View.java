/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.view;

import ihm.model.Classe;
import ihm.model.Eleve;
import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeSelectionModel;

/**
 *
 * @author clarisse
 */
public class View extends JFrame{
    
    private JTree tree;
    private DefaultMutableTreeNode racine;
    
    public View(){
    // Tree gestion
            racine = new DefaultMutableTreeNode(model.getEcole().getNom()); // creation racine 
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
        for (Classe laclasse : this.model.getEcole().getClasses()){
            //on crée de nouveaux noeuds
            DefaultMutableTreeNode nodeClasse = new DefaultMutableTreeNode(laclasse);
            //on ajoute les classes à l'arbre
            racine.add(nodeClasse);
            //on parcourt tous les eleves
            for (Eleve leleve : laclasse.getEleves()){
                //on crée de nouveaux noeuds
                DefaultMutableTreeNode nodeEleve = new DefaultMutableTreeNode(leleve);
                //on ajoute les eleves à l'arbre
                nodeClasse.add(nodeEleve);
            }
        } 
    }
    
}
