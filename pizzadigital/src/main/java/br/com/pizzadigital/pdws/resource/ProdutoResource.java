package br.com.pizzadigital.pdws.resource;

//-- Posicionando no pacote com verbos do HTTP
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import br.com.pizzadigital.pdws.controller.ToJSON;
import br.com.pizzadigital.pdws.service.ProdutoService;

/*
 * Gerenciar os verbos ligados a classe modelo "Produto"
 * Verbos principais: get, put, delete, post
 */
public class ProdutoResource {

	//----------------------------------------------------------------------------------
	//-- Objeto de comunicação do CRUD com o MongoDB
	//----------------------------------------------------------------------------------
	private ProdutoService produtoService;
	//----------------------------------------------------------------------------------
	public ProdutoResource(ProdutoService produtoService) {
		this.produtoService = produtoService;
		verbos();
	}
	//----------------------------------------------------------------------------------
	private void verbos() {
		
		//----------------------------------------------------------------------------------
		//-- Desenvolver as rotinas com os verbos		
		//----------------------------------------------------------------------------------
		//-- Retornar todos os registros
		//----------------------------------------------------------------------------------
		get("/produtos", "application/json" , (request , response) ->
			
			produtoService.all(), new ToJSON()
		);
		//----------------------------------------------------------------------------------
		//-- Retornar 1 registro
		//----------------------------------------------------------------------------------
		get("/produtos/:id", "application/json" , (request , response) ->
		
			produtoService.get(request.params(":id")), new ToJSON()
		);		
		//----------------------------------------------------------------------------------
		//-- Exclusão
		//----------------------------------------------------------------------------------
		delete("/produtos/:id", "application/json" , (request , response) ->
		{
			produtoService.del(request.params(":id"));
			response.status(200);
			return response;
		
		}, new ToJSON());
		//----------------------------------------------------------------------------------
		//-- Inserção
		//----------------------------------------------------------------------------------
		post("/produtos", "application/json" , (request , response) ->
		{
			produtoService.ins(request.body());
			response.status(200);
			return response;
		
		}, new ToJSON());	
		//----------------------------------------------------------------------------------
	}
	//----------------------------------------------------------------------------------
}
