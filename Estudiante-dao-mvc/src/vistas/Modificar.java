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
 * Servlet implementation class Modificar
 */
@WebServlet("/Modificar")
public class Modificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Modificar() {
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
				
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		String mensaje;
		
		int id;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
			mensaje = "	El id ingresado debe ser numerico, registro no exitoso";
			imprimirMensaje(response, mensaje);
			return;
		}
		
		boolean datoFaltante = false;
		
		String nombre = request.getParameter("nombre");
		String codigo = request.getParameter("codigo");
		String telefono = request.getParameter("telefono");
		String semestre = request.getParameter("semestre");
		
		datoFaltante = validarDatoVacio(nombre);
		datoFaltante = validarDatoVacio(codigo);
		datoFaltante = validarDatoVacio(telefono);
		datoFaltante = validarDatoVacio(semestre);
		
		if (datoFaltante) {
			mensaje = "Faltan campos por llenar";
		} else {
			//Actualizar registro bd
			try {
				Controlador controlador = new Controlador();
			    Estudiante estudiante = new Estudiante(id, nombre, codigo, telefono, semestre);
			    controlador.actualizar(estudiante);
		    } catch (Exception e) {
		    	mensaje = "No fue posible realizar la modificacion";
				imprimirMensaje(response, mensaje);		
				return;
			}	
			mensaje = "Modificacion exitosa";
		}		
		imprimirMensaje(response, mensaje);		
	}

	private void imprimirMensaje(HttpServletResponse response, String mensaje) throws IOException {
		// create HTML response
		PrintWriter writer = response.getWriter();
		writer.append("<!DOCTYPE html>\r\n")
			  .append("<html>\r\n")
			  .append("		<head>\r\n")
			  .append("			<title>MODIFICAR ESTUDIANTE</title>\r\n")
			  .append(mensaje)
			  .append("		</head>\r\n")
			  .append("		<body>\r\n");
		writer.append("		</body>\r\n")
			  .append("</html>\r\n");
	}

	private boolean validarDatoVacio(String dato) {
		if (dato == null || dato.trim().isEmpty()) {
			return true;
		}
		return false;
	}

}
