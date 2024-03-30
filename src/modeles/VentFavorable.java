package modeles;

import joueur.Pirate;

public class VentFavorable extends CaseSpeciale{
    protected VentFavorable(int numero) {
        super(numero);
    }


    public void actionVent(Pirate joueur1) {
        joueur1.setPostion(joueur1.getPostion() +10);


    }
}
