package com.epidata.prueba.main;

import java.sql.Connection;

import com.epidata.prueba.bd.ConnectionPg;
import com.epidata.prueba.operation.ActivityByTest;

public class Main {

	public static void main(String[] args) {
		
		ActivityByTest activity = new ActivityByTest();
		activity.questionFromTestTwo();
		

	}

}
