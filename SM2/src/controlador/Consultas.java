package controlador;


import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Consultas extends Conexion {
	//Metodo autenticacion
	public boolean autenticacion (String usuario, String contraseña){
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try{
			String consulta = "select * from usuarios where email = ? and pass = ?";
			pst = getConexion().prepareStatement(consulta);
			pst.setString(1,usuario);
			pst.setString(2, contraseña);
			rs = pst.executeQuery();
			
			if(rs.absolute(1)){
				return true;
			}
			
		}catch(Exception e){
			System.err.println("Error"+e);
		}finally{
			try{
				if(getConexion() != null )getConexion().close();
				if(pst != null) pst.close();
				if(rs != null) rs.close();
			}catch(Exception e){
				System.err.println("Error"+e);
			}
		}
		
		
		return false;
	}
	
	/*Probar que la consulta funciona correctamente
	
	public void main(String [] arg){
		Consultas co = new Consultas();
		System.out.println(co.autenticacion("adri", "4578"));
	}
	*/
	
	public boolean registrar(String nombre, String apellido, String usuario, String contraseña){
		//metodo registrar
		PreparedStatement pst = null;
		
		try{
			String consulta = "insert into usuarios (nombre,apellido,usuario,pass) values(?,?,?,?)";
			pst = getConexion().prepareStatement(consulta);
			pst.setString(1, nombre);
			pst.setString(2, apellido);
			pst.setString(3, usuario);
			pst.setString(4, contraseña);
			
			if(pst.executeUpdate()==1){
				return true;
			}
			
		}catch (Exception e){
			System.err.println("Error"+e);
		}finally{
			try{
				if(getConexion() != null )getConexion().close();
				if(pst != null) pst.close();
				
			}catch(Exception e){
				System.err.println("Error"+e);
			}
			
		}
		
		return false;
	}
	
	/*Probar que el registro funciona correctamente
	
	public void main(String [] arg){
		Consultas co = new Consultas();
		System.out.println(co.registrar("nombre", "apellido", "usuario", "contraseña"));
	}
	*/
	
	
}
