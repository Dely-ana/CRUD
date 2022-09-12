package br.com.promocao.factory;


	import java.sql.Connection;
	import java.sql.DriverManager;

	public class ConnectionFactory {
		
		//Nome do usuario do mysql		
		private static final String USERNAME = "root";
		 // senha do BD
		private static final String PASSWORD = "";
		// Caminho do BD
		private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agencia_de_viagem";
		
		/*  CONEXÃO COM O BD  */

		public static Connection createConnectiomToMySQL() throws Exception {
			// Faz com que a classe seja carregada pela JVM
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Cria a conexão com o BD
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		
			return connection;
		
		}
		
		public static void main(String[] args) throws Exception {
			
		//Recuperar uma conexão com o BD
		Connection con= createConnectiomToMySQL();
			
		//Testar se a conexão é nula
			
		if (con!=null) {
		    con.close();
		    System.out.println("Conexão obetida com sucesso! ");
			}
		}
		
	}


