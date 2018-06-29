package br.com.quaddro.wsclinica;

import static spark.Spark.port;
import static spark.Spark.get;
import com.mongodb.client.MongoDatabase;

public class App 
{
    public static void main( String[] args )
    {
		//-- Definir uma PORTA para a aplicação
		port(getHerokuPorta());
		
		//-- Conexão com o Banco de Dados MongoDB
		BancoDados bancoDados = new BancoDados();
	    MongoDatabase mongoDatabase = bancoDados.mongoDBOn();
		
		//-- Ativando os verbos do Rest para Todo via (get,post,delete)
	    MedicoAtividadesBD medicoAtividadesBD = new MedicoAtividadesBD(mongoDatabase);
		new MedicoAtividadesWEB(medicoAtividadesBD);
		
		
		//-- Raiz da sua API
		String aviso = "<html><body><center><br><br><br><hr><br><font face=verdana size=3>webservice klinika ativado!<br><br><hr>";
		get("/", 		 (request,response) -> aviso);
		  
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
