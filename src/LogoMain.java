import ihm.controler.InfoBDD;
import ihm.model.Classe;
import ihm.view.*;

/**
 * Classe lançant l'application
 * @author Group7
 */
public class LogoMain{
    
    private static InterfaceDebut interfaceDebut;
    /**
     * Constructeur de la classe LogoMain
     * @param args The user do not have to put argument. This parameter is for 
     * the user with command line version of the application.
     */
    public static void main (String[] args){

        System.out.println(InfoBDD.selectionListClasse());
        for (Classe laclasse : InfoBDD.selectionListClasse()){
            System.out.println(InfoBDD.selectionListEleveClasse(laclasse));
        }
        
        //Lance l'interface Début en instanciant la classe JFrame InterfaceDebut 
        InterfaceDebut app = new InterfaceDebut();
    }
}
