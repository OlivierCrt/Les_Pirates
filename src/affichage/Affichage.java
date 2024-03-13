package affichage;
import modeles.CaseSpeciale;
public final class Affichage implements InterfaceAffichage {

    @Override
    public void afficherDebutPartie() {

    }

    @Override
    public void afficherFinPartie() {

    }

    @Override
    public void afficherResultatDes(int result) {
        System.out.println(result);

    }

    @Override
    public void afficherCase(CaseSpeciale c) {



    }

    @Override
    public void afficherToucheSaisie(){
        System.out.println("Appuyez sur une touche pour lancer les dès...");
    }

    @Override
    public void afficherString(String phrase){
        System.out.println(phrase);
    }
}
