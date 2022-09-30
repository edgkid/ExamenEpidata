package com.epitada.main;

import java.util.ArrayList;
import java.util.List;

import com.epidata.operation.ListOrder;

public class Main {

	public static void main(String[] args) {
		
		ListOrder obj = new ListOrder();
		List<Integer> list = new ArrayList<Integer>();
		
		
		list.add(2);
		list.add(1);
		list.add(4);
		list.add(6);
		list.add(5);
		list.add(3);
		
		System.out.print("Lista Original: ");
		System.out.print(list);
		
		list = obj.newOrder(list);
		System.out.println();
		
		System.out.print("Lista Ordenada: ");
		System.out.print(list);
	}

}
