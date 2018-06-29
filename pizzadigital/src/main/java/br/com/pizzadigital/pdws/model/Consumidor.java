package br.com.pizzadigital.pdws.model;

import java.io.Serializable;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

public class Consumidor implements Serializable {

	//-----------------------------------------------------------
	private static final long serialVersionUID = 1L;
	//-----------------------------------------------------------
	private String  _id;
	private String nome;
	private String email;
	private String senha;
	private String celular;

	public Consumidor() {}

	public Consumidor(String _id, String nome, String email, String senha, String celular) {
		this._id = _id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
	}

	public Consumidor(String nome, String email, String senha, String celular) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.celular = celular;
	}

	public Consumidor(BasicDBObject basicDBObject) {
		
		this._id     = basicDBObject.getObjectId("_id").toString();
		
		this.nome    = basicDBObject.getString("nome");
		this.email   = basicDBObject.getString("email");
		this.senha   = basicDBObject.getString("senha");
		this.celular = basicDBObject.getString("celular");
	
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
    //----------------------------------------------------------
}