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
    public int Eliminar(int id) {
    	int resultado;
    	try {
    		CallableStatement statement = con.prepareCall("Delete from consulta where Id="+id);
    		ResultSet res = statement.executeQuery();
    		
		} catch (Exception e) {
			// TODO: handle exception
		}
    	
    	return resultado;
    }
}
