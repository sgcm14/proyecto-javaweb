package com.my.alumnos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.my.alumnos.entity.Alumno;

public class AlumnoDAO {

	public List<Alumno> getAlumnos() {
		
		List<Alumno> alumnos = Collections.emptyList();
		
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "SELECT * FROM alumno";
		
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			alumnos = new ArrayList<>();
			
			while(rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setId(rs.getInt("id"));
				alumno.setNombres(rs.getString("nombres"));
				alumno.setApellidos(rs.getString("apellidos"));
				alumno.setEmail(rs.getString("email"));
				alumnos.add(alumno);
			}
			
			rs.close();
			ps.close();
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		return alumnos;
		
	}
	
	public void saveAlumno (Alumno alumno){
		Connection conn = Conexion.getInstancia().getConexion();
		
		//String query = "INSERT into alumno(nombres,apellidos,email) VALUES('"+alumno.getNombres()+"','"+alumno.getApellidos()+"','"+alumno.getEmail()+"')";
		String query = "INSERT into alumno(nombres,apellidos,email) VALUES(?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, alumno.getNombres());
			ps.setString(2, alumno.getApellidos());
			ps.setString(3, alumno.getEmail());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void updateAlumno (Alumno alumno){
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "UPDATE alumno SET nombres=?,apellidos=?,email=? WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1, alumno.getNombres());
			ps.setString(2, alumno.getApellidos());
			ps.setString(3, alumno.getEmail());
			ps.setInt(4, alumno.getId());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public void deleteAlumno (Alumno alumno){
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "DELETE FROM alumno WHERE id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1, alumno.getId());
			ps.executeUpdate();
			
			ps.close();
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	
public Alumno getAlumno(Alumno alumno) {
		
		//List<Alumno> datosalumno = Collections.emptyList();
		Connection conn = Conexion.getInstancia().getConexion();
		
		String query = "SELECT * FROM alumno WHERE id=?";
		Alumno alumnoEncontrado = null;
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, alumno.getId());
			ResultSet rs = ps.executeQuery();
			//datosalumno = new ArrayList<>();
			while(rs.next()) {
				alumnoEncontrado = new Alumno();
				alumnoEncontrado.setId(rs.getInt("id"));
				alumnoEncontrado.setNombres(rs.getString("nombres"));
				alumnoEncontrado.setApellidos(rs.getString("apellidos"));
				alumnoEncontrado.setEmail(rs.getString("email"));
				//datosalumno.add(alumno);
			}
			
			rs.close();
			ps.close();
			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		
		return alumnoEncontrado;
		
	}
}
