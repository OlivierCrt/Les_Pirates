package affichage;
import modeles.CaseSpeciale;
import java.util.Scanner;
public final class Affichage implements InterfaceAffichage {

    @Override
    public void afficherDebutPartie() {
        System.out.println("Démarrage du jeu!\n");

    }

    @Override
    public void afficherFinPartie() {
        System.out.println("Fin du jeu!\n");

    }

    @Override
    public void afficherResultatDes(int result) {
        System.out.print("Le resultat du lancer est ");
        System.out.println(result);
        System.out.println("--------------------------------");

    }

    @Override
    public void afficherCase(CaseSpeciale c) {
        System.out.println("case numéro "+ c.getNumero());


    }

    @Override
    public void afficherToucheSaisie(){
        System.out.println("Appuyez sur une touche pour lancer les dès...");
    }

    @Override
    public void afficherString(String phrase){
        System.out.print(phrase);
    }

    @Override
    public void touchePress(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur entrée pour continuer...");
        scanner.nextLine(); // l'utilisateur appuie sur "Entrée"

    }
}
