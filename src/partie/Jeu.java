package partie;

import affichage.Affichage;
import joueur.Nom;
import joueur.Pirate;
import modeles.*;


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





    public void apercuPlateau() {
        affichage.afficherString("Aperçu du plateau de jeu :\n");

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                boolean joueurPresent = false;
                int count = 0; // Compteur pour le nombre de joueurs sur la case
                String nomJoueurPresent = "";
                for (Pirate joueur : joueurs) {
                    if (joueur.getPostion() == i * 5 + j + 1) {
                        joueurPresent = true;
                        count++;
                        nomJoueurPresent = joueur.getNom().toString();
                    }
                }
                // Affichage de la case avec ou sans joueur
                if (count > 1) { // Deux pirates sur la même case
                    affichage.afficherString("[\u001B[33mBJ \u001B[0m]");
                } else if (joueurPresent) {
                    if (nomJoueurPresent.equals("BILL")) {
                        affichage.afficherString("[\u001B[34m" + nomJoueurPresent + " \u001B[0m]");
                    } else {
                        affichage.afficherString("[\u001B[31m" + nomJoueurPresent + " \u001B[0m]");
                    }
                } else {
                    // Vérification pour les cases spéciales
                    boolean caseSpeciale = false;
                    for (CaseSpeciale caseSpec : plateau.getCaseSpeciales()) {
                        if (caseSpec.getNumero() == i * 5 + j + 1) {
                            caseSpeciale = true;
                            if (caseSpec instanceof Canon) {
                                affichage.afficherString("[\u001B[35mC \u001B[0m]"); // Case canon
                            } else if (caseSpec instanceof VentFavorable) {
                                affichage.afficherString("[\u001B[36mV \u001B[0m]"); // Case vent favorable
                            }
                        }
                    }
                    if (!caseSpeciale) {
                        affichage.afficherString("[     ]");
                    }
                }
            }
            affichage.afficherString("\n"); // Passer à la ligne suivante après chaque ligne du plateau
        }
    }


    public void lancerCaseSpeciale(Pirate precedent){
        boolean estDedans  = false;
        for (int i =0 ; i<getPlateau().getCaseSpeciales().length ; i++){
            if(getJoueurActuel().getPostion() == getPlateau().getCaseSpeciales()[i].getNumero()){
                estDedans = true ;
                CaseSpeciale tempCase = getPlateau().getCaseSpeciales()[i] ;
                if(tempCase instanceof Canon){
                    getAffichage().afficherString("Tu es sur une case Canon "+getJoueurActuel().getNom()+"!");
                    Canon tempCanon = (Canon) tempCase ;
                    tempCanon.actionCanon(getJoueurActuel(),precedent);
                    if( precedent.getPostion() < getJoueurActuel().getPostion()){
                        getAffichage().afficherString("Ton adversaire est derrière toi tu lui envoies donc un boulet en pleine figure!\n");
                    }
                    else {
                        getAffichage().afficherString("Ton adversaire croyait te distancer mais tu le rattrapes facilement!\n");
                    }

                }
                else if (tempCase instanceof VentFavorable) {
                    getAffichage().afficherString("Tu es sur une case vent favorable "+getJoueurActuel().getNom()+"!\n");
                    VentFavorable tempVent = (VentFavorable) tempCase ;
                    tempVent.actionVent(getJoueurActuel());
                    getAffichage().afficherString("Coup de bol tu avances de 10 cases.\n");

                }
            }
        }

    }


    public void lancerJeu(){
        getAffichage().afficherDebutPartie();

        //////////////////////////////////////////
        Pirate JoueurPrecedent=joueurs[1];
        //Tour de jeu
        while (!verifierGagnant(getJoueurs()[0]) && !verifierGagnant(getJoueurs()[1])) {
            apercuPlateau();
            // Partie 0 de mon schema immobilisation à implementer--> OK
            if (joueurActuel.getTourImmobile()  ==  0) {
                //Partie 1
                int resDes =lancerDes(getJoueurActuel());
                //partie 2 avancer
                avancerJoueur(getJoueurActuel(),resDes);
                //partie 3 case sp à implementer
                lancerCaseSpeciale(JoueurPrecedent);

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
