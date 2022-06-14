package com.ejemplo.crud.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.ejemplo.crud.Conexion;
import com.ejemplo.crud.model.Usuario;

public class UsuarioController {
	
	public void insertar(Usuario usuario) {
		
		//Crear la consulta sql para inseetar datos//
		
		String sql = "INSERT INTO usuarios(username,password,fullname,email) VALUES(?,?,?,?)";
		
		//Clase de Java.sql para pasar una consulta sql a la base de datos//
		
		PreparedStatement statement;
		
		try {
			//pasamos la conexion a base de datos y tambien la consulta en el valor String sql//
			
			statement = Conexion.conexion().prepareStatement(sql);
			statement.setString(1,usuario.getUsername());
			statement.setString(2,usuario.getPassword());
			statement.setString(3,usuario.getFullname());
			statement.setString(4,usuario.getEmail());
			
			int rowsInserted = statement.executeUpdate();		
			if (rowsInserted > 0) {
				System.out.println("Los resusltados fuerons insertados correctamente");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		

		
	}
	
	public void listarUsuario() {
		String sql = "SELECT * FROM usuarios";
		
		Statement statement;
		
		try {
			
			statement = Conexion.conexion().createStatement();
			ResultSet result = statement.executeQuery(sql);
			
			int cont = 0;
			Usuario user;
			while (result.next()) {
				String username = result.getString(2); //columna usernamme = 2
				String password = result.getString(3); //columna password = 3
				String fullname = result.getString(4); //columna fullname = 4
				String email = result.getString(5);    //columna email = 5
				cont++;
				System.out.println("#usuario " + cont + "-" + username + "-" + password + "-" + fullname + "-" + email);
				
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
	public void actualizar(Usuario user) {
		
		String sql = "UPDATE usuarios SET username = ? , password = ? , fullname = ? ,email = ? WHERE id = ?";
		
		PreparedStatement statement;
		
		//Pasamos la conexion a base de datos y tambien la consulta en el valor String sql
		
		try {
			
			statement = Conexion.conexion().prepareStatement(sql);
			statement.setString(1,user.getUsername());
			statement.setString(2,user.getPassword());
			statement.setString(3,user.getFullname());
			statement.setString(4,user.getEmail());
			statement.setInt(5,user.getId());
			
			int rowsInserted = statement.executeUpdate();		
			if (rowsInserted > 0) {
				System.out.println("Los registros fuerons actualizados correctamente");
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
		
	}
	
	public void eliminar(int id) {
		
		String sql = "DELETE FROM usuarios WHERE id = ?";
		
		try {
			
			PreparedStatement statement = Conexion.conexion().prepareStatement(sql);
			
			statement.setInt(1, id);
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("Usuario eliminado exitosamente!");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	

		
		
		
		
			
			
			
			
		
			
		
	
	

}
