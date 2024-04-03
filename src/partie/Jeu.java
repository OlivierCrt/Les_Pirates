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
    private Pirate joueurActuel;


    //getters setters constructeur
    public Jeu() {
        Des desduJeu = new Des(6);
        Affichage affichageduJeu = new Affichage();
        Plateau plateauduJeu = new Plateau();
        Pirate[] joueursdujeu = new Pirate[2];
        joueursdujeu[0] = new Pirate(Nom.BILL, 5);
        joueursdujeu[1] = new Pirate(Nom.JACK, 5);
        this.affichage = affichageduJeu;
        this.plateau = plateauduJeu;
        this.joueurs = joueursdujeu;
        this.des = desduJeu;
        this.joueurActuel = joueursdujeu[0];


    }

    public Des getDes() {
        return des;
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

    public void setJoueurActuel(Pirate joueur) {
        this.joueurActuel = joueur;
    }

    public Pirate getJoueurActuel() {
        return joueurActuel;
    }


    //methodes
    //voir diag de sequence
    public int lancerDes(Pirate joueur) {
        getAffichage().afficherDes(joueur.getNom().toString());
        getAffichage().touchePress();
        int res = getDes().resultatDes();
        getAffichage().afficherResultatDes(res);
        return (res);


    }

    public boolean verifierGagnant(Pirate joueur) {
        if (joueur.getPostion() == 30) {
            getAffichage().afficherGagnant(joueur.getNom().toString());
            return true;
        }
        return false;
    }

    public void changementJoueuractuel() {
        if (joueurActuel == joueurs[0]) {
            setJoueurActuel(joueurs[1]);
        } else {
            setJoueurActuel(joueurs[0]);
        }
    }

    public void avancerJoueur(Pirate joueur, int avance) {
        if (joueur.getPostion() + avance <= 30) {
            joueur.setPostion(joueur.getPostion() + avance);
        } else {
            joueur.setPostion(60 - (joueur.getPostion() + avance));
        }
        getAffichage().afficherAvance(getJoueurActuel().getNom().toString(),avance);
        getAffichage().afficheCase(joueur.getPostion());


    }


    private int nombreDeJoueursSurCase(int ligne, int colonne) {
        int count = 0;
        for (Pirate joueur : joueurs) {
            if (joueur.getPostion() == ligne * 5 + colonne + 1) {
                count++;
            }
        }
        return count;
    }

    private String nomDuJoueurSurCase(int ligne, int colonne) {
        for (Pirate joueur : joueurs) {
            if (joueur.getPostion() == ligne * 5 + colonne + 1) {
                return joueur.getNom().toString();
            }
        }
        return "";
    }

    private void splitApercuPlateau(int ligne, int colonne) {
        boolean caseSpeciale = false;
        for (CaseSpeciale caseSpec : plateau.getCaseSpeciales()) {
            if (caseSpec.getNumero() == ligne * 5 + colonne + 1) {
                caseSpeciale = true;
                if (caseSpec instanceof Canon) {
                    affichage.afficherC();
                } else if (caseSpec instanceof VentFavorable) {
                    affichage.afficherV();
                }
            }
        }
        if (!caseSpeciale) {
            affichage.afficherString("[     ]");
        }
    }

    public void apercuPlateau() {
        affichage.afficherCrochet();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                int nombreDeJoueurs = nombreDeJoueursSurCase(i, j);
                if (nombreDeJoueurs > 1) {
                    affichage.afficherBJ();
                } else if (nombreDeJoueurs == 1) {
                    String nomJoueur = nomDuJoueurSurCase(i, j);
                        affichage.afficherNom(nomJoueur);

                } else {
                    splitApercuPlateau(i, j);
                }
            }
            affichage.afficherString("\n");
        }
    }


    public void lancerCaseSpeciale(Pirate precedent) {
        for (int i = 0; i < getPlateau().getCaseSpeciales().length; i++) {
            if (getJoueurActuel().getPostion() == getPlateau().getCaseSpeciales()[i].getNumero()) {
                CaseSpeciale tempCase = getPlateau().getCaseSpeciales()[i];
                if (tempCase instanceof Canon tempCanon) {
                    getAffichage().afficherString("Tu es sur une case Canon " + getJoueurActuel().getNom() + "!\n");
                    tempCanon.actionCanon(getJoueurActuel(), precedent);
                    if (precedent.getPostion() < getJoueurActuel().getPostion()) {
                        getAffichage().afficherString("Ton adversaire est derrière toi tu lui envoies donc un boulet en pleine figure!\n");
                    } else {
                        getAffichage().afficherString("\u001B[32mTon adversaire croyait te distancer mais tu le rattrapes facilement!\u001B[0m\n");
                    }

                } else if (tempCase instanceof VentFavorable tempVent) {
                    getAffichage().afficherString("Tu es sur une case vent favorable " + getJoueurActuel().getNom() + "!\n");
                    tempVent.actionVent(getJoueurActuel());
                    getAffichage().afficherString("\u001B[32mCoup de bol tu avances de 10 cases.\n\u001B[0m");

                }
            }
        }

    }


    public void lancerJeu() {
        getAffichage().afficherDebutPartie();

        //////////////////////////////////////////
        Pirate joueurPrecedent = joueurs[1];
        //Tour de jeu
        while (!verifierGagnant(getJoueurs()[0]) && !verifierGagnant(getJoueurs()[1])) {
            apercuPlateau();
            // Partie 0 de mon schema immobilisation à implementer--> OK
            if (joueurActuel.getTourImmobile() == 0) {
                //Partie 1
                int resDes = lancerDes(getJoueurActuel());
                //partie 2 avancer
                avancerJoueur(getJoueurActuel(), resDes);
                //partie 3 case sp à implementer
                lancerCaseSpeciale(joueurPrecedent);

            } else {
                getAffichage().afficherString("\u001B[31mNON " + getJoueurActuel().getNom() + " tu es immobilisé pour ce tour!\n\u001B[0m");
                getJoueurActuel().setTourImmobile(getJoueurActuel().getTourImmobile() - 1);
                getAffichage().afficherString("Il te reste encore " + getJoueurActuel().getTourImmobile() + " tour(s) à attendre, patience...");
            }


            //fin de tour
            joueurPrecedent = getJoueurActuel();
            changementJoueuractuel();
        }
        //////////////////////////////////////////
        getAffichage().afficherFinPartie();

    }


}
