package pe.ricardomarcelo.ventas.ws.consumer;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import pe.ricardomarcelo.ws.ventas.Cliente;
import pe.ricardomarcelo.ws.ventas.ClienteWS;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 String url = "http://localhost:8080/ClientesWS-SOAP-JAX-WS/ClienteWS";
    	 JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();        
         factory.setAddress(url);        
         
         factory.setServiceClass(ClienteWS.class);        

         Object client = factory.create();

         try {        
        	 Cliente cliente = new Cliente();
        	 cliente.setId(1);
        	 cliente.setNombre("Ricardo");
        	 cliente.setDireccion("Lima");
        	 cliente.setTelefono("999777");
        	 
             ClienteWS clienteWS = ((ClienteWS)client);
             String resultado = clienteWS.crear(cliente);    
         
             System.out.println(resultado);    
         
           } catch (SecurityException e) {

             e.printStackTrace();

           } catch (IllegalArgumentException e) {

             e.printStackTrace();

           } 
    }
}
