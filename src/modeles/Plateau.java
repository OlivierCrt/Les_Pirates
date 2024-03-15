package modeles;
import java.security.SecureRandom;



public class Plateau {
    private CaseSpeciale[] caseSpeciales;


    public Plateau() {
        SecureRandom secureRandom = new SecureRandom();
        caseSpeciales = new CaseSpeciale[6]; // 6 cases d'après le sujet
        int[] valeursDejaGenerees = new int[30]; // Tableau pour stocker les valeurs déjà générées
        int nombreDeValeursUniques = 0;
        while (nombreDeValeursUniques < 6) {
            int randomInt = secureRandom.nextInt(30) + 1; // de 1 à 30
            if (valeursDejaGenerees[randomInt] == 0) {
                valeursDejaGenerees[randomInt] = 1;
                caseSpeciales[nombreDeValeursUniques] = new Canon(randomInt); // Pour l'instant case neutre
                nombreDeValeursUniques++;
            }
        }

    }

    public CaseSpeciale[] getCaseSpeciales() {
        return caseSpeciales;
    }
}
