package modeles;

import joueur.Pirate;

public class VentFavorable extends CaseSpeciale {
    protected VentFavorable(int numero) {
        super(numero);
    }


    public void actionVent(Pirate joueur1) {
        int positionJoueur1 = joueur1.getPosition() ;
        if ( positionJoueur1<= 20) {
            joueur1.setPosition(positionJoueur1 + 10);
        } else {
            joueur1.setPosition(60 - positionJoueur1 - 10);
        }


    }
}
