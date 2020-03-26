package pe.ricardomarcelo.ventas.ws.consumer;

import java.io.File;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import pe.ricardomarcelo.ventas.ws.types.Cliente;
import pe.ricardomarcelo.ventas.ws.types.ClienteWS;

public class App 
{
		
    public static void main( String[] args ) throws Exception
    {
    	
		
		/*
		 * Authenticator myAuth = new Authenticator() {
		 * 
		 * @Override protected PasswordAuthentication getPasswordAuthentication() {
		 * return new PasswordAuthentication("ricardo", "123456".toCharArray()); } };
		 * 
		 * Authenticator.setDefault(myAuth);
		 */
		 
    	
    	File fileWSDL=new File("src/main/resources/ClienteWS.wsdl");        
		URL wsdlUrl = fileWSDL.toURI().toURL();
    	//URL wsdlUrl = new URL("http://localhost:8081/ClientesWS-SOAP-JAX-WS-Security/ClienteWS?wsdl");
		QName qname = new QName("http://ricardomarcelo.pe/ws/ventas/","ClienteWS"); 
		Service service = Service.create(wsdlUrl, qname); 
		ClienteWS clienteWS = service.getPort(ClienteWS.class);
		  
		Cliente cliente = new Cliente(); cliente.setId(1);
		cliente.setNombre("Ricardo"); cliente.setDireccion("Lima");
		cliente.setTelefono("8887777");
		 
		
		//Agregar user y pass al contenedor de autenticación 
		BindingProvider bp = (BindingProvider) clienteWS;
		  
		bp.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "ricardo");
		bp.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "123456");
		
		String resulatdo = clienteWS.crear(cliente); System.out.println(resulatdo);
		 			
	 
    }
}
