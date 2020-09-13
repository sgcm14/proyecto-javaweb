package com.my.alumnos.controller;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.alumnos.dao.AlumnoDAO;
import com.my.alumnos.dao.Conexion;
import com.my.alumnos.entity.Alumno;


@WebServlet("/testdb")
public class TestDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestDB() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Connection conn = Conexion.getInstancia().getConexion();
		
		AlumnoDAO daoAlumno = new AlumnoDAO();
		
		List<Alumno> alumnos = daoAlumno.getAlumnos();
		
		for (Alumno alumno : alumnos) {
			System.out.println(alumno.toString());
		}
		
		System.out.println("Saliendo del servlet");
		
	}

	 

}
