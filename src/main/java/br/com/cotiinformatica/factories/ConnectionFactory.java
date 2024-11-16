package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//atributos
	
	private static String host = "jdbc:mysql://localhost:3306/bd_apiclientes";
	private static String user = "user_coti";
	private static String pass = "coti";
	
	//método para abrir conexão com o banco de dados
	public static Connection getConnection() throws Exception{
		
		return DriverManager.getConnection(host, user, pass);
		
	}
}
