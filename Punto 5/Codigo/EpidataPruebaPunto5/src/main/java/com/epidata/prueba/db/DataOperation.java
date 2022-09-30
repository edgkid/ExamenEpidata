package com.epidata.prueba.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataOperation {
	
	public JSONObject allProducts(JSONObject data) {
		
		JSONObject resp = new JSONObject();
		JSONObject product = null;
		List<JSONObject> productList = new JSONArray();
		
		
		Connection conn = new ConnectionPg().dbConnection();
		OperationQuery operationQuery = new OperationQuery();
		
		try {
			
			PreparedStatement query = conn.prepareStatement(operationQuery.allProducts());
			query.setInt(1, Integer.valueOf((String) data.get("limit")) );
			query.setInt(2, Integer.valueOf((String) data.get("offset")));
			ResultSet result = query.executeQuery();

			while (result.next()) {
				
				product = new JSONObject();
				
				product.put("id", result.getString("id"));
				product.put("nombre", result.getString("nombre"));
				product.put("caducidad", result.getString("f_caducidad"));
				product.put("envasado", result.getString("f_envasado"));
				product.put("lote", result.getString("lote"));
				product.put("pais", result.getString("pais_origen"));
				product.put("tipo", result.getString("tipo"));
				
				product.put("info", this.findComlementInfo(Integer.valueOf(result.getString("id"))));
				
				if(result.getString("tipo").equals("Congelado")) {
					
					product.put("info_metodo_nitro", this.findMethodNitro(Integer.valueOf(result.getString("id"))));
					product.put("tipo_metodo_aire", this.findMethodAire(Integer.valueOf(result.getString("id"))));
					product.put("tipo_metodo_agua", this.findMethodAgua(Integer.valueOf(result.getString("id"))));
				}else {
					product.put("info_metodo_nitro", new ArrayList());
					product.put("tipo_metodo_aire", new ArrayList());
					product.put("tipo_metodo_agua", new ArrayList());
				}
				
				productList.add(product);
				
			}
			
			resp.put("R", "0");
			resp.put("productos", productList);
			
			conn.close();
		} catch (SQLException e) {
			
			resp.put("R", "1");
			resp.put("productos", productList);
			System.out.println("Ocurrio un problema al connectar co la BD");
			e.printStackTrace();
		}
		
		return resp;
	}
	
	public JSONObject findProducts(JSONObject data) {
		
		JSONObject resp = new JSONObject();
		JSONObject product = null;
		
		
		Connection conn = new ConnectionPg().dbConnection();
		OperationQuery operationQuery = new OperationQuery();
		
		try {
			
			PreparedStatement query = conn.prepareStatement(operationQuery.findProducts());
			query.setInt(1, Integer.valueOf((String) data.get("filter")) );
			query.setString(2, "%" +(String) data.get("filter"));
			query.setString(3, (String) data.get("filter"));
			query.setString(4, (String) data.get("filter"));
			query.setString(5, (String) data.get("filter"));
			ResultSet result = query.executeQuery();
			
			while (result.next()) {
				
				product = new JSONObject();
				
				product.put("id", result.getString("id"));
				product.put("nombre", result.getString("nombre"));
				product.put("caducidad", result.getString("f_caducidad"));
				product.put("envasado", result.getString("f_envasado"));
				product.put("lote", result.getString("lote"));
				product.put("pais", result.getString("pais_origen"));
				product.put("tipo", result.getString("tipo"));
				
				product.put("info", this.findComlementInfo(Integer.valueOf(result.getString("id"))));
				
				if(result.getString("tipo").equals("Congelado")) {
					
					product.put("info_metodo_nitro", this.findMethodNitro(Integer.valueOf(result.getString("id"))));
					product.put("tipo_metodo_aire", this.findMethodAire(Integer.valueOf(result.getString("id"))));
					product.put("tipo_metodo_agua", this.findMethodAgua(Integer.valueOf(result.getString("id"))));
				}else {
					product.put("info_metodo_nitro", new ArrayList());
					product.put("tipo_metodo_aire", new ArrayList());
					product.put("tipo_metodo_agua", new ArrayList());
				}
				
				
			}
			
			resp.put("R", "0");
			resp.put("producto", product);
			
			conn.close();
		} catch (SQLException e) {
			
			resp.put("R", "1");
			resp.put("producto", product);
			System.out.println("Ocurrio un problema al connectar co la BD");
			e.printStackTrace();
		}
		
		return resp;
	}
	
	private List<JSONObject> findMethodNitro (int productId) {
		
		JSONObject info = null;
		List<JSONObject> infoList = new JSONArray();
		
		
		Connection conn = new ConnectionPg().dbConnection();
		OperationQuery operationQuery = new OperationQuery();
		
		try {
			
			PreparedStatement query = conn.prepareStatement(operationQuery.findInfoMetodoNitro());
			query.setInt(1, productId);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				
				info = new JSONObject();
				
				info.put("id", result.getString("id"));
				info.put("metodo", result.getString("metodo"));
				info.put("t_exp", result.getString("t_exp"));
				
				infoList.add(info);
				
			}
			
			conn.close();
		} catch (SQLException e) {
			
			System.out.println("Ocurrio un problema al connectar co la BD");
			e.printStackTrace();
		}
		
		return infoList;
		
	}
	
	private List<JSONObject> findMethodAgua (int productId) {
		
		JSONObject info = null;
		List<JSONObject> infoList = new JSONArray();
		
		
		Connection conn = new ConnectionPg().dbConnection();
		OperationQuery operationQuery = new OperationQuery();
		
		try {
			
			PreparedStatement query = conn.prepareStatement(operationQuery.findInfoMetodoAgua());
			query.setInt(1, productId);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				
				info = new JSONObject();
				
				info.put("id", result.getString("id"));
				info.put("gr_sal", result.getString("sal"));
				info.put("lts_agua", result.getString("agua"));
				
				infoList.add(info);
				
			}
			
			conn.close();
		} catch (SQLException e) {
			
			System.out.println("Ocurrio un problema al connectar co la BD");
			e.printStackTrace();
		}
		
		return infoList;
		
	}
	
	private List<JSONObject> findMethodAire (int productId) {
		
		JSONObject info = null;
		List<JSONObject> infoList = new JSONArray();
		
		
		Connection conn = new ConnectionPg().dbConnection();
		OperationQuery operationQuery = new OperationQuery();
		
		try {
			
			PreparedStatement query = conn.prepareStatement(operationQuery.findInfoMetodoAire());
			query.setInt(1, productId);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				
				info = new JSONObject();
				
				info.put("id", result.getString("id"));
				info.put("p_nitro", result.getString("nitro"));
				info.put("p_agua", result.getString("agua"));
				info.put("p_vapor", result.getString("vapor"));
				info.put("p_carbon", result.getString("carbon"));
				
				
				infoList.add(info);
				
			}
			
			conn.close();
		} catch (SQLException e) {
			
			System.out.println("Ocurrio un problema al connectar co la BD");
			e.printStackTrace();
		}
		
		return infoList;
		
	}
	
	private List<JSONObject> findComlementInfo(int productId) {
		
		JSONObject info = null;
		List<JSONObject> infoList = new JSONArray();
		
		
		Connection conn = new ConnectionPg().dbConnection();
		OperationQuery operationQuery = new OperationQuery();
		
		try {
			
			PreparedStatement query = conn.prepareStatement(operationQuery.findProductComplementInfo());
			query.setInt(1, productId);
			ResultSet result = query.executeQuery();

			while (result.next()) {
				
				info = new JSONObject();
				info.put("id", result.getString("id"));
				info.put("cdg_org", result.getString("cdg_org"));
				info.put("temp_re", result.getString("temp_re"));
				
				infoList.add(info);
				
			}
			
			conn.close();
		} catch (SQLException e) {
			
			System.out.println("Ocurrio un problema al connectar co la BD");
			e.printStackTrace();
		}
		
		return infoList;
		
	}

}
