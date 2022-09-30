package com.epidata.operation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListOrder {

	public List<Integer> newOrder(List<Integer> originalList){
		
		List<Integer>pList = new ArrayList<Integer>();
		List<Integer>iList = new ArrayList<Integer>();
		
		for (int x= 0; x < originalList.size(); x++) {
			
			if (originalList.get(x) % 2 == 0) {
				pList.add(originalList.get(x));
			}else if(originalList.get(x) % 2 == 1) {
				iList.add(originalList.get(x));
			}
			
		}
		
		Collections.sort(pList); 
		Collections.sort(iList); 
		
		List<Integer> rList = new ArrayList<Integer>(iList);
		rList.addAll(pList);
		
		return rList;
	}
	
}
