package br.com.pizzadigital.pdws.resource;

//-- Posicionando no pacote com verbos do HTTP
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import br.com.pizzadigital.pdws.controller.ToJSON;
import br.com.pizzadigital.pdws.service.PedidoService;
import br.com.pizzadigital.pdws.service.ProdutoService;

/*
 * Gerenciar os verbos ligados a classe modelo "Produto"
 * Verbos principais: get, put, delete, post
 */
public class PedidoResource {

	//----------------------------------------------------------------------------------
	//-- Objeto de comunicação do CRUD com o MongoDB
	//----------------------------------------------------------------------------------
	private PedidoService pedidoService;
	//----------------------------------------------------------------------------------
	public PedidoResource(PedidoService pedidoService) {
		this.pedidoService = pedidoService;
		verbos();
	}
	//----------------------------------------------------------------------------------
	private void verbos() {
		
		//----------------------------------------------------------------------------------
		//-- Desenvolver as rotinas com os verbos		
		//----------------------------------------------------------------------------------
		//-- Retornar todos os registros
		//----------------------------------------------------------------------------------
		get("/pedidos", "application/json" , (request , response) ->
			
			pedidoService.all(), new ToJSON()
		);
		//----------------------------------------------------------------------------------
		//-- Retornar 1 registro
		//----------------------------------------------------------------------------------
		get("/pedidos/:id", "application/json" , (request , response) ->
		
			pedidoService.get(request.params(":id")), new ToJSON()
		);		
		//----------------------------------------------------------------------------------
		//-- Exclusão
		//----------------------------------------------------------------------------------
		delete("/pedidos/:id", "application/json" , (request , response) ->
		{
			pedidoService.del(request.params(":id"));
			response.status(200);
			return response;
		
		}, new ToJSON());
		//----------------------------------------------------------------------------------
		//-- Inserção
		//----------------------------------------------------------------------------------
		post("/pedidos", "application/json" , (request , response) ->
		{
			pedidoService.ins(request.body());
			response.status(200);
			return response;
		
		}, new ToJSON());	
		//----------------------------------------------------------------------------------
	}
	//----------------------------------------------------------------------------------
}
