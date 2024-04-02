package modeles;
import java.security.SecureRandom;
public class Des {
    private final int nombreFace ;

    public Des(int nombreFace){
        this.nombreFace = nombreFace;
    }
    public int resultatDes(){
        SecureRandom secureRandom = new SecureRandom();
        return( secureRandom.nextInt(nombreFace)+1);//on met le minimum a 1, statiquement
    }
}
