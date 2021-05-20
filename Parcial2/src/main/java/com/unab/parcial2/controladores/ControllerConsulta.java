package com.unab.parcial2.controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.unab.parcial2.dao.ConsultaDao;
import com.unab.parcial2.dao.UsuarioDao;
import com.unab.parcial2.entidades.Consulta;

/**
 * Servlet implementation class ControllerConsulta
 */
public class ControllerConsulta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerConsulta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String evaluar = request.getParameter("Eliminar");
		String id=request.getParameter("Id");
		if(evaluar.equals("btne")) {
			ConsultaDao dao= new ConsultaDao();
			if(dao.Eliminar(id)==0) {
				response.sendRedirect("index.jsp");
				System.out.println("ERROR");
			}else {
				response.sendRedirect("index.jsp");
			}
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		
		HttpSession sesion= request.getSession(true);
		String btnCerrar= request.getParameter("btncerrar");
		if(btnCerrar!=null) {
			response.sendRedirect("index.jsp");
			sesion.invalidate();
		}else {
			ConsultaDao consultaDao = new ConsultaDao();
			ArrayList<Consulta> listado = new ArrayList<Consulta>();
			var datos=consultaDao.Datos();
			if(datos==null) {
				System.out.println("No se encontraron datos");
			}else {
				for (var iterar:datos) {
					//System.out.println(iterar.getNombre());
					Consulta cons = new Consulta();
					cons.setId(iterar.getId());
					cons.setNombre(iterar.getNombre());
					cons.setApellido(iterar.getApellido());
					listado.add(cons);
				}
				Gson json = new Gson();
				response.getWriter().append(json.toJson(listado));
			}
		}
	}

}
