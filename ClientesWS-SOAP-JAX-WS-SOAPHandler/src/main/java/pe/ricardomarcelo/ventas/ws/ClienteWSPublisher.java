package pe.ricardomarcelo.ventas.ws;

import java.util.LinkedList;
import java.util.List;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;

public class ClienteWSPublisher {
	public static void main(String[ ] args) {
		Endpoint endpoint = Endpoint.create(new ClienteWS());
		
		/*
		 * Binding binding = endpoint.getBinding(); List<Handler> hchain = new
		 * LinkedList<Handler>(); hchain.add(new SecuritySOAPHandler());
		 * binding.setHandlerChain(hchain);
		 */
		
		endpoint.publish("http://localhost:8888/ClientesWS-SOAP-JAX-WS-SOAPHandler/ClienteWS");
		System.out.println("http://localhost:8888/ClientesWS-SOAP-JAX-WS-SOAPHandler/ClienteWS");
	}
}
