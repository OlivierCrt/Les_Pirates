package joueur;

import joueur.Nom;

public class Pirate {
    private Nom nom;
    private Integer vies;
    private Integer postion;
    private int tourImmobile ;

    public Pirate(Nom nom, Integer vies) {
        this.nom = nom;
        this.vies = vies;
        this.postion = 1;
        this.tourImmobile = 0 ;
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

    public Integer getPostion() {
        return postion;
    }
    public void setPostion(int positionNouvelle){
        this.postion = positionNouvelle ;
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
    public boolean isImmobile(){
        return(tourImmobile>0);
    }



}
