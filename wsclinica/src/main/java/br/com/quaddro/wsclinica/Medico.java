package br.com.quaddro.wsclinica;

import java.io.Serializable;

import com.mongodb.BasicDBObject;

public class Medico implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public String _id;
    public String crm;
    public String nome;
    public String celular;

	public Medico(BasicDBObject basicDBObject) {
		
		this._id     = basicDBObject.getObjectId("_id").toString();
		this.crm     = basicDBObject.getString("crm");
		this.nome    = basicDBObject.getString("nome");
		this.celular = basicDBObject.getString("celular");
	}
}
