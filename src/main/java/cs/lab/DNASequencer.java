package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }
   

    public static String SCSLength(String X, String Y, int m, int n)
    {
        if (m == 0 || n == 0) {
		return X.substring(0,m) + Y.substring(0,n);
	}

		
	if (X.charAt(m - 1) == Y.charAt(n - 1)) {
		return SCSLength(X, Y, m - 1, n - 1) + Y.charAt(n - 1);
	}

	String a = SCSLength(X, Y, m, n - 1) + Y.charAt(n - 1);
	String b = SCSLength(X, Y, m - 1, n) + X.charAt(m - 1);
		
	if(a.length()> b.length()) return b;
	else return a;
    }
		
    public String calculate(List<String> part){
	
	String X=part.get(0);
	String Y=part.get(1);
	String Z=part.get(2);
		
	String R1=SCSLength(X, Y, X.length(), Y.length());
	String R2=SCSLength(R1, Z, R1.length(), Z.length());
		
	return R2;	
    }
}
