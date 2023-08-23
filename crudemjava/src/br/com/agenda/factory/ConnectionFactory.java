package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome do usuário do MySQL
	private static final String USERNAME = "root";
	
	//Senha do banco de dados
	private static final String PASSWORD = "joaogrilo";
	
	//Caminho para o banco de dados, porta, nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	//Conexão com o banco de dados
	public static Connection createConnectionToMySQL() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		//Recuperar conexão com o banco de dados
		Connection con = createConnectionToMySQL();
		
		//Testar se a conexão nula
		if(con != null)
		System.out.println("Conexão obtida com sucesso!");
	}

}
