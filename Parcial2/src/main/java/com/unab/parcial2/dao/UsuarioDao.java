package com.unab.parcial2.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.unab.parcial2.conexion.Conexion;
import com.unab.parcial2.entidades.*;

public class UsuarioDao {
	Conexion cn = new Conexion();
    Connection con = cn.RetornarConexion();

    public Usuario Login(String user, String pass) {
        var usu = new Usuario();
        
        try {
            CallableStatement statement = con.prepareCall("Select * from usuario where Nombre='"+user+"' and Contrasena='"+pass+"'");
            
            ResultSet res = statement.executeQuery();
            while (res.next()) {
                usu.setId(res.getInt("Id"));
                usu.setNombre(res.getString("Nombre"));
                usu.setContrasena(res.getString("Contrasena"));
            }
        } catch (Exception e) {
        	System.out.println("No se cargo el usuario "+e);
        }
        
        return usu;
    }
}
