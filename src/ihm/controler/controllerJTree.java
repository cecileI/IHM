/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.controler;

import ihm.view.View;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author clarisse
 */
public class controllerJTree implements TreeSelectionListener{
    private JTree tree;
    private View view;
            
    public controllerJTree (JTree tree, View view){
        tree = this.tree;
        view = this.view;         
    }
    
    @Override
    public void valueChanged(TreeSelectionEvent event) {
        //
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();

	if (selectedNode == null){ //si le noeud est vide on ne fait rien
		return;
        } else {
            Object nodeInfo = selectedNode.getUserObject();
            System.out.println("node info " + nodeInfo);
            view.controllerJTreeCall(nodeInfo); 
	}

    }
    
    
    
    
}
