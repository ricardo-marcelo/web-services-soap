package pe.ricardomarcelo.ventas.ws.consumer;

import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPHeader;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

public class SecuritySOAPHandler implements SOAPHandler<SOAPMessageContext> {
	
	private static final String AUTH_NS     = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
    private static final String AUTH_PREFIX = "wss";
    
    private String username;
    private String password;

    public SecuritySOAPHandler(String username, String password) {
    	this.username=username;
    	this.password=password;
    }
    
    public boolean handleMessage(SOAPMessageContext messagecontext) {
        boolean outboundProperty = ((Boolean) messagecontext
                .get(SOAPMessageContext.MESSAGE_OUTBOUND_PROPERTY))
                .booleanValue();
        if (outboundProperty) {

            try {
                SOAPEnvelope soapEnvelope = messagecontext.getMessage().getSOAPPart().getEnvelope();
                SOAPHeader header = soapEnvelope.getHeader();
                if (header == null) {
                    header = soapEnvelope.addHeader();
                }
                SOAPElement wsSecHeaderElm = header.addChildElement("Security", AUTH_PREFIX, AUTH_NS);     
                // Add usernameToken to "Security" soapHeaderElement
                Name userNameToken= soapEnvelope.createName("UsernameToken", AUTH_PREFIX,AUTH_NS);
                SOAPElement userNameTokenElm = wsSecHeaderElm.addChildElement(userNameToken);

                // Add Username to usernameToken
                SOAPElement userNameSOAPElement = userNameTokenElm
                        .addChildElement("Username", AUTH_PREFIX, AUTH_NS);
                userNameSOAPElement.addTextNode(username);

                // Add password to UsernameToken
                Name passwordElementName = soapEnvelope.createName("Password", AUTH_PREFIX, AUTH_NS);
                SOAPElement passwordSOAPElement = userNameTokenElm.addChildElement(passwordElementName);

                passwordSOAPElement.addTextNode(password);

            } catch (Exception e) {
                throw new RuntimeException("Error on wsSecurityHandler: " + e.getMessage());
            }

        }

        return true;
	}

	public Set<QName> getHeaders() {
		QName securityHeader = new QName("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security", "wsse");
		HashSet<QName> headers = new HashSet<QName>();
		headers.add(securityHeader);
		return headers;				
	}

	@Override
	public void close(MessageContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		// TODO Auto-generated method stub
		return true;
	}

}
