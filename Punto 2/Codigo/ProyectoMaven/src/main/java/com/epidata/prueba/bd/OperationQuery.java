package com.epidata.prueba.bd;

public class OperationQuery {
	
	public String getQueryOptionA () {
		
		String value = "	SELECT usu.id as id,	"
						+ "		usu.nombre as usuario	"
						+ "	FROM USUARIO usu	"
						+ "	WHERE upper(nombre) like upper('%a%'); ";
		
		return value;
	}
	
	public String getQueryOptionB () {
		
		String value = "	SELECT usu.id as id, "
						+ "		usu.nombre as usuario "
						+ "	FROM USUARIO usu "
						+ "	WHERE usu.id >= 5  "
						+ "		AND usu.id <= 10;";
		
		return value;
	}

	public String getQueryOptionC () {
		
		String value = "	SELECT usu.id as id_usuario, "
						+ "		usu.nombre as usuario, "
						+ "		ro.descripcion as rol, "
						+ "		ro.nivel as nivel "
						+ "	FROM usuario usu, "
						+ "		usuario_rol uso, "
						+ "		rol ro "
						+ "	WHERE usu.id = uso.id_usuario "
						+ "		AND uso.id_rol = ro.id";
		
		return value;
	}
	
	public String getQueryOptionD () {
		
		String value = "	SELECT ro.id as id,  "
					+ "			ro.descripcion as rol, "
					+ "			(	SELECT count(r.id_usuario)  "
					+ "				FROM usuario_rol r "
					+ "				WHERE r.id_rol = ro.id) as total "
					+ "		FROM rol ro; ";
		
		return value;
	}
	
	public String getQueryOptionE () {
		
		String value = "	SELECT usu.id as id_usuario, "
						+ "		usu.nombre as usuario, "
						+ "		ro.descripcion as rol, "
						+ "		ro.nivel as nivel "
						+ "	FROM usuario usu, "
						+ "		usuario_rol uso, "
						+ "		rol ro "
						+ "	WHERE usu.id = uso.id_usuario "
						+ "		AND uso.id_rol = ro.id "
						+ "		AND uso.id_rol = (	SELECT id  "
						+ "					  		FROM rol  "
						+ "					  		WHERE nivel = (SELECT min(nivel) FROM rol) );";
		
		return value;
	}


}
