package com.ejemplo.crud;

import com.ejemplo.crud.controller.UsuarioController;
import com.ejemplo.crud.model.Usuario;

public class Principal {

	public static void main(String[] args) {
		
		//Conexion.conexion();
		
		//Crear un objeto de UsuarioController//
		UsuarioController usuarioController = new UsuarioController();
		
		//Crear un objeto de Usuario//		
		Usuario usuario1 = new Usuario("Leomar", "lg251198", "Leomar Gomez" , "leomar1998jsoe@gmail.com");
		Usuario usuario2 = new Usuario("Matilde", "mtm12345", "Matilde Mencias" , "matildemencias@gmail.com");
		Usuario usuario3 = new Usuario("Leonardo", "lg051160", "Leonardo Gomez" , "leogom051160.com");

		
		//Cargar un objeto de usuario al metodo insertar de UsarioController//
		//usuarioController.insertar(usuario1);
		//usuarioController.insertar(usuario2);
		//usuarioController.insertar(usuario3);
		
		//Llama al metodo para mostrar todos los registros
		usuarioController.listarUsuario();
		
		//Cargar el id que voy a modificar al objeto usuario1
		//usuario2.setId(2);
		//usuarioController.actualizar(usuario2);
		//usuarioController.listarUsuario();
		
		usuarioController.eliminar(2);
		
		usuarioController.listarUsuario();



	}

}
