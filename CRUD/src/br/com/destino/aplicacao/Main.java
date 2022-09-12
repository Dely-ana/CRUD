package br.com.destino.aplicacao;

import br.com.destino.dao.DestinoDao;
import br.com.destino.model.Destino;

public class Main {

	public static void main(String[] args) {
		
		DestinoDao  destinoDao = new DestinoDao();
		
		
		Destino destino = new Destino();
		
		
		/*destino.setLugares("Ceara");
		destino.setIda("Escolha da Data de Partida");
		destino.setVolta("Escolha a data de Retorno");
		/*
	     //DestinoDao.save(destino);
		
		// ***UPDATE** Atualizar o lugar
		
		/*Destino dest = new Destino();
		dest.setLugares("Amapa");
		dest.setIda("Escolha da Data de Partida");
		dest.setVolta("Escolha da Data de Retorno");
		dest.setId(2); //è o numero que está no BD
		*/
		 
		//DestinoDao.UPDATE(dest);
		
		//Deleter um destino pelo numero de id
		  destinoDao.deleteById(8);
		  System.out.println("Destino deletado com sucesso!");
		 
		  
		  
		
		}			
	  
	
	 }




