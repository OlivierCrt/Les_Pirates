package modeles;

import joueur.Pirate;

public class VentFavorable extends CaseSpeciale{
    protected VentFavorable(int numero) {
        super(numero);
    }

    @Override
    public Action actionCaseSpeciale(Pirate joueur1, Pirate joueur2) {
        joueur1.setPostion(joueur1.getPostion() +10);
        return Action.VENTFAVORABLE ;


    }
}
