package br.com.pizzadigital.pdws.resource;

//-- Posicionando no pacote com verbos do HTTP
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;

import br.com.pizzadigital.pdws.controller.ToJSON;
import br.com.pizzadigital.pdws.service.ConsumidorService;

/*
* Gerenciar os verbos ligados a classe modelo "Produto"
* Verbos principais: get, put, delete, post
*/
public class ConsumidorResource {

	//----------------------------------------------------------------------------------
	//-- Objeto de comunicação do CRUD com o MongoDB
	//----------------------------------------------------------------------------------
	private ConsumidorService consumidorService;
	//----------------------------------------------------------------------------------
	public ConsumidorResource(ConsumidorService consumidorService) {
		this.consumidorService = consumidorService;
		verbos();
	}
	//----------------------------------------------------------------------------------
	private void verbos() {
		
		//----------------------------------------------------------------------------------
		//-- Desenvolver as rotinas com os verbos		
		//----------------------------------------------------------------------------------
		//-- Retornar todos os registros
		//----------------------------------------------------------------------------------
		get("/consumidores", "application/json" , (request , response) ->
			
			consumidorService.all(), new ToJSON()
		);
		//----------------------------------------------------------------------------------
		//-- Retornar 1 registro
		//----------------------------------------------------------------------------------
		get("/consumidores/:id", "application/json" , (request , response) ->
		
			consumidorService.get(request.params(":id")), new ToJSON()
		);		
		//----------------------------------------------------------------------------------
		//-- Exclusão
		//----------------------------------------------------------------------------------
		delete("/consumidores/:id", "application/json" , (request , response) ->
		{
			consumidorService.del(request.params(":id"));
			response.status(200);
			return response;
		
		}, new ToJSON());
		//----------------------------------------------------------------------------------
		//-- Inserção
		//----------------------------------------------------------------------------------
		post("/consumidores", "application/json" , (request , response) ->
		{
			consumidorService.ins(request.body());
			response.status(200);
			return response;
		
		}, new ToJSON());	
		//----------------------------------------------------------------------------------
	}
	//----------------------------------------------------------------------------------
}
