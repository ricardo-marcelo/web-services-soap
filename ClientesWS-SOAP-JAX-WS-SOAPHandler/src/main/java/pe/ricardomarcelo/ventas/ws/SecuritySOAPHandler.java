package pe.ricardomarcelo.ventas.ws;

import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import com.sun.xml.wss.ProcessingContext;
import com.sun.xml.wss.XWSSProcessor;
import com.sun.xml.wss.XWSSProcessorFactory;
import com.sun.xml.wss.XWSSecurityException;


public class SecuritySOAPHandler implements SOAPHandler<SOAPMessageContext> {

	public boolean handleMessage(SOAPMessageContext messagecontext) {
		XWSSProcessor xwssProcessor = null;
		try {
            boolean outMessageIndicator = (Boolean) messagecontext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);
            if (!outMessageIndicator) {
                if (xwssProcessor == null) {
                    InputStream serverConfig = SecuritySOAPHandler.class.getResourceAsStream("/META-INF/security-config.xml");
                    XWSSProcessorFactory factory = XWSSProcessorFactory.newInstance();
                    xwssProcessor = factory.createProcessorForSecurityConfiguration(serverConfig, new SecurityCallbackHandler());
                }
                
                SOAPMessage message = messagecontext.getMessage();
                ProcessingContext context = xwssProcessor.createProcessingContext(message);
                context.setSOAPMessage(message);
                SOAPMessage verifiedMsg = xwssProcessor.verifyInboundMessage(context);
                messagecontext.setMessage(verifiedMsg);
            }
        } catch (XWSSecurityException ex) {
            throw new WebServiceException("Autenticación invalida");
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
