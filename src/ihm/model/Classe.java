/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.model;

import ihm.controler.InfoBDD;
import static ihm.controler.InfoBDD.selectionListEleveClasse;
import java.util.ArrayList;

/**
 * @author group 7
 *
 */
public class Classe {
	private String niveau;

	/**
	 * @param niveau
	 * @param prof
	 */
	public Classe(String niveau) {

		this.niveau = niveau;
	}

        
	public String getNiveau() {
		return this.niveau;
	}
        

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.niveau;
	}

	/**
	 * 
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;

	}

}

