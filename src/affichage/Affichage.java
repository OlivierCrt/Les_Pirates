package affichage;
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
    public void afficherApercuPlateau(Pirate[] joueurs) {}
    /*
    public void afficherApercuPlateau(Pirate[] joueurs) {

        String nomjoueurPresent ="";
        System.out.println("Aperçu du plateau de jeu :");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                boolean joueurpresent = false;
                int count = 0; // Compteur pour le nombre de joueurs sur la case
                for (Pirate joueur : joueurs) {
                    if (joueur.getPostion() == i * 5 + j + 1) {
                        joueurpresent = true;
                        count++;
                        nomjoueurPresent = String.valueOf(joueur.getNom());
                    }
                }
                // Affichage de la case avec ou sans joueur
                if (count > 1) { // Deux pirates sur la même case
                    System.out.print("[\u001B[33mBJ \u001B[0m]");
                } else if (joueurpresent) {
                    if (nomjoueurPresent.equals("BILL")) {
                        System.out.print("[\u001B[34m" + nomjoueurPresent + " \u001B[0m]");
                    } else {
                        System.out.print("[\u001B[31m" + nomjoueurPresent + " \u001B[0m]");
                    }
                } else {
                    // Vérification pour les cases spéciales
                    boolean caseSpeciale = false;
                    for (CaseSpeciale caseSpec : plateau.getCaseSpeciales()) {
                        if (caseSpec.getNumero() == i * 5 + j + 1) {
                            caseSpeciale = true;
                            if (caseSpec instanceof Canon) {
                                System.out.print("[\u001B[35mC \u001B[0m]"); // Case canon
                            } else if (caseSpec instanceof VentFavorable) {
                                System.out.print("[\u001B[36mV \u001B[0m]"); // Case vent favorable
                            }
                        }
                    }
                    if (!caseSpeciale) {
                        System.out.print("[     ]");
                    }
                }
            }
            System.out.println(); // Passer à la ligne suivante après chaque ligne du plateau
        }
    }*/


}
