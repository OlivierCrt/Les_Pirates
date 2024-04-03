package joueur;


public class Pirate {
    private final Nom nom;
    private int vies;
    private int postion;
    private int tourImmobile;

    public Pirate(Nom nom, int vies) {
        this.nom = nom;
        this.vies = vies;
        this.postion = 1;
        this.tourImmobile = 0;
    }

    public Nom getNom() {
        return nom;
    }

    public int getTourImmobile() {
        return tourImmobile;
    }

    public void setTourImmobile(int tourImmobile) {
        this.tourImmobile = tourImmobile;
    }

    public int getPostion() {
        return postion;
    }

    public void setPostion(int positionNouvelle) {
        this.postion = positionNouvelle;
    }

    public int getVies() {

        return vies;
    }

    public void setVies(int vies) {
        this.vies = vies;
    }


}
