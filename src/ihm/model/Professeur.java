package ihm.model;

/**
 * Classe Professeur contenant tous les paramètres d'un professeur, 
 * permettant de gérer les professeurs
 * @author Group7
 */
public class Professeur {
    private int idProf;
    private String nomProf;
    private String prenomProf;
    private String mdpProf;

    //Constructeur de la classe Professeur
    public Professeur(int idProf, String nomProf, String prenomProf, String mdpProf) {
        this.idProf = idProf;
        this.nomProf = nomProf;
        this.prenomProf = prenomProf;
        this.mdpProf = mdpProf;
    }

    //getters-setters des paramètres
    public int getIdProf() {
        return idProf;
    }

    public void setIdProf(int idProf) {
        this.idProf = idProf;
    }

    public String getNomProf() {
        return nomProf;
    }

    public void setNomProf(String nomProf) {
        this.nomProf = nomProf;
    }

    public String getPrenomProf() {
        return prenomProf;
    }

    public void setPrenomProf(String prenomProf) {
        this.prenomProf = prenomProf;
    }

    public String getMdpProf() {
        return mdpProf;
    }

    public void setMdpProf(String mdpProf) {
        this.mdpProf = mdpProf;
    }
    
    
    
}
