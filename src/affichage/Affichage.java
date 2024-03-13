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
        System.out.println(result);

    }

    @Override
    public void afficherCase(CaseSpeciale c) {



    }

    @Override
    public void afficherToucheSaisie(){
        System.out.println("Appuyez sur une touche pour lancer les dès...");
    }

    @Override
    public void afficherString(String phrase){
        System.out.println(phrase);
    }

    @Override
    public void touchePress(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur une touche pour continuer...");
        scanner.nextLine(); // l'utilisateur appuie sur "Entrée"

    }
}
