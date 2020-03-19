package pe.ricardomarcelo.ventas.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import pe.ricardomarcelo.ventas.entidad.Cliente;

@WebService(serviceName = "ClienteWS", 
	targetNamespace = "http://ricardomarcelo.pe/ws/ventas/")
public class ClienteWS {
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	@WebMethod
	@WebResult(name = "resultado")
	public String crear(@WebParam(name = "cliente") Cliente cliente) {
		listaCliente.add(cliente);
		return "Cliente registrado";
	}

	@WebMethod
	@WebResult(name = "cliente")
	public List<Cliente> consultarTodo() {		
		return listaCliente;
	}
}
