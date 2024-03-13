package modeles;



public class Plateau {
    private Case[] cases;


    public Plateau() {

        cases = new Case[30];
        for (int i = 0; i < 30; i++) {
            cases[i] = new CaseSpeciale(); // Pour l'instant case neutres
        }
    }


}
