package br.com.quaddro.wsclinica;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

/*
 * Esta classe irá gerenciar o MongoDB no site mLab
 */
public class BancoDados {

	//------------------------------------------------------------------
	//mongodb://<dbuser>:<dbpassword>@ds249418.mlab.com:49418/pdws
	//------------------------------------------------------------------
	private static final String MONGODB_BASE          = "pdws";
	private static final String MONGODB_BASE_USUARIO  = "usuario_pdws";
	private static final String MONGODB_BASE_SENHA    = "pdws_usuario";
	private static final String MONGODB_BASE_ENDERECO = "ds249418.mlab.com";
	private static final String MONGODB_BASE_PORTA    = "49418"; 
		//------------------------------------------------------------------
	private static final String MONGODB_URL = "mongodb" + "://" + 
								MONGODB_BASE_USUARIO    + ":"   +
								MONGODB_BASE_SENHA      + "@"   +
								MONGODB_BASE_ENDERECO   + ":"   +
								MONGODB_BASE_PORTA      + "/"   +
								MONGODB_BASE;
	//------------------------------------------------------------------
	private MongoClient mongoClient;
	private MongoDatabase mongoDatabase;
	//------------------------------------------------------------------
	
	//------------------------------------------------------------------
	//Metodo para conexao com o MongoDB via MongoLab
	//------------------------------------------------------------------
	public MongoDatabase mongoDBOn(){
		
		try {
			
			MongoClientURI mongoClientURI = new MongoClientURI(MONGODB_URL, MongoClientOptions.builder().cursorFinalizerEnabled(false));
			
			mongoClient = new MongoClient(mongoClientURI);
			
			mongoDatabase = mongoClient.getDatabase(MONGODB_BASE);
			
			System.out.println("MongoDB Conectado!");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return mongoDatabase;
	}
	//------------------------------------------------------------------
	//Metodo para desconexao com o MongoDB via MongoLab
	//------------------------------------------------------------------
	public void mongoDBOff(){
		mongoClient.close();
	}

}
