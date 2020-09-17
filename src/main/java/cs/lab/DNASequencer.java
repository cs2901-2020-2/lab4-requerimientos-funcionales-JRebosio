package cs.lab;

import java.util.List;
import java.util.logging.Logger;

public class  DNASequencer {

    static final Logger logger = Logger.getLogger(DNASequencer.class.getName());
    public DNASequencer() {
        logger.info("Starting sequencer...");
    }
   

    public static String scsLength(String first, String second, int m, int n)
    {
        if (m == 0 || n == 0) {
		return first.substring(0,m) + second.substring(0,n);
	}

		
	if (first.charAt(m - 1) == second.charAt(n - 1)) {
		return scsLength(first, second, m - 1, n - 1) + second.charAt(n - 1);
	}

	String resultone = scsLength(first, second, m, n - 1) + second.charAt(n - 1);
	String resulttwo = scsLength(first, second, m - 1, n) + first.charAt(m - 1);
		
	if(resultone.length()> resulttwo.length()) return resulttwo;
	else return resultone;
    }
		
    public String calculate(List<String> part){
	
	String partone=part.get(0);
	String parttwo=part.get(1);
	String partthree=part.get(2);
		
	String tempresult =scsLength(partone, parttwo, partone.length(), parttwo.length());
	
	
	return scsLength(tempresult, partthree, tempresult.length(), partthree.length());
			
    }
}
