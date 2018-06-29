package br.com.quaddro.wsclinica;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.util.JSON;

/*
 * Gerenciar os comandos NON-SQL ligados ao MongoDB
 * 
 * Esta classe irá administrar 5 comandos principais:
 * 
 * all() ----> Retornará os registros do Banco de Dados MongoDB
 * get(_id) -> Retornará apenas o registro ligado ao _id do MongoDB
 * ins(json)-> Irá inserir o registro no Banco de Dados MongoDB via JSON
 * del(_id)--> Excluirá o registro do Banco de Dados MongoDB via _id
 * upd(json)-> Atualizará os dados do registro no Banco de Dados MongoDB
 */
public class MedicoAtividadesBD {

	//----------------------------------------------------------------
	private final MongoCollection<BasicDBObject> mongoCollection;
	//----------------------------------------------------------------
	public MedicoAtividadesBD(MongoDatabase mongoDatabase) {
		
		this.mongoCollection = mongoDatabase.getCollection("medicos", BasicDBObject.class);
	}
	//----------------------------------------------------------------
	public List<Medico> all() {
		
		List<Medico> medicos = new ArrayList<Medico>();
		
		MongoCursor<BasicDBObject> mongoCursor = mongoCollection.find().iterator();
		
		while(mongoCursor.hasNext()) {
			medicos.add(new Medico(mongoCursor.next()));
		}
		
		return medicos;
	}
	//----------------------------------------------------------------
	public Medico get(String _id) {
		
		Medico medico;
		
		Bson filtro = Filters.eq("_id", new ObjectId(_id));
		BasicDBObject basicDBObject = mongoCollection.find(filtro).first();
		medico = new Medico(basicDBObject);
		
		return medico;
	}
	//----------------------------------------------------------------
	public void ins(String json) {
		
		BasicDBObject basicDBObject = (BasicDBObject) JSON.parse(json);
		mongoCollection.insertOne(basicDBObject);
	}
	//----------------------------------------------------------------
	public boolean del(String _id) {
		
		Bson filtro = Filters.eq("_id", new ObjectId(_id));
		DeleteResult deleteResult = mongoCollection.deleteOne(filtro);
		boolean resultado = (deleteResult.getDeletedCount()>0);
		
		return resultado;
	}
	//----------------------------------------------------------------
	public boolean upd(String json) {
		
		//-- Recebendo as informações alteradas que deverão ser atualizadas no MongoDB
		BasicDBObject basicDBObject1 = (BasicDBObject) JSON.parse(json);
		
		//-- Para executar uma atualização no MongoDB é necessário um objeto
		//-- auxiliar e vazio para que os dados sejam trocados entre os objetos.
		//-- Resumo: Não podemos atualizar no mesmo objeto! Sempre precisarei de mais 1
		BasicDBObject basicDBObject2 = new BasicDBObject();
		
		//-- Desenvolvendo um objeto ID do String para o MongoDB
		ObjectId objectId = new ObjectId(basicDBObject1.getString("_id"));
		
		//-- Transitando os dados do 1 para o 2
		basicDBObject2.put("_id", 	    objectId);
		basicDBObject2.put("crm",  	    basicDBObject1.getString("crm"));
		basicDBObject2.put("nome", 	    basicDBObject1.getString("nome"));
		basicDBObject2.put("celular", 	basicDBObject1.getString("celular"));
		
		//-- Preparando o objeto 2 para o processo de atualização
		Bson bson = new Document("$set", basicDBObject2);
		
		//-- Preparando o filtro para localizar o registro exato da atualização
		Bson filtro =  Filters.eq("_id", objectId);
		
		//-- Executar a atualização
		BasicDBObject resultado = mongoCollection.findOneAndUpdate(filtro, bson, (new FindOneAndUpdateOptions()).upsert(true));
		
		return resultado.size()>0;
	}
	//----------------------------------------------------------------
}