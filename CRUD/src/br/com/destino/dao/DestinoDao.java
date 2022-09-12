package br.com.destino.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.mysql.cj.jdbc.JdbcPreparedStatement;
import com.mysql.cj.jdbc.JdbcStatement;
import br.com.destino.factory.ConnectionFactory;
import br.com.destino.model.Destino;



public class DestinoDao<destino> {

	
	     public static void save(Destino destino) {
		
		String sql = "insert into destino (lugares, ida, volta) VALUES (?, ?, ?)";
		
		Connection conn = null;
		JdbcPreparedStatement pstm = null;
		
		try {
			
			//criar uma conexão com o BD
			conn  = ConnectionFactory.createConnectiomToMySQL();
			
			//criamos uma preparedStretement, para executar
			pstm = (JdbcPreparedStatement) conn.prepareStatement(sql);
			
			//adiconar os valores que sao esperados pela query
			pstm.setString(1, destino.getLugares());
			pstm.setString(2, destino.getIda());
			pstm.setString(3, destino.getVolta());

			
			//Execute a query
			
			
			pstm.execute();
			System.out.println("Destino escolhido com sucesso!");
			
		  }catch (Exception e) {
			e.printStackTrace();
		   }finally {
			   
			   try {
					if (pstm!=null) {
						pstm.close();
					}
				
				  if(conn!=null) {
					conn.close();
				  }
				
				  }catch (Exception e) {
				   e.printStackTrace();
				}
				 //Fechar as conexoões 
		   }

	}

	     
	     
	     
	     public static void UPDATE(Destino destino) {
	    	 
	    	 String sql = "UPDATE destino SET lugares = ?, ida = ?, volta = ? "+ "WHERE id = ? ";
	    	 
	    	 Connection conn = null;
	    	 PreparedStatement pstm = null;
	    	 
	    	 try {
	    		 
	    		 // Criar conexão com o BD
	    		 conn = ConnectionFactory.createConnectiomToMySQL();
	    		 
	    		 // Criar a classe para executar a query
	    		 
	    		 pstm = (PreparedStatement) conn.prepareStatement(sql);
	    		 
	    		 //Adicionar os valores para atualizar
	    		 
	    		 pstm.setString(1,destino.getLugares());
	    		 pstm.setString(2,destino.getIda());
	    		 pstm.setString(3,destino.getVolta());
	    		 
	    		 //Qual o id do registro que deseja atualizar
	    		 pstm.setInt(4,destino.getId());
	    		 
	    		 //Executar a query
	    		 pstm.execute();
	    		 
	 
	    	 } catch (Exception e) {
	    		 e.printStackTrace();
	    	 }finally {
	    		 
	    		  try {
	    		 if(pstm!=null) {
	    			 pstm.close();
	    		 }
	    		 if(conn!=null) {
	    			 conn.close();
	    		 }
	    	 
	    		} catch (Exception e) {
		    		 e.printStackTrace();
		    	 }	 
	    		 
	    	 }
	    	 
	     }
	    	
	     
	     public void deleteById (int id) {
	    	
	    	 String sql = "DELETE from destino WHERE id = ?";
	    	
	    	 Connection conn = null;
	    	 PreparedStatement pstm = null;
	    	 
              try {
	    
	    		conn = ConnectionFactory.createConnectiomToMySQL();
	    		 
	    		 pstm = (PreparedStatement) conn.prepareStatement(sql);
	    		
	    		 pstm.setInt(1, id);
	    		
	    		 pstm.execute();
	    		 
	 
	    	 } catch (Exception e) {
	    		 e.printStackTrace();
	    	 }finally {
	    		  try {
	    		 if(pstm!=null) {
	    			 pstm.close();
	    		 }
	    		 if(conn!=null) {
	    			 conn.close();
	    		 }
	    	 
	    		} catch (Exception e) {
		    		 e.printStackTrace();
		       }	 
	    		 
	    	 }
	     }
	     
	     
	     
	     
	     
	     
	     public List<Destino> getDestino() {
	    	 
	    	 String sql = "SELECT * FROM destino";
	    			 
	    	 List<Destino> destino = new ArrayList<Destino>();
	    	 
	    	 Connection conn = null;
	    	 PreparedStatement pstm = null;
	    	 
	    	 
	    	 //classe que vai recuperar os dados do banco
	    	 
	    	 ResultSet rset = null;
	    	 
	    	 try {
	    		 conn = ConnectionFactory.createConnectiomToMySQL();
	    		 
	    		 pstm = (PreparedStatement) conn.prepareStatement(sql);
	    		 
	    		 rset = pstm.executeQuery();
	    		 
	    		 while (rset.next()) {
	    			 
	    		 }
	    		
	    			 Destino destinos = new Destino();
	    			 
	    			 //Recuperar o id
	    			 destinos.setId(rset.getInt("id"));
	    			
	    			 //Recuperar o lugares
	    			 
	    			 destinos.setLugares(rset.getString("lugares"));
	    			 
	    			 // Recuperando ida
	    			 
	    			 destinos.setIda(rset.getString("ida"));
	    			 
	    			 //Recuerando volta
	    			 
	    			 destinos.setVolta(rset.getString("Volta"));
	    			 
	    			
	    			 
	    			  destino.add (destinos);
	    			 
	    		 }catch(Exception e){
	    			 e.printStackTrace();
	    			 
	    		 }finally {
	    			 
	    			 try {
	    			 
	    			 if(rset!=null) {
	    			    rset.close();
	    			 }
	    			 
	    	
	    	 		 if(pstm!=null) {
	    	 		 pstm.close();	     
	    	 		 
	    	 		 }	 
	    	 		 
	    	 		 if(conn!=null) {
	    	 			 conn.close();
	    	 		 }
	             
	    		}catch (Exception e) {
	    			 e.printStackTrace(); 
	    	 		 
	    	      	}
	    		
	    		}
	    	 
	     		return destino;	
	    }

}
