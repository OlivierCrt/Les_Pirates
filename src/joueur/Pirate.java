package joueur;

import joueur.Nom;

public class Pirate {
    private Nom nom;
    private Integer vies;

    public Pirate(Nom nom, Integer vies) {
        this.nom = nom;
        this.vies = vies;
    }
    public Nom getNom() {
        return nom;
    }
    public Integer getVies() {

        return vies;
    }
    public void setNom(Nom nom) {
        this.nom = nom;
    }
    public void setVies(Integer vies) {
        this.vies = vies;
    }



}
