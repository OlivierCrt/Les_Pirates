package affichage;

import java.util.Scanner;

public final class Affichage implements InterfaceAffichage {

    @Override
    public void afficherDebutPartie() {
        System.out.println("Démarrage du jeu!\n");

    }
    @Override
    public void afficherGagnant(String nom){
        afficherString("Le pirate " + nom + " a gagné!\n");
    }
    @Override
    public void afficherAvance(String nom , int avance){
        afficherString("Le pirate " + nom + " avance de " + avance + " cases\n");
    }
    @Override
    public void afficheCase(int position){
        afficherString("Il se trouve desormais sur la case numero " + position + "\n");

    }
    @Override
    public void afficherImmo(String nom){
        afficherString("\u001B[31mNON " + nom + " tu es immobilisé pour ce tour!\n\u001B[0m");
    }
    @Override
    public void afficherAttente(int nombre){
        afficherString("Il te reste encore " + nombre + " tour(s) à attendre, patience...");
    }
    @Override
    public void afficherFavo(){
        afficherString("\u001B[32mCoup de bol tu avances de 10 cases.\n\u001B[0m");
    }
    @Override
    public void afficherVent(String nom){
        afficherString("Tu es sur une case vent favorable " + nom + "!\n");
    }
    @Override


    public void afficherC(){
        afficherString("[\u001B[35m  C  \u001B[0m]");
    }
    @Override
    public void afficherV(){
        afficherString("[\u001B[36m  V  \u001B[0m]");
    }
    @Override
    public void afficherCrochet(){
        afficherString("[     ]");
    }
    @Override
    public void afficherDistancage(){
        afficherString("\u001B[32mTon adversaire croyait te distancer mais tu le rattrapes facilement!\u001B[0m\n");
    }
    @Override
    public void afficherapercu(){
        afficherString("Aperçu du plateau de jeu :\n");
    }
    @Override
    public void afficherBoulet(){
        afficherString("Ton adversaire est derrière toi tu lui envoies donc un boulet en pleine figure!\n");
    }
    @Override

    public void afficherCanon(String nom){
        afficherString("Tu es sur une case Canon " + nom + "!\n");
    }
    @Override
    public void afficherBJ(){
        afficherString("[\u001B[33m B&J \u001B[0m]");
    }
    @Override
    public void afficherNom(String nomJoueur){
        afficherString("[\u001B[34m" + nomJoueur + " \u001B[0m]");
    }
    @Override
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
