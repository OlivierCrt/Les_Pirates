package test_fonctionnels;

import modeles.Plateau;

public class TestPlateau {
    public static void main(String[] args) {
        // Créer une instance de Plateau
        Plateau plateau = new Plateau();

        // Afficher les valeurs des cases spéciales
        for (int i = 0; i < plateau.getCaseSpeciales().length; i++) {
            System.out.println("Case " + (i + 1) + ": " + plateau.getCaseSpeciales()[i]);
        }
    }
}

