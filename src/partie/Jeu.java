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
        if (joueur.getPosition() == 30) {
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
        if (joueur.getPosition() + avance <= 30) {
            joueur.setPosition(joueur.getPosition() + avance);
        } else {
            joueur.setPosition(60 - (joueur.getPosition() + avance));
        }
        getAffichage().afficherAvance(getJoueurActuel().getNom().toString(), avance);
        getAffichage().afficheCase(joueur.getPosition());


    }


    public int nombreDeJoueursSurCase(int ligne, int colonne) {
        int count = 0;
        for (Pirate joueur : joueurs) {
            if (joueur.getPosition() == ligne * 5 + colonne + 1) {
                count++;
            }
        }
        return count;
    }

    public String nomDuJoueurSurCase(int ligne, int colonne) {
        for (Pirate joueur : joueurs) {
            if (joueur.getPosition() == ligne * 5 + colonne + 1) {
                return joueur.getNom().toString();
            }
        }
        return "";
    }

    public void splitApercuPlateau(int ligne, int colonne) {
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
            getAffichage().afficherCrochet();
        }
    }

    public void apercuPlateau() {
        getAffichage().afficherapercu();

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                int nombreDeJoueurs = nombreDeJoueursSurCase(i, j);
                if (nombreDeJoueurs > 1) {
                    getAffichage().afficherBJ();
                } else if (nombreDeJoueurs == 1) {
                    String nomJoueur = nomDuJoueurSurCase(i, j);
                    getAffichage().afficherNom(nomJoueur);

                } else {
                    splitApercuPlateau(i, j);
                }
            }
            getAffichage().afficherString("\n");
        }
    }


    public void lancerCaseSpeciale(Pirate precedent) {
        for (int i = 0; i < getPlateau().getCaseSpeciales().length; i++) {
            if (getJoueurActuel().getPosition() == getPlateau().getCaseSpeciales()[i].getNumero()) {
                CaseSpeciale tempCase = getPlateau().getCaseSpeciales()[i];
                if (tempCase instanceof Canon tempCanon) {
                    getAffichage().afficherCanon(getJoueurActuel().getNom().toString());
                    tempCanon.actionCanon(getJoueurActuel(), precedent);
                    if (precedent.getPosition() < getJoueurActuel().getPosition()) {
                        getAffichage().afficherBoulet();
                    } else {
                        getAffichage().afficherDistancage();
                    }

                } else if (tempCase instanceof VentFavorable tempVent) {
                    getAffichage().afficherVent(getJoueurActuel().getNom().toString());
                    tempVent.actionVent(getJoueurActuel());
                    getAffichage().afficherFavo();

                }
            }
        }

    }


    public void lancerJeu() {
        getAffichage().afficherDebutPartie();


        Pirate joueurPrecedent = joueurs[1];

        do {
            apercuPlateau();
            if (getJoueurActuel().getTourImmobile() == 0) {
                int resDes = lancerDes(getJoueurActuel());
                avancerJoueur(getJoueurActuel(), resDes);
                lancerCaseSpeciale(joueurPrecedent);

            } else {
                getAffichage().afficherImmo(getJoueurActuel().getNom().toString());
                getJoueurActuel().setTourImmobile(getJoueurActuel().getTourImmobile() - 1);
                getAffichage().afficherAttente(getJoueurActuel().getTourImmobile()); //
            }


            joueurPrecedent = getJoueurActuel();
            changementJoueuractuel();
        }while (!verifierGagnant(getJoueurs()[0]) && !verifierGagnant(getJoueurs()[1]));
        getAffichage().afficherFinPartie();

    }


}
