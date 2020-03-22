package pe.ricardomarcelo.ventas.ws;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ClienteWSEndPoint {
	public final static String NAMESPACE = "http://ricardomarcelo.pe/ws/ventas/";
	public final static String CREAR_REQUEST = "crear";
	public final static String CONSULTARTODO_REQUEST = "consultarTodo";
		 

    @PayloadRoot(localPart = CREAR_REQUEST, namespace = NAMESPACE)
    public @ResponsePayload CrearResponse crear(@RequestPayload Crear  code) {
        CrearResponse crearResponse = new CrearResponse();
        
        crearResponse.setResultado("Cliente registrado..");
        return crearResponse;
    }
	
    @PayloadRoot(localPart = CONSULTARTODO_REQUEST, namespace = NAMESPACE)
    public @ResponsePayload ConsultarTodoResponse consultarTodo(@RequestPayload ConsultarTodo  code) {
        ConsultarTodoResponse consultarTodoResponse = new ConsultarTodoResponse();
        
        
        return consultarTodoResponse;
    }
}
