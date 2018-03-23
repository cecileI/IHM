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
 * @author pc
 *
 */
public class Classe {
	private ArrayList<Eleve> listEleve;
	private String niveau;

	/**
	 * @param niveau
	 * @param prof
	 */
	public Classe(String niveau) {

		this.niveau = niveau;
		this.listEleve = InfoBDD.selectionListEleveClasse(niveau);
	}

        
	public String getNiveau() {
		return this.niveau;
	}

	public ArrayList<Eleve> getElevesClasse() {
		return listEleve;
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
	 * @return
	 */
	public int getNombreEleves() {
		return this.listEleve.size();
	}

	public boolean contains(Eleve eleve) {
		return this.listEleve.contains(eleve);
	}

	/**
	 * @param convertRowIndexToModel
	 * @return
	 */
	public Eleve get(int index) {

		return listEleve.get(index);
	}

	/**
	 * 
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;

	}

}

