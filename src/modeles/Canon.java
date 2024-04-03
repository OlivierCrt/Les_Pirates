package modeles;
import joueur.Pirate ;
public final class Canon extends CaseSpeciale {



    public Canon(int numero) {

        super(numero);
    }



        public void actionCanon(Pirate joueurActuel , Pirate joueur2){

        if (joueurActuel.getPosition() < joueur2.getPosition()){
            joueurActuel.setPosition(joueur2.getPosition());//Le joueur actuel rejoint le joueur 2
        }
        else{
            joueur2.setTourImmobile(3);//immobilise le j2 avec un boulet
            joueur2.setVies(joueur2.getVies()-2);
        }





    }



}
