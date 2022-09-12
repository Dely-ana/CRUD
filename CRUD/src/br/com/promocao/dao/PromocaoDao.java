package br.com.promocao.dao;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.ArrayList;
	import java.util.List;
	import br.com.promocao.factory.ConnectionFactory;
    import br.com.promocao.model.Promocao;


	public class PromocaoDao {
		
	public static void save(Promocao promocao) {
			
			String sql = "insert into promocao (promocao_relampago, passagens, pacotes, hospedagem) VALUES (?, ?, ?, ?)";
			
			Connection conn = null;
			PreparedStatement pstm = null;
			
	try {
				
				//criar uma conexão com o BD
			conn  = ConnectionFactory.createConnectiomToMySQL();
				
				//criamos uma preparedStretement, para executar
			pstm = (PreparedStatement) conn.prepareStatement(sql);
				
				//adiconar os valores que sao esperados pela query
			pstm.setString(1, promocao.getPromocao_relampago());
			pstm.setString(2, promocao.getPassagens());
			pstm.setString(3, promocao.getPacotes());
			pstm.setString(4, promocao.getHospedagem());

			//Execute a query
			pstm.execute();
			System.out.println("Pacote de promoções inserida com sucesso!!");
				
		}catch (Exception e) {
				e.printStackTrace();
	    }finally {
	    	
	    	 //Fechar as conexoões 	 
	    	
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
					
			   }

		}

		     
	public List<Promocao> getPromocao(){
		
		String sql = "SELECT * FROM promocao ";
		
		List<Promocao> promocoes = new ArrayList<Promocao>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		    	   	 
		//classe que vai recuperar os dados do banco ***SELECT****
		ResultSet rset = null;
		
		 try {
			  conn = ConnectionFactory.createConnectiomToMySQL();
			    		 
			  pstm = (PreparedStatement) conn.prepareStatement(sql);
			    		 
			  rset = pstm.executeQuery();
			    		 
			  while (rset.next()) {
			    Promocao promocao = new Promocao();
			    
			    //Recuperar o ID
			    
			    promocao.setId(rset.getInt("ID"));
			    
			    //Recuperar Promocao_relampago
			    promocao.setPromocao_relampago(rset.getString("Promocão Relampago"));
			    
			    // Recuperar Passagens
			    promocao.setPassagens(rset.getString("Passagens"));
			    
			    //Recuperando Pacotes
			    promocao.setPacotes(rset.getString("Pacotes"));
			    
			    //Recuperando Hospedagem
			    promocao.setHospedagem(rset.getString("Hospedagem"));
			    
			    
			    promocoes.add(promocao);
	
			    
	 }
			  
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
				    	 
		     return promocoes;	
				   
				
}

		

	
	
    public static void UPDATE(Promocao promocao) {
		    	 
     String sql = "UPDATE promocao SET promocao_relampago = ?, passagens = ?,pacotes = ?, hospedagem = ? " + "WHERE id = ? ";
		    	 
		   Connection conn = null;
		   PreparedStatement pstm = null;
		    	 
	 try {
		    		 
		  // Criar conexão com o BD
		   conn = ConnectionFactory.createConnectiomToMySQL();
		    		 
	       // Criar a classe para executar a query
		    		 
		    pstm = (PreparedStatement) conn.prepareStatement(sql);
		    		 
		   //Adicionar os valores para atualizar
		       pstm.setString(1, promocao.getPromocao_relampago());
			   pstm.setString(2, promocao.getPassagens());
			   pstm.setString(3, promocao.getPacotes());
			   pstm.setString(4, promocao.getHospedagem());

		    		 
		   //Qual o id do registro que deseja atualizar
		       pstm.setInt(5,promocao.getId());
		    		 
		    //Executar a query
		       pstm.execute();
		       System.out.println("Atualização feita com sucesso!");		 
		 
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
		    	
		     
		 public static void deleteById (int id) {
		    	
		   String sql = "DELETE from promocao WHERE id = ?";
		    	
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
		     
}	     
		     
		     
		     
		     
		

