package com.epidata.prueba.main;

import java.util.concurrent.ThreadLocalRandom;

public class Util {
	
	public int randomRowOrColumn() {
		
		int minValue = 0;
		int maxValue = 7;
		 ThreadLocalRandom tlr = ThreadLocalRandom.current();
		 
		return tlr.nextInt(minValue, maxValue + 1);	
	}

}
