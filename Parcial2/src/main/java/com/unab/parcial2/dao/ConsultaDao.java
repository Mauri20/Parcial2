package com.unab.parcial2.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.unab.parcial2.conexion.Conexion;
import com.unab.parcial2.entidades.Consulta;


public class ConsultaDao {
	Conexion cn = new Conexion();
    Connection con = cn.RetornarConexion();

    public ArrayList<Consulta> Datos() {
        var listado = new ArrayList<Consulta>();
        
        try {
            CallableStatement statement = con.prepareCall("Select * from consulta");
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                Consulta cons = new Consulta();
                cons.setId(res.getInt("Id"));
                cons.setNombre(res.getString("Nombre"));
                cons.setApellido(res.getString("Apellido"));
                //Agregando a la lista
                listado.add(cons);
            }
        } catch (Exception e) {
        	System.out.println("No se cargaron los Datos "+e);
        }
        
        return listado;
    }
    public int Eliminar(String id) {
    	int resultado=0;
    	int idC= Integer.parseInt(id);
    	try {
    		CallableStatement statement= con.prepareCall("Delete from consulta Where Id="+idC);
    		statement.executeUpdate();
			System.out.println("Eliminado");
			con.close();
    		resultado=1;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error al eliminar "+e);
		}
    	
    	return resultado;
    }
}
