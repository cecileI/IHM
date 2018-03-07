/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm.model;

import java.util.ArrayList;

/**
 * @author pc
 *
 */
public class Classe {
	private ArrayList<Eleve> listEleve;
	private String niveau;
	private String prof;

	/**
	 * @param niveau
	 * @param prof
	 */
	public Classe(String niveau, String prof) {

		this.niveau = niveau;
		this.prof = prof;
		this.listEleve = new ArrayList<Eleve>();
	}

//	public void addEleve(Eleve e) {
//		this.listEleve.add(e);
//		e.setClasse(this);
//	}

	/**
	 * @return
	 */
	public Object getNiveau() {
		return this.niveau;
	}

	public ArrayList<Eleve> getEleves() {
		return this.listEleve;
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

	public String getProf() {
		return this.prof;
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
	 * @param prof
	 *            the prof to set
	 */
	public void setProf(String prof) {
		this.prof = prof;
	}

	/**
	 * 
	 */
	public void setNiveau(String niveau) {
		this.niveau = niveau;

	}

}

