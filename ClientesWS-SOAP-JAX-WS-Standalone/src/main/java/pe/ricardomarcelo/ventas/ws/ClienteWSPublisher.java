package pe.ricardomarcelo.ventas.ws;

import javax.xml.ws.Endpoint;

public class ClienteWSPublisher {
    public static void main( String[] args ) throws Exception
    {
    	Endpoint.publish("http://localhost:8888/ClientesWS-SOAP-JAX-WS-Standalone/ClienteWS", new ClienteWS());
    }
}
