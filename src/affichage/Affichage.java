package affichage;

import java.util.Scanner;

public final class Affichage implements InterfaceAffichage {

    @Override
    public void afficherDebutPartie() {
        System.out.println("Démarrage du jeu!\n");

    }
    public void afficherGagnant(String nom){
        afficherString("Le pirate " + nom + " a gagné!\n");
    }
    public void afficherAvance(String nom , int avance){
        afficherString("Le pirate " + nom + " avance de " + avance + " cases\n");
    }
    public void afficheCase(int position){
        afficherString("Il se trouve desormais sur la case numero " + position + "\n");

    }


    public void afficherC(){
        afficherString("[\u001B[35m  C  \u001B[0m]");
    }
    public void afficherV(){
        afficherString("[\u001B[36m  V  \u001B[0m]");
    }
    public void afficherCrochet(){
        afficherString("Aperçu du plateau de jeu :\n");
    }
    public void afficherBJ(){
        afficherString("[\u001B[33m B&J \u001B[0m]");
    }
    public void afficherNom(String nomJoueur){
        afficherString("[\u001B[34m" + nomJoueur + " \u001B[0m]");
    }
    public void afficherDes(String nom){
        afficherString("Le pirate " + nom + " s'aprette a à lancer les dès :\n");
    }
    @Override
    public void afficherFinPartie() {
        System.out.println("\u001B[32mFin du jeu!\u001B[0m\n");

    }

    @Override
    public void afficherResultatDes(int result) {
        System.out.print("Le resultat du lancer est ");
        System.out.println(result);
        System.out.println("--------------------------------");

    }


    @Override
    public void afficherString(String phrase) {
        System.out.print(phrase);
    }


    @Override
    public void touchePress() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Appuyez sur entrée pour continuer...");
        scanner.nextLine();

    }


}
