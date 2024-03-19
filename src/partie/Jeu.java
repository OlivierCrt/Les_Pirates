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
    private Pirate joueurActuel ;




    //getters setters constructeur
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
        this.joueurActuel = joueurs[0] ; //on commence avec le joueur 1


    }

    public Des getDes(){
        return des ;
    }
    public Plateau getPlateau() {
        return plateau;
    }
    public Affichage getAffichage() {
        return affichage;
    }
    public Pirate[] getJoueurs() {
        return joueurs;
    }
    public int getNombreJoueurs() {
        return joueurs.length;
    }
    public void setJoueurActuel(Pirate joueur){
        this.joueurActuel = joueur ;
    }
    public Pirate getJoueurActuel(){
        return joueurActuel;
    }


    //methodes
    //voir diag de sequence
    public int lancerDes(Pirate joueur) {
        getAffichage().afficherString("Le pirate "+joueur.getNom()+" s'aprette a à lancer les dès :\n");
        getAffichage().touchePress();
        int res =getDes().resultatDes();
        getAffichage().afficherResultatDes(res);
        return (res);


    }

    public boolean verifierGagnant(Pirate joueur) {
        if (joueur.getPostion() == 30) {
            getAffichage().afficherString("Le pirate "+joueur.getNom()+" a gagné!\n");
            return true;
        }
        return false;
    }
    public void changementJoueuractuel (){
        if(joueurActuel == joueurs[0]){
            setJoueurActuel(joueurs[1]);
        }
        else {
            setJoueurActuel(joueurs[0]);
        }
    }
    public void avancerJoueur(Pirate joueur,int avance){
        if(joueur.getPostion()+avance <= 30) {
            joueur.setPostion(joueur.getPostion() + avance);
        }
        else{
            joueur.setPostion(60 -( joueur.getPostion() + avance));
        }
        getAffichage().afficherString("Le pirate "+getJoueurActuel().getNom() + " avance de "+ avance + " cases\n");
        getAffichage().afficherString("Il se trouve desormais sur la case numero "+joueur.getPostion()+"\n");



    }

  /  public void lancerCaseSpeciale(Pirate precedent){
        boolean estDedans  = false;
        for (int i =0 ; i<getPlateau().getCaseSpeciales().length ; i++){
            if(getJoueurActuel().getPostion() == getPlateau().getCaseSpeciales()[i].getNumero()){
                estDedans = true ;
                action =
                getAffichage().afficherString(getJoueurActuel().getNom() + " tu te trouves sur une case "+ getPlateau().getCaseSpeciales()[i].actionCaseSpeciale() +"!\n");

            }
        }

    }


    public void lancerJeu(){
        getAffichage().afficherDebutPartie();

        //////////////////////////////////////////
        Pirate JoueurPrecedent=joueurs[1];
        //Tour de jeu
        while (!verifierGagnant(getJoueurs()[0]) && !verifierGagnant(getJoueurs()[1])) {
            getAffichage().afficherApercuPlateau(getJoueurs()); // Afficher l'aperçu du plateau
            // Partie 0 de mon schema immobilisation à implementer--> OK
            if (joueurActuel.getTourImmobile()  ==  0) {
                //Partie 1
                int resDes =lancerDes(getJoueurActuel());
                //partie 2 avancer
                avancerJoueur(getJoueurActuel(),resDes);
                //partie 3 case sp à implementer
                //lancerCaseSpeciale(JoueurPrecedent);

            }
            else {
                getAffichage().afficherString("\u001B[31mNON "+ getJoueurActuel().getNom() + " tu es immobilisé pour ce tour!\n\u001B[0m");
                getJoueurActuel().setTourImmobile(getJoueurActuel().getTourImmobile()-1);
                getAffichage().afficherString("Il te reste encore "+ getJoueurActuel().getTourImmobile() +" tour(s) à attendre, patience...");
            }



            //fin de tour
            JoueurPrecedent=getJoueurActuel();
            changementJoueuractuel();
        }
        //////////////////////////////////////////
        getAffichage().afficherFinPartie();

    }






}
