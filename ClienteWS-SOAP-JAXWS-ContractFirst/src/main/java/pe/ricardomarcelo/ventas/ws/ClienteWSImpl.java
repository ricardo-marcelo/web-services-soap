package pe.ricardomarcelo.ventas.ws;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;


@WebService(endpointInterface = "pe.ricardomarcelo.ventas.ws.ClienteWS")
public class ClienteWSImpl implements ClienteWS {

	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	@Override
	public String crear(Cliente cliente) {
		listaCliente.add(cliente);
		return "Cliente registrado";
	}

	@Override
	public List<Cliente> consultarTodo() {
		return listaCliente;
	}

}
