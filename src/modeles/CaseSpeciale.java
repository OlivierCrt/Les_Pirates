package modeles;



public abstract class CaseSpeciale {
   //attributs
   private final int numero ;
   protected CaseSpeciale(int numero){
      this.numero = numero ;

   }

   //methodes
   public int getNumero() {
      return numero;
   }


}
