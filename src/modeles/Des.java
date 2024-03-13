package modeles;
import java.security.SecureRandom;
public class Des {
    private Integer nombreFace ;

    public Des(int nombreFace){
        this.nombreFace = nombreFace;
    }
    public Integer resultatDes(){
        SecureRandom secureRandom = new SecureRandom();
        return( secureRandom.nextInt(nombreFace)+1);//on met le minimum a 1, statiquement
    }
}
