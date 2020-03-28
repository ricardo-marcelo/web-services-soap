package pe.ricardomarcelo.ventas.ws.consumer;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.Handler;

import pe.ricardomarcelo.ventas.ws.types.Cliente;
import pe.ricardomarcelo.ventas.ws.types.ClienteWS;

public class App 
{
		
    public static void main( String[] args ) throws Exception
    {
    	
    	URL wsdlUrl = new URL("http://localhost:8888/ClientesWS-SOAP-JAX-WS-SOAPHandler/ClienteWS?wsdl");
		QName qname = new QName("http://ricardomarcelo.pe/ws/ventas/","ClienteWS"); 
		Service service = Service.create(wsdlUrl, qname); 
		ClienteWS clienteWS = service.getPort(ClienteWS.class);

        BindingProvider bindingProvider = (BindingProvider) clienteWS;        
        @SuppressWarnings("rawtypes")
		List<Handler> handlerChain = new ArrayList<Handler>();
        handlerChain.add(new SecuritySOAPHandler("ricardo", "123456"));
        bindingProvider.getBinding().setHandlerChain(handlerChain);
		        	
		Cliente cliente = new Cliente(); 
		cliente.setId(1);
		cliente.setNombre("Ricardo"); 
		cliente.setDireccion("Lima");
		cliente.setTelefono("8887777");
				
		String resulatdo = clienteWS.crear(cliente); 
		System.out.println(resulatdo);		 				

    }
}
