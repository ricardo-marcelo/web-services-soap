
package pe.ricardomarcelo.ws.ventas;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the pe.ricardomarcelo.ws.ventas package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ConsultarTodo_QNAME = new QName("http://ricardomarcelo.pe/ws/ventas/", "consultarTodo");
    private final static QName _ConsultarTodoResponse_QNAME = new QName("http://ricardomarcelo.pe/ws/ventas/", "consultarTodoResponse");
    private final static QName _Crear_QNAME = new QName("http://ricardomarcelo.pe/ws/ventas/", "crear");
    private final static QName _CrearResponse_QNAME = new QName("http://ricardomarcelo.pe/ws/ventas/", "crearResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: pe.ricardomarcelo.ws.ventas
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConsultarTodo }
     * 
     */
    public ConsultarTodo createConsultarTodo() {
        return new ConsultarTodo();
    }

    /**
     * Create an instance of {@link ConsultarTodoResponse }
     * 
     */
    public ConsultarTodoResponse createConsultarTodoResponse() {
        return new ConsultarTodoResponse();
    }

    /**
     * Create an instance of {@link Crear }
     * 
     */
    public Crear createCrear() {
        return new Crear();
    }

    /**
     * Create an instance of {@link CrearResponse }
     * 
     */
    public CrearResponse createCrearResponse() {
        return new CrearResponse();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarTodo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarTodo }{@code >}
     */
    @XmlElementDecl(namespace = "http://ricardomarcelo.pe/ws/ventas/", name = "consultarTodo")
    public JAXBElement<ConsultarTodo> createConsultarTodo(ConsultarTodo value) {
        return new JAXBElement<ConsultarTodo>(_ConsultarTodo_QNAME, ConsultarTodo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ConsultarTodoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ConsultarTodoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ricardomarcelo.pe/ws/ventas/", name = "consultarTodoResponse")
    public JAXBElement<ConsultarTodoResponse> createConsultarTodoResponse(ConsultarTodoResponse value) {
        return new JAXBElement<ConsultarTodoResponse>(_ConsultarTodoResponse_QNAME, ConsultarTodoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Crear }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Crear }{@code >}
     */
    @XmlElementDecl(namespace = "http://ricardomarcelo.pe/ws/ventas/", name = "crear")
    public JAXBElement<Crear> createCrear(Crear value) {
        return new JAXBElement<Crear>(_Crear_QNAME, Crear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CrearResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link CrearResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://ricardomarcelo.pe/ws/ventas/", name = "crearResponse")
    public JAXBElement<CrearResponse> createCrearResponse(CrearResponse value) {
        return new JAXBElement<CrearResponse>(_CrearResponse_QNAME, CrearResponse.class, null, value);
    }

}
