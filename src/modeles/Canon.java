package modeles;
import joueur.Pirate ;
public final class Canon extends CaseSpeciale {



    public Canon(int numero) {

        super(numero);
    }



        public void actionCanon(Pirate joueurActuel , Pirate joueur2){
        int positionJoueurActuel = joueurActuel.getPosition() ;
        int positionJoueur2 = joueur2.getPosition();
        int viesJoueur2 = joueur2.getVies() ;


        if (positionJoueurActuel < positionJoueur2){
            joueurActuel.setPosition(positionJoueur2);
        }
        else{
            joueur2.setTourImmobile(3);
            joueur2.setVies(viesJoueur2-2);
        }





    }



}
