package modeles;
import joueur.Pirate ;
public final class Canon extends CaseSpeciale {

    public Canon(String action, int numero) {
        super(numero);
    }


    public void actionCanon(Pirate joueurActuel , Pirate joueur2){
        if (joueurActuel.getPostion() < joueur2.getPostion()){
            joueurActuel.setPostion(joueur2.getPostion());//Le joueur actuel rejoint le joueur 2
        }
        else{
            joueur2.setTourImmobile(3);//immobilise le j2 avec un boulet
            joueur2.setVies(joueur2.getVies()-2);
        }




    }
}