package pe.ricardomarcelo.ventas.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.http.HTTPException;

import pe.ricardomarcelo.ventas.entidad.Cliente;

@WebService(serviceName = "ClienteWS", 
	targetNamespace = "http://ricardomarcelo.pe/ws/ventas/")
public class ClienteWS {
	private List<Cliente> listaCliente = new ArrayList<Cliente>();
	
	@Resource
    private WebServiceContext wsctx;
	
	@WebMethod
	@WebResult(name = "resultado")
	public String crear(@WebParam(name = "cliente") Cliente cliente) {
		String resultado;	
		if(validar()) {
			listaCliente.add(cliente);
			resultado = "Cliente registrado";
		}else {
			throw new HTTPException(401);
		}
		return resultado;
	}

	@WebMethod
	@WebResult(name = "cliente")
	public List<Cliente> consultarTodo() {
		List<Cliente> resultado = null;
		if(validar()) {
			resultado = listaCliente;
		}else {
			throw new HTTPException(401);
		}
		return resultado;
	}
	
	private boolean validar() {
		MessageContext mctx = wsctx.getMessageContext();
		boolean valor = false;
		//get detail from request headers
        Map http_headers = (Map) mctx.get(MessageContext.HTTP_REQUEST_HEADERS);
        List userList = (List) http_headers.get("Username");
        List passList = (List) http_headers.get("Password");
        	
        //Should validate username and password with database
        if (userList.contains("ricardo") && passList.contains("123456")){
        	valor = true;
        }else {
        	valor = false;
        }
        return valor;
	}
}

