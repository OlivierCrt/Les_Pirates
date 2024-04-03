package joueur;


public class Pirate {
    private final Nom nom;
    private int vies;
    private int position;
    private int tourImmobile;

    public Pirate(Nom nom, int vies) {
        this.nom = nom;
        this.vies = vies;
        this.position = 1;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int positionNouvelle) {
        this.position = positionNouvelle;
    }

    public int getVies() {

        return vies;
    }

    public void setVies(int vies) {
        this.vies = vies;
    }


}
