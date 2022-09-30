package com.epidata.prueba.operation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.epidata.prueba.bd.ShowDataOption;

public class ActivityByTest {

	public void questionFromTestTwo() {
		
		String option = "";
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		System.out.println("******************************************************************");
		System.out.println("Por favor seleccione una opcion a ejecutar del punto # 2 de l aprueba");
		System.out.println("******************************************************************");
		System.out.println("a) Obtener todos los usuarios cuyo nombre tenga al menos una letra a (sea may�scula o min�scula)");
		System.out.println("b) Obtener todos los usuarios cuyo id sea entre 5 y 10.");
		System.out.println("c) Obtener todos los roles de cada usuario, mostrar nombre de usuario, descripci�n y nivel del rol.");
		System.out.println("d) Obtener la cantidad de usuarios que tiene cada rol, ordenados por nivel de menor a mayor.");
		System.out.println("e) Considerando que el nivel indica una jerarqu�a de roles (si hay roles de nivel 0, "
				+ "1, 2, 3 la jerarqu�a mayor ser�a 0; si hay 1, 2, 3 y 4 ser�a 1, etc), obtener todos "
				+ "los usuarios que tengan la mayor jerarqu�a.");
		System.out.print("f) para salir......: ");
		
		String stringValue = "";
		try {
			
			stringValue = br.readLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (stringValue.equals("f")) {
			System.out.println("** Muchas gracias. **");
		}else {
			this.showTestInfo(stringValue);
			this.questionFromTestTwo();
		}
		
	}

	private void showTestInfo(String option) {
		
		ShowDataOption showData = new ShowDataOption();
		
		switch (option) {
			case "a":
				System.out.println("*******************************************");
				System.out.println("Resultados de Opcion A");
				showData.ShowDataOptionA();
				System.out.println("*******************************************");
				break;
			case "b":
				System.out.println("*******************************************");
				System.out.println("Resultados de Opcion B");
				showData.ShowDataOptionB();
				System.out.println("*******************************************");
				break;
			case "c":
				System.out.println("*******************************************");
				System.out.println("Resultados de Opcion C");
				showData.ShowDataOptionC();
				System.out.println("*******************************************");
				break;
			case "d":
				System.out.println("Opcion D");
				System.out.println("*******************************************");
				System.out.println("Resultados de Opcion D");
				showData.ShowDataOptionD();
				System.out.println("*******************************************");
				break;
			case "e":
				System.out.println("*******************************************");
				System.out.println("Resultados de Opcion E");
				showData.ShowDataOptionE();
				System.out.println("*******************************************");
				break;
		default:
			System.out.println("No se selecciono alguna opcion valida....");
			break;
		}
		
	}
}
 