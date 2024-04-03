package modeles;

import joueur.Pirate;

public class VentFavorable extends CaseSpeciale {
    protected VentFavorable(int numero) {
        super(numero);
    }


    public void actionVent(Pirate joueur1) {
        if (joueur1.getPostion() <= 20) {
            joueur1.setPostion(joueur1.getPostion() + 10);
        } else {
            joueur1.setPostion(60 - joueur1.getPostion() - 10);
        }


    }
}
