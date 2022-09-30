package com.epidata.prueba.db;

public class OperationQuery {
	
	public String findProducts() {
		
		String value = "	SELECT pr.id as id,  "
						+ "		pr.nombre as nombre,  "
						+ "		pr.fecha_caducidad as  f_caducidad,  "
						+ "		pr.fecha_envasado as f_envasado,  "
						+ "		pr.numero_lote as lote,  "
						+ "		pr.pais_origen as pais_origen,  "
						+ "		tp.nombre as tipo  "
						+ "	FROM PRODUCTO pr,  "
						+ "		TIPO_PRODUCTO tp  "
						+ "	WHERE pr.id_tipo_producto = tp.id  "
						+ "		AND (  "
						+ "			pr.id = ? OR  "
						+ "			upper(pr.nombre) LIKE upper(?) OR  "
						+ "			pr.numero_lote = ? OR  "
						+ "			pr.pais_origen = ? OR  "
						+ "			upper(tp.nombre) = upper(?)  "
						+ "	);  ";
		
		return value;
	}
	
	public String allProducts() {
		
		String value = "	SELECT pr.id as id,  "
						+ "		pr.nombre as nombre,  "
						+ "		pr.fecha_caducidad as  f_caducidad,  "
						+ "		pr.fecha_envasado as f_envasado,  "
						+ "		pr.numero_lote as lote,  "
						+ "		pr.pais_origen as pais_origen,  "
						+ "		tp.nombre as tipo"
						+ "	FROM PRODUCTO pr,  "
						+ "		TIPO_PRODUCTO tp  "
						+ "	WHERE pr.id_tipo_producto = tp.id limit ? offset ? ;";
		
		return value;
	}
	
	public String findProductComplementInfo() {
		
		String value = "	SELECT id as id,  "
						+ "		codigo_organizmo as cdg_org,  "
						+ "		temperatura_recomendada as temp_re  "
						+ "	FROM INFORMACION_COMPLEMENTO   "
						+ "	WHERE id_producto = ? ;";
		
		return value;
	}
	
	public String findInfoMetodoAgua() {
		
		String value = "	SELECT ma.id as id,  "
						+ "		ma.gr_sal as sal,  "
						+ "		ma.lts_agua as agua  "
						+ "	FROM PRODUCTO_CONGELADO pc,  "
						+ "		METODO_AGUA ma  "
						+ "	WHERE pc.id_metodo_agua = ma.id	  "
						+ "		AND pc.id_producto = ? ;";
		
		return value;
	}
	
	public String findInfoMetodoNitro() {
		
		String value = "	SELECT mn.id as id,  "
						+ "		mn.metodo as metodo,  "
						+ "		mn.tiempo_exp as t_exp  "
						+ "	FROM PRODUCTO_CONGELADO pc,  "
						+ "		METODO_NITRO mn  "
						+ "	WHERE pc.id_metodo_nitro = mn.id	  "
						+ "		AND pc.id_producto = ? ;";
		
		return value;
	}
	
	public String findInfoMetodoAire() {
		
		String value = "	SELECT ma.id as id,  "
						+ "		ma.prc_nitro as nitro,  "
						+ "		ma.prc_oxigeno as agua,  "
						+ "		ma.prc_carbon as carbon,  "
						+ "		ma.prc_vapor as vapor  "
						+ "	FROM PRODUCTO_CONGELADO pc,  "
						+ "		METODO_AIRE ma  "
						+ "	WHERE pc.id_metodo_agua = ma.id	  "
						+ "		AND pc.id_producto = ? ;";
		
		return value;
	}

}
