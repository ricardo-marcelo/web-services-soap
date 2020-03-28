package pe.ricardomarcelo.ventas.ws;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;

import com.sun.xml.wss.impl.callback.PasswordValidationCallback;

public class SecurityCallbackHandler implements CallbackHandler {
	// Username/password hard-coded for simplicity and clarity.
	private static final String _username = "ricardo";
	private static final String _password = "123456";
	
	public void handle(Callback[] callbacks) throws UnsupportedCallbackException {
		for (Callback callback : callbacks) {
			if (callback instanceof PasswordValidationCallback) {
				PasswordValidationCallback passwordValidationCallback = (PasswordValidationCallback) callback;
	            passwordValidationCallback.setValidator(new PlainTextPasswordVerifier());
	        } else {
	        	throw new UnsupportedCallbackException(callback);
	        }
	     }
	}
	
	private class PlainTextPasswordVerifier implements PasswordValidationCallback.PasswordValidator {
	    public boolean validate(PasswordValidationCallback.Request request) throws PasswordValidationCallback.PasswordValidationException {
	        PasswordValidationCallback.PlainTextPasswordRequest passwordRequest = (PasswordValidationCallback.PlainTextPasswordRequest) request;
	        String username = passwordRequest.getUsername();
	        String password = passwordRequest.getPassword();
	        
	        if (username != null && password != null) {
	            if (username.equals(_username) && password.equals(_password)) {
	                return true;
	            }
	        } else {
	            return false;	       
	        }
	        return false;
	    }
	}
}
