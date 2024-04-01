package affichage;

import joueur.Pirate;
import modeles.CaseSpeciale;

public interface InterfaceAffichage {
    //attribut
    //methode
    public void afficherDebutPartie();
    public void afficherFinPartie();
    public void afficherResultatDes(int result);

    public void afficherToucheSaisie();
    public void afficherString(String phrase);
    public void touchePress();
    public void afficherApercuPlateau(Pirate[] joueurs);






}
