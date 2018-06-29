package br.com.pizzadigital.pdws.model;

import java.io.Serializable;

public class PedidoItem implements Serializable {

    //-----------------------------------------------------------
    private static final long serialVersionUID = 1L;
    //-----------------------------------------------------------
    
    private String codigo;
    private String item;
    private String tamanho;
    private String corte;
    private Double valor;

    public PedidoItem() { }

	public PedidoItem(String codigo, String item, String tamanho, String corte, Double valor) {
		super();
		this.codigo = codigo;
		this.item = item;
		this.tamanho = tamanho;
		this.corte = corte;
		this.valor = valor;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCorte() {
		return corte;
	}

	public void setCorte(String corte) {
		this.corte = corte;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
