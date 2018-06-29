package br.com.pizzadigital.pdws.controller;

import java.util.List;

public interface CRUD<T> {

	public List<T> all(); //-- Retornará todos os registros
	
	public T       get(String _id); //-- Retornará somente 1 registro de acordo com o _id
	
	public void    ins(String json); //-- Inserir 1 registro no formato JSON no MongoDB
	
	public boolean del(String _id); //-- Excluirá 1 registro de acordo com o _id
	
	public boolean upd(String json); //-- Atualizará 1 registro de acordo com JSON
	
}
