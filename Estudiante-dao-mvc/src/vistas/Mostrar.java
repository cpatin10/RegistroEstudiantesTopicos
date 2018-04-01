package vistas;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.Controlador;
import Modelo.Estudiante;


/**
 * Servlet implementation class Mostrar
 */
@WebServlet("/Mostrar")
public class Mostrar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Mostrar() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		
		// create HTML response
		PrintWriter writer = response.getWriter();
		
		try {
			Controlador controlador = new Controlador();
			List<Estudiante> estudiantes = controlador.obtenerEstudiantes();
			mostrarEsdtudiantes(writer, estudiantes);
		} catch (Exception e) {
			imprimirMensaje(response, "No fue posible recoger los registros");		
			return;
		}
		
//		ArrayList<String> estudiantes = new ArrayList<String>(); // formar lista con respuesta de bd
//		
//		estudiantes.add("Pepito");
//		estudiantes.add("Juanita");
//		estudiantes.add("Pedrito");
//			
//		mostrarEsdtudiantes(writer, estudiantes);			
	}

	private void mostrarEsdtudiantes(PrintWriter writer, List<Estudiante> estudiantes) {
		writer.append("<!DOCTYPE html>\r\n")
				 .append("<html>\r\n")
				 .append("		<head>\r\n")
				 .append("			<title></title>\r\n")
				 .append("		</head>\r\n")
				 .append("		<body>\r\n");
			
		writer.append("<table>");
		for (Estudiante estudiante: estudiantes){
			writer.append("<tr>");
			writer.append("<td>ID: "+ estudiante.getId() +"</td>"); 
			writer.append("<td>Nombre: "+ estudiante.getNombre() +"</td>");  
			writer.append("<td>Codigo: "+ estudiante.getCodigo() +"</td>"); 
			writer.append("<td>Telefono: "+ estudiante.getTelefono() +"</td>"); 
			writer.append("<td>Semestre: "+ estudiante.getSemestre() +"</td>"); 
			writer.append("</tr>");
		}  			
		writer.append("</table>");
		
		writer.append("		</body>\r\n")
			  .append("</html>\r\n");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
