package affichage;
import modeles.CaseSpeciale;
import joueur.Pirate;
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

    @Override
    public void afficherApercuPlateau(Pirate[] joueurs) {
        String nomjoueurPresent ="";
        System.out.println("Aperçu du plateau de jeu :");

        // Boucle pour parcourir chaque ligne
        for (int i = 0; i < 6; i++) {
            // Boucle pour parcourir chaque colonne
            for (int j = 0; j < 5; j++) {
                // Vérifier si un joueur est présent sur cette case
                boolean joueurpresent = false;
                for (Pirate joueur : joueurs) {
                    if (joueur.getPostion() == i * 5 + j + 1) {
                        joueurpresent = true;
                        nomjoueurPresent = String.valueOf(joueur.getNom());
                        break;
                    }
                }
                // Affichage de la case avec ou sans joueur
                if (joueurpresent) {
                    if(nomjoueurPresent == "BILL"){
                    System.out.print("[\u001B[34m" + nomjoueurPresent + " \u001B[0m]");}
                    else{
                        System.out.print("[\u001B[31m" + nomjoueurPresent + " \u001B[0m]");}

                    }


                else {
                    System.out.print("[     ]");
                }
            }
            System.out.println(); // Passer à la ligne suivante après chaque ligne du plateau
        }
    }

}
