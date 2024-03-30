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


}
