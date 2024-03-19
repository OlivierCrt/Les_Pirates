package modeles;
import joueur.Pirate ;



public abstract class CaseSpeciale {
   //attributs
   private int numero ;
   protected CaseSpeciale(int numero){
      this.numero = numero ;

   }

   //methodes
   public int getNumero() {
      return numero;
   }
   public abstract Action actionCaseSpeciale(Pirate joueur1,Pirate joueur2);


}
