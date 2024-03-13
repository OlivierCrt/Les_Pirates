package partie;

import affichage.Affichage;
import joueur.Nom;
import joueur.Pirate;
import modeles.Des;
import modeles.Plateau;



public class Jeu {
    private Pirate[] joueurs;
    private Affichage affichage;
    private Plateau plateau;
    private Des des;




    //getters setters constructeurs
    public Jeu(){
        Des des = new Des(6);
        Affichage affichage = new Affichage();
        Plateau plateau = new Plateau();
        Pirate[] joueurs = new Pirate[2];
        joueurs[0] = new Pirate(Nom.BILL , 5);
        joueurs[1] = new Pirate(Nom.JACK, 5) ;
        this.affichage = affichage;
        this.plateau = plateau;
        this.joueurs = joueurs;
        this.des = des ;


    }

    public Des getDes(){
        return des ;
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
    public void lancerDes(Pirate joueur) {
        getAffichage().afficherString("Le pirate "+joueur.getNom()+" s'aprette a à lancer les dès :");
        getAffichage().touchePress();
        getAffichage().afficherResultatDes(getDes().resultatDes());


    }



    public void lancerJeu(){
        getAffichage().afficherDebutPartie();
        while (getJoueurs()[0].getPostion() != 30 && getJoueurs()[1].getPostion()!= 30) {
            lancerDes(joueurs[0]);
            lancerDes(joueurs[1]);

        }

        getAffichage().afficherFinPartie();

    }





}
