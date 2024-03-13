package partie;

import affichage.Affichage;
import joueur.Nom;
import joueur.Pirate;
import modeles.Plateau;


public class Jeu {
    private Pirate[] joueurs;
    private Affichage affichage;
    private Plateau plateau;




    //getters setters

    public Jeu(Affichage affichage, Plateau plateau , Pirate[] joueurs) {
        //this.joueurActuel = new Pirate(Nom.NO_JOUEUR, 0);
        this.affichage = affichage;
        this.plateau = plateau;
        this.joueurs = joueurs;
    }
    public Plateau getPlateau() {
        return plateau;
    }
    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
    public Affichage getAffichage() {
        return affichage;
    }
    public void setAffichage(Affichage affichage) {
        this.affichage = affichage;
    }
    public Pirate[] getJoueurs() {
        return joueurs;
    }
    public void setJoueurs(Pirate[] joueurs) {
        this.joueurs = joueurs;
    }
    public int getNombreJoueurs() {
        return joueurs.length;
    }


    //methodes
    //voir diag de sequence
    public void creerJeu( ){

    }
    public Integer lancerDes(Pirate joueur) {
        getAffichage().afficherString("Le pirate "+joueur.getNom()+" s'aprette a à lancer les dès :");
        getAffichage().afficherToucheSaisie();
        return 0 ;


    }




}
