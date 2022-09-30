package com.epidata.prueba.domain;

import java.util.List;

import org.json.simple.JSONObject;

import com.epidata.prueba.db.DataOperation;

public class Product {
	
	private int id;
	private String nombre;
	private String fecha_vencimiento;
	private String fecha_evasado;
	private String lote;
	private String paisOrigen;
	private List<Object> frozenMethod;
	private ProductType productType;
	private ComplementInfo complementIfo;
	
	public Product() {
	}
	
	public Product(int id, String nombre, String fecha_vencimiento, String fecha_evasado, String lote,
			String paisOrigen, List<Object> frozenMethod, ProductType productType, ComplementInfo complementIfo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_vencimiento = fecha_vencimiento;
		this.fecha_evasado = fecha_evasado;
		this.lote = lote;
		this.paisOrigen = paisOrigen;
		this.frozenMethod = frozenMethod;
		this.productType = productType;
		this.complementIfo = complementIfo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_vencimiento() {
		return fecha_vencimiento;
	}

	public void setFecha_vencimiento(String fecha_vencimiento) {
		this.fecha_vencimiento = fecha_vencimiento;
	}

	public String getFecha_evasado() {
		return fecha_evasado;
	}

	public void setFecha_evasado(String fecha_evasado) {
		this.fecha_evasado = fecha_evasado;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

	public List<Object> getFrozenMethod() {
		return frozenMethod;
	}

	public void setFrozenMethod(List<Object> frozenMethod) {
		this.frozenMethod = frozenMethod;
	}

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public ComplementInfo getComplementIfo() {
		return complementIfo;
	}

	public void setComplementIfo(ComplementInfo complementIfo) {
		this.complementIfo = complementIfo;
	}
	
	public JSONObject productInfo(JSONObject data) {
		
		DataOperation dataOperation = new DataOperation();

		if (data.get("request_type").equals("ALL")){
			
			return dataOperation.allProducts(data);
			
		}else if (data.get("request_type").equals("FIND")) {
			
			return dataOperation.findProducts(data);
		}
		
		return null;
	}
	

	
	
	
}
