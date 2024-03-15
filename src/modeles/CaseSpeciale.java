package modeles;

import joueur.Pirate;

public abstract class CaseSpeciale {
   //attributs
   private int numero ;
   String nomCase ;
   public CaseSpeciale(int numero,String nomCase){
      this.numero = numero ;
      this.nomCase = nomCase ;
   }

   //methodes
   public Integer getNumero() {
      return numero;
   }

   public String getNomCase() {
      return nomCase;
   }
}
