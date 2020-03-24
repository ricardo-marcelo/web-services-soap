package pe.ricardomarcelo.ws.consumer;

import java.net.URL;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

import pe.ricardomarcelo.ws.ventas.Cliente;
import pe.ricardomarcelo.ws.ventas.Crear;
import pe.ricardomarcelo.ws.ventas.CrearResponse;
import pe.ricardomarcelo.ws.ventas.ObjectFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	 ApplicationContext contexto = 
                 new ClassPathXmlApplicationContext(
                         "classpath:/META-INF/beans.xml");
         
         WebServiceTemplate template = (WebServiceTemplate)
        		 contexto.getBean("webServiceTemplate");
         
         //ObjectFactory objectFactory = new ObjectFactory();
         //Crear crearRequest = objectFactory.createCrear();
         Crear crearRequest = new Crear();
		  Cliente cliente = new Cliente();
		  cliente.setId(1);
		  cliente.setNombre("Ricardo");
		  cliente.setDireccion("Lima");
		  cliente.setTelefono("8887777");
		  
		  crearRequest.setCliente(cliente);
		  

		  //CrearResponse crearResponse = 
			//	  (CrearResponse)template.marshalSendAndReceive(crearRequest);
		  
		  JAXBElement<CrearResponse> responseObject =  
	                (JAXBElement<CrearResponse>) template
	                .marshalSendAndReceive(crearRequest);
		  
		  String resulatdo = ((CrearResponse)responseObject.getValue()).getResultado();
		  
		  System.out.println(resulatdo);
		  
    }
        
}
