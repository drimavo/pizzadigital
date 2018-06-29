package br.com.pizzadigital.pdws.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;

import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

    //-----------------------------------------------------------
    private static final long serialVersionUID = 1L;
    //-----------------------------------------------------------

    private String _id;
    private String celular; // "id do cliente"
    private String nome;
    private ArrayList<PedidoItem> itens; // "pizzas por pedido"
    private String dataPedido; // "data e hora gerada do pedido"

    public Pedido() { }

    public Pedido(String celular, String nome, ArrayList<PedidoItem> itens, String dataPedido) {

        this.celular = celular;
        this.nome = nome;
        this.itens = itens;
        this.dataPedido = dataPedido;
    }

	public Pedido(BasicDBObject basicDBObject) {
		
		this._id        = basicDBObject.getObjectId("_id").toString();
		
		this.nome       = basicDBObject.getString("nome");
		this.celular    = basicDBObject.getString("celular");
		this.itens      = (ArrayList<PedidoItem>) basicDBObject.get("itens");
		this.dataPedido = basicDBObject.getString("dataPedido");
	}
    
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public ArrayList<PedidoItem> getItens() {
		return itens;
	}

	public void setItens(ArrayList<PedidoItem> itens) {
		this.itens = itens;
	}

	public String getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
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
