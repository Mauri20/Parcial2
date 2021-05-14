package com.unab.parcial2.controladores;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.unab.parcial2.dao.UsuarioDao;
import com.unab.parcial2.entidades.Usuario;

/**
 * Servlet implementation class ControllerLogin
 */
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession sesion= request.getSession(true);
		
		String user= request.getParameter("user");
		String pass = request.getParameter("pass");
		
		UsuarioDao usuDao = new UsuarioDao();
		Usuario usu= new Usuario();
		usu=usuDao.Login(user, pass);
		if(usu!=null) {
			System.out.println("SIIIII");
			sesion.setAttribute("usuario", usu.getId());
			response.sendRedirect("index.jsp");
		}else {
			System.out.println("No se encontro el Usuario");
		}
	}

}
