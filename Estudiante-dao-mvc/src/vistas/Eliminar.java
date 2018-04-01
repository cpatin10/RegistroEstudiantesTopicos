package vistas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.Controlador;
import Modelo.Estudiante;

/**
 * Servlet implementation class Eliminar
 */
@WebServlet("/Eliminar")
public class Eliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Eliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String mensaje = "";
		
		int id;
		try {			
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			mensaje = "	El id ingresado debe ser numerico, registro no exitoso";
			imprimirMensaje(response, mensaje);
			return;
		}
		
		// Eliminar registro
		try {
			Controlador controlador = new Controlador();
		    Estudiante estudiante = new Estudiante(id, "","","","");
		    controlador.eliminar(estudiante);
	    } catch (Exception e) {
	    	mensaje = "No fue posible eliminar la eliminacion";
			imprimirMensaje(response, mensaje);		
			return;
		}			
		mensaje = "Eliminacion exitosa";
		
		imprimirMensaje(response, mensaje);
	}

	private void imprimirMensaje(HttpServletResponse response, String mensaje) throws IOException {
		// create HTML response
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
			  .append("<html>\r\n")
			  .append("		<head>\r\n")
			  .append("			<title>ELIMINAR ESTUDIANTE</title>\r\n")
			  .append(mensaje)
			  .append("		</head>\r\n")
			  .append("		<body>\r\n");
		writer.append("		</body>\r\n")
			  .append("</html>\r\n");
	}

}
