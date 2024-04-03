package modeles;

import joueur.Pirate;

public class VentFavorable extends CaseSpeciale {
    protected VentFavorable(int numero) {
        super(numero);
    }


    public void actionVent(Pirate joueur1) {
        if (joueur1.getPosition() <= 20) {
            joueur1.setPosition(joueur1.getPosition() + 10);
        } else {
            joueur1.setPosition(60 - joueur1.getPosition() - 10);
        }


    }
}
