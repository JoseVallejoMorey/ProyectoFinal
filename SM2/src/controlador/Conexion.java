package controlador;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class Conexion {

	private String USERNAME = "root";
	private String PASSWORD = "root";
	private String HOST = "localhost";
	private String PORT = "3306";
	private String DATABASE = "sm2";
	private String CLASSNAME = "com.mysql.jdbc.Driver";
	private String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
	private Connection con;
	
	//Constructor 
	
	public Conexion(){
		try{
			Class.forName(CLASSNAME);
			con = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		}catch(ClassNotFoundException e){
			System.out.println("Error"+e);
		}catch(SQLException e){
			System.out.println("Error"+e);
		}
	}
	
	//Metodo que devuleva la conexion
	
	public Connection getConexion(){
		return con;
		
	}
	


}
