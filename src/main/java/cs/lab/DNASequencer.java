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
		
    public String calculate(List<String> parts) throws SubseqLength, ListSize {
	
	String partsone=parts.get(0);
	String partstwo=parts.get(1);
	String partsthree=parts.get(2);

	if(parts.size() > 160000 ) throw new ListSize("Too many subsequences.");
	
	for( String cur : parts ){
		if( cur.length() > 200 ) {
			throw new SubseqLength("Very long subsequence");
		}
					 
	}
	
	String tempresult =scsLength(partsone, partstwo, partsone.length(), partstwo.length());
	
	
	return scsLength(tempresult, partsthree, tempresult.length(), partsthree.length());
			
    }
}
