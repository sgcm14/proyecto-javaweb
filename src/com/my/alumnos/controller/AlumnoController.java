package com.my.alumnos.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.alumnos.dao.AlumnoDAO;
import com.my.alumnos.entity.Alumno;

@WebServlet("/alumnodb")
public class AlumnoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AlumnoController() {
        super();
    }
    	
    	
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		//opcion = getparametes(opcion)
		//switch opcion		
		//case editar
		//editarAlumno()
		//case eliminar
		//eliminarAlumno()
		//default
		//listartAlumno()
		String opcion = "";
		opcion = request.getParameter("opcion");
		
		try {
		switch(opcion) {
		 case "modificar": 
			 this.editarAlumno(request, response);
			 break;
		 case "eliminar": 
			 this.eliminarAlumno(request, response);
			 break;
		 default: this.listarAlumno(request, response);
		 	break;
			}
		}catch (Exception e) {
			
			e.printStackTrace();
			this.listarAlumno(request, response);
		}
		
		
	}


	
	private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AlumnoDAO daoAlumno = new AlumnoDAO();
		Alumno alumno =new Alumno();
		String id = request.getParameter("id");
		alumno.setId(Integer.parseInt(id));
		daoAlumno.deleteAlumnos(alumno);
			
		RequestDispatcher dispatcher = request.getRequestDispatcher("alumnodb");
		dispatcher.forward(request, response);
	}
	
	private void editarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AlumnoDAO daoAlumno = new AlumnoDAO();
		Alumno alumno =new Alumno();
		String id = request.getParameter("id");
		alumno.setId(Integer.parseInt(id));
		List<Alumno> datosalumno = daoAlumno.getAlumno(alumno);
			
		request.setAttribute("listaAlumno", datosalumno);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/modificar_alumno.jsp");
		dispatcher.forward(request, response);
	}
	
	
	private void listarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		AlumnoDAO daoAlumno = new AlumnoDAO();
		List<Alumno> alumnos = daoAlumno.getAlumnos();
		
		request.setAttribute("listaAlumnos", alumnos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/lista_alumnos.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
				AlumnoDAO daoAlumno = new AlumnoDAO();
				Alumno alumno=new Alumno();
				String opcion = request.getParameter("opcion");
				String nombre = request.getParameter("nombres");
				String apellido = request.getParameter("apellidos");
				String correo = request.getParameter("email");
				
				alumno.setNombres(nombre);
				alumno.setApellidos(apellido);
				alumno.setEmail(correo);
				
				if(opcion.equals("insertar")) {
					daoAlumno.saveAlumnos(alumno);
					response.sendRedirect("alumnodb");
					
				} else if(opcion.equals("actualizar")) {
					String id = request.getParameter("id");
					alumno.setId(Integer.parseInt(id));
					daoAlumno.updateAlumnos(alumno);
					response.sendRedirect("alumnodb");
					
				} else {
					response.sendRedirect("index.jsp");
				}
				
				
				
		
	}
	
	

}
