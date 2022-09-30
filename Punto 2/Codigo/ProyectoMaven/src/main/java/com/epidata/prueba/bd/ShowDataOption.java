package com.epidata.prueba.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShowDataOption {

		public void ShowDataOptionA() {
			
			Connection conn = new ConnectionPg().dbConnection();
			OperationQuery operationQuery = new OperationQuery();
			
			try {
				
				PreparedStatement query = conn.prepareStatement(operationQuery.getQueryOptionA());
				ResultSet result = query.executeQuery();
				
				while (result.next()) {
					
					System.out.println("id: " + result.getString("id") + " " + "usuario: " + result.getString("usuario"));
				}
				
				conn.close();
			} catch (SQLException e) {
				
				System.out.println("Ocurrio un problema al connectar co la BD");
				e.printStackTrace();
			}
			
		}
		
		public void ShowDataOptionB() {
			
			Connection conn = new ConnectionPg().dbConnection();
			OperationQuery operationQuery = new OperationQuery();
			
			try {
				
				PreparedStatement query = conn.prepareStatement(operationQuery.getQueryOptionB());
				ResultSet result = query.executeQuery();
				
				while (result.next()) {
					
					System.out.println("id: " + result.getString("id") + " " + "usuario: " + result.getString("usuario"));
				}
				
				conn.close();
			} catch (SQLException e) {
				
				System.out.println("Ocurrio un problema al connectar co la BD");
				e.printStackTrace();
			}
			
		}
		
		public void ShowDataOptionC() {
			
			Connection conn = new ConnectionPg().dbConnection();
			OperationQuery operationQuery = new OperationQuery();
			
			try {
				
				PreparedStatement query = conn.prepareStatement(operationQuery.getQueryOptionC());
				ResultSet result = query.executeQuery();
				
				while (result.next()) {
					
					System.out.println("id: " + result.getString("id_usuario") + " " 
									+ "usuario: " + result.getString("usuario") + " "
									+ "rol: " + result.getString("rol") + " " 
									+ "nivel: " + result.getString("nivel"));
				}
				
				conn.close();
			} catch (SQLException e) {
				
				System.out.println("Ocurrio un problema al connectar co la BD");
				e.printStackTrace();
			}
			
		}
		
		public void ShowDataOptionD() {
			
			Connection conn = new ConnectionPg().dbConnection();
			OperationQuery operationQuery = new OperationQuery();
			
			try {
				
				PreparedStatement query = conn.prepareStatement(operationQuery.getQueryOptionD());
				ResultSet result = query.executeQuery();
				
				while (result.next()) {
					
					System.out.println("id: " + result.getString("id") + " " 
							+ "rol: " + result.getString("rol") + " " 
							+ "total: " + result.getString("total"));
				}
				
				conn.close();
			} catch (SQLException e) {
				
				System.out.println("Ocurrio un problema al connectar co la BD");
				e.printStackTrace();
			}
			
		}
		
		public void ShowDataOptionE() {
			
			Connection conn = new ConnectionPg().dbConnection();
			OperationQuery operationQuery = new OperationQuery();
			
			try {
				
				PreparedStatement query = conn.prepareStatement(operationQuery.getQueryOptionE());
				ResultSet result = query.executeQuery();
				
				while (result.next()) {
					
					System.out.println("id: " + result.getString("id_usuario") + " " 
							+ "rol: " + result.getString("rol") + " "
							+ "nivel: " + result.getString("nivel"));
				}
				
				conn.close();
			} catch (SQLException e) {
				
				System.out.println("Ocurrio un problema al connectar co la BD");
				e.printStackTrace();
			}
			
		}
}
