package br.com.pizzadigital.pdws.controller;

import java.util.HashMap;

import com.google.gson.Gson;

import spark.Response;
import spark.ResponseTransformer;

//--------------------------------------------------------------
//-- Esta classe será responsável por compactar e descompactar
//-- o JSON do MongoDB em objetos simples
//--------------------------------------------------------------
public class ToJSON implements ResponseTransformer {

	private Gson gson = new Gson();

	//--------------------------------------------------------------
	//-- Método que renderiza o objeto em JSON e vice versa
	//--------------------------------------------------------------
	@Override
	public String render(Object arg0) throws Exception {
		
		if(arg0 instanceof Response) {
			return gson.toJson(new HashMap<>());
		}
		
		return gson.toJson(arg0);
	}
}
