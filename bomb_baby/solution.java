package com.google.challenges; 
import java.math.BigInteger;

public class Answer {   
	private static BigInteger helper(BigInteger s, BigInteger l) {
		int sCompareToOne = s.compareTo(new BigInteger("1"));

		BigInteger cycle = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		while (sCompareToOne > 0) {

			BigInteger end[] = l.divideAndRemainder(s);

			if (end[1].compareTo(new BigInteger("0")) == 0) {
				return new BigInteger("-1");
			}

			cycle = cycle.add(end[0]);

			l = s;
			s = end[1];

			sCompareToOne = s.compareTo(new BigInteger("1"));		
		}

		//s < 1
		if (sCompareToOne < 0) {
			return new BigInteger("-1");
		}
		// s = 1
		else {
			if (s.compareTo(l) == 0) {
				return cycle.add(one);
			}
			else {
				return cycle.add(l.subtract(new BigInteger("1")));
			}
		}
	}

	public static String answer(String M, String F) {
	    BigInteger bim = new BigInteger(M);
	    BigInteger bif = new BigInteger(F);
	
	    BigInteger s = (bim.compareTo(bif) < 0) ? bim : bif;
	    BigInteger l = (bim.compareTo(bif) > 0) ? bim : bif;

	    BigInteger result = helper(s, l);
		if (result.compareTo(new BigInteger("0")) < 0) {
			return "impossible";
		}
		else {
			return result.toString();
		}
	}

	public static void main(String[] args) {

		System.out.println(answer("455456776324234324536324234423475435", "421"));
	}
}