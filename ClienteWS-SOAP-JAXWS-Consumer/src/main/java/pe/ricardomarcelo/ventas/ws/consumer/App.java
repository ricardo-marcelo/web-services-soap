package pe.ricardomarcelo.ventas.ws.consumer;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
         URL wsdlUrl = new URL("http://localhost:8080/ClientesWS-SOAP-JAX-WS/ClienteWS?wsdl"); 
		  QName qname = new QName("http://ricardomarcelo.pe/ws/ventas/","ClienteWS"); 
		  Service service = Service.create(wsdlUrl, qname);
		  ClienteWS clienteWS = service.getPort(ClienteWS.class);
		  
		  Cliente cliente = new Cliente();
		  cliente.setId(1);
		  cliente.setNombre("Ricardo");
		  cliente.setDireccion("Lima");
		  cliente.setTelefono("8887777");
		  
		  String resulatdo = clienteWS.crear(cliente);
		  
		  System.out.println(resulatdo);
		  
		  
		  
		 
    }
}
