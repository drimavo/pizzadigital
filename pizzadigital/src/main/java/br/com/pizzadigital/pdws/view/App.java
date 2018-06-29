package br.com.pizzadigital.pdws.view;

import static spark.Spark.get;
import static spark.Spark.port;

import com.mongodb.client.MongoDatabase;

import br.com.pizzadigital.pdws.biblioteca.Biblioteca;
import br.com.pizzadigital.pdws.biblioteca.ProdutoHTML;
import br.com.pizzadigital.pdws.controller.MongoDBController;
import br.com.pizzadigital.pdws.resource.ConsumidorResource;
import br.com.pizzadigital.pdws.resource.PedidoResource;
import br.com.pizzadigital.pdws.resource.ProdutoResource;
import br.com.pizzadigital.pdws.service.ConsumidorService;
import br.com.pizzadigital.pdws.service.PedidoService;
import br.com.pizzadigital.pdws.service.ProdutoService;

public class App 
{
    public static void main( String[] args )
    {
    		//-- Definir uma PORTA para a aplicação
    		port(getHerokuPorta());
    		
    		//-- Conexão com o Banco de Dados MongoDB
    		MongoDBController mdbc = new MongoDBController();
		MongoDatabase mongoDatabase = mdbc.mongoDBOn();
		
		//-- Ativando os verbos do Rest para Todo via (get,post,delete)
		ProdutoService produtoService = new ProdutoService(mongoDatabase);
		ProdutoResource produtoResource = new ProdutoResource(produtoService);
		
		ConsumidorService consumidorService 	 = new ConsumidorService(mongoDatabase);
		ConsumidorResource consumidorResource = new ConsumidorResource(consumidorService);
	
		PedidoService pedidoService = new PedidoService(mongoDatabase);
		PedidoResource pedidoResource = new PedidoResource(pedidoService);
		
		//-- Raiz da sua API
		get("/", 		 (request,response) -> ProdutoHTML.welcome());
		get("/catalogo", (request,response) -> ProdutoHTML.listagemProdutos(produtoService));    
    }
    //-------------------------------------------------------------------------
    public static int getHerokuPorta(){
		
		ProcessBuilder processBuilder = new ProcessBuilder();
		
		if(processBuilder.environment().get("PORT") != null){
			return Integer.parseInt(processBuilder.environment().get("PORT"));
		}
		
		return 4567;
	}
    //-------------------------------------------------------------------------
}





