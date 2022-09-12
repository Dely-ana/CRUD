
package br.com.promocao.aplicacao;

import br.com.promocao.dao.PromocaoDao;
import br.com.promocao.model.Promocao;

public class Main {

	public static void main(String[] args) {
          
	//Promocao promocaoDao = new PromocaoDao();
	
	/*Promocao promocao = new Promocao();
	promocao.setPromocao_relampago("Promocão dia dos Namorados");
	promocao.setPassagens("Bahia");
	promocao.setPacotes("Para duas pessoas");
	promocao.setHospedagem("Café da manhã/wifi");
     */
    
	//PromocaoDao.save(promocao);	
       
    //Atualizar a promoção

	Promocao p = new Promocao();
	p.setPromocao_relampago("Promocão dia do trabalhador");
	p.setPassagens("Ceara");
	p.setPacotes("Para duas pessoas");
	p.setHospedagem("Café da manhã");
	p.setId(6);
	
	PromocaoDao.UPDATE(p);
	

		
	/*	
	//Deleter uma promoção pelo numero de id
	PromocaoDao.deleteById(7);
    System.out.println("Promoção deletada com sucesso!");
	*/
		
    }
    
  }

