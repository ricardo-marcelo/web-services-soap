
package pe.ricardomarcelo.ws.ventas;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.3.2
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ClienteWS", targetNamespace = "http://ricardomarcelo.pe/ws/ventas/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface ClienteWS {


    /**
     * 
     * @param cliente
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(name = "resultado", targetNamespace = "")
    @RequestWrapper(localName = "crear", targetNamespace = "http://ricardomarcelo.pe/ws/ventas/", className = "pe.ricardomarcelo.ws.ventas.Crear")
    @ResponseWrapper(localName = "crearResponse", targetNamespace = "http://ricardomarcelo.pe/ws/ventas/", className = "pe.ricardomarcelo.ws.ventas.CrearResponse")
    @Action(input = "http://ricardomarcelo.pe/ws/ventas/ClienteWS/crearRequest", output = "http://ricardomarcelo.pe/ws/ventas/ClienteWS/crearResponse")
    public String crear(
        @WebParam(name = "cliente", targetNamespace = "")
        Cliente cliente);

    /**
     * 
     * @return
     *     returns java.util.List<pe.ricardomarcelo.ws.ventas.Cliente>
     */
    @WebMethod
    @WebResult(name = "cliente", targetNamespace = "")
    @RequestWrapper(localName = "consultarTodo", targetNamespace = "http://ricardomarcelo.pe/ws/ventas/", className = "pe.ricardomarcelo.ws.ventas.ConsultarTodo")
    @ResponseWrapper(localName = "consultarTodoResponse", targetNamespace = "http://ricardomarcelo.pe/ws/ventas/", className = "pe.ricardomarcelo.ws.ventas.ConsultarTodoResponse")
    @Action(input = "http://ricardomarcelo.pe/ws/ventas/ClienteWS/consultarTodoRequest", output = "http://ricardomarcelo.pe/ws/ventas/ClienteWS/consultarTodoResponse")
    public List<Cliente> consultarTodo();

}
