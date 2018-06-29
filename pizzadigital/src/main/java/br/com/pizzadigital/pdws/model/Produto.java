package br.com.pizzadigital.pdws.model;

import java.io.Serializable;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

public class Produto implements Serializable {

	//-----------------------------------------------------------
	private static final long serialVersionUID = 1L;
	//-----------------------------------------------------------
	private String  _id;
	private String codigo;
	private String nom_imagem;
	private String b64_imagem;
	private String titulo;
	private String receita;
	private Double pequena;
	private Double media;
	private Double grande;
	
	public Produto() {}
	

	public Produto(String codigo, String nom_imagem, String b64_imagem, String titulo, String receita, Double pequena, Double media,
			Double grande) {
		
		this.codigo = codigo;
		this.nom_imagem = nom_imagem;
		this.b64_imagem = b64_imagem;
		this.titulo = titulo;
		this.receita = receita;
		this.pequena = pequena;
		this.media = media;
		this.grande = grande;
	}

	
	public Produto(BasicDBObject basicDBObject) {
		
		this._id        = basicDBObject.getObjectId("_id").toString();
		
		this.codigo = basicDBObject.getString("codigo");
		this.nom_imagem = basicDBObject.getString("nom_imagem");
		this.b64_imagem = basicDBObject.getString("b64_imagem");
		this.titulo = basicDBObject.getString("titulo");
		this.receita = basicDBObject.getString("receita");
		this.pequena = basicDBObject.getDouble("pequena");
		this.media = basicDBObject.getDouble("media");
		this.grande = basicDBObject.getDouble("grande");

	}
	
	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public String getNom_imagem() {
		return nom_imagem;
	}


	public void setNom_imagem(String nom_imagem) {
		this.nom_imagem = nom_imagem;
	}


	public String getB64_imagem() {
		return b64_imagem;
	}


	public void setB64_imagem(String b64_imagem) {
		this.b64_imagem = b64_imagem;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getReceita() {
		return receita;
	}


	public void setReceita(String receita) {
		this.receita = receita;
	}


	public Double getPequena() {
		return pequena;
	}


	public void setPequena(Double pequena) {
		this.pequena = pequena;
	}


	public Double getMedia() {
		return media;
	}


	public void setMedia(Double media) {
		this.media = media;
	}


	public Double getGrande() {
		return grande;
	}


	public void setGrande(Double grande) {
		this.grande = grande;
	}


	public String get_id() {
		return _id;
	}


	public void set_id(String _id) {
		this._id = _id;
	}


	public String toJSON() {	
		Gson gson = new Gson();
		return gson.toJson(this); 
	}
	
	@Override
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this); 
	}
}