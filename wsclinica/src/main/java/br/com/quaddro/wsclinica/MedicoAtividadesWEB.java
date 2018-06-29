package br.com.quaddro.wsclinica;

//-- Posicionando no pacote com verbos do HTTP
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

/*
 * Gerenciar os verbos ligados a classe modelo "Medico"
 * Verbos principais: get, put, delete, post
 */
public class MedicoAtividadesWEB {

	private MedicoAtividadesBD medicoAtividadesBD;
	//----------------------------------------------------------------------------------
	public MedicoAtividadesWEB(MedicoAtividadesBD medicoAtividadesBD) {
		this.medicoAtividadesBD = medicoAtividadesBD;
		verbos();
	}
	//----------------------------------------------------------------------------------
	private void verbos() {
		
		//----------------------------------------------------------------------------------
		//-- Desenvolver as rotinas com os verbos		
		//----------------------------------------------------------------------------------
		//-- Retornar todos os registros
		//----------------------------------------------------------------------------------
		get("/medicos", "application/json" , (request , response) ->
			
			medicoAtividadesBD.all(), new ConversorJSON()
		);
		//----------------------------------------------------------------------------------
		//-- Retornar 1 registro
		//----------------------------------------------------------------------------------
		get("/medicos/:id", "application/json" , (request , response) ->
		
			medicoAtividadesBD.get(request.params(":id")), new ConversorJSON()
		);		
		//----------------------------------------------------------------------------------
		//-- Exclusão de 1 registro
		//----------------------------------------------------------------------------------
		delete("/medicos/:id", "application/json" , (request , response) ->
		{
			medicoAtividadesBD.del(request.params(":id"));
			response.status(200);
			return response;
		
		}, new ConversorJSON());
		//----------------------------------------------------------------------------------
		//-- Inserção de 1 registro
		//----------------------------------------------------------------------------------
		post("/medicos", "application/json" , (request , response) ->
		{
			medicoAtividadesBD.ins(request.body());
			response.status(200);
			return response;
		
		}, new ConversorJSON());	
		//----------------------------------------------------------------------------------
		//-- Atualização de 1 registro
		//----------------------------------------------------------------------------------
		put("/medicos", "application/json" , (request , response) ->
		{
			medicoAtividadesBD.upd(request.body());
			response.status(200);
			return response;
		
		}, new ConversorJSON());	
		//----------------------------------------------------------------------------------
	}
	//----------------------------------------------------------------------------------
}
