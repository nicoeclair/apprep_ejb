package org.acme;

import javax.rmi.*;
import javax.naming.*;
import java.util.*;

public class HelloWorld {

	public static void main( String args[]) {
		try{
    
			Properties p = new Properties();
    
			//The JNDI properties you set depend
			//on which server you are using.
			//These properties are for the Remote Server.
			p.put("java.naming.factory.initial", "org.openejb.client.RemoteInitialContextFactory");
			p.put("java.naming.provider.url", "127.0.0.1:4201");
			p.put("java.naming.security.principal", "bar");
			p.put("java.naming.security.credentials", "foo");    
    
			//Now use those properties to create
			//a JNDI InitialContext with the server.
			InitialContext ctx = new InitialContext( p );
    
			//Lookup the bean using it's deployment id
			Object obj = ctx.lookup("HelloRemoteHome");
    
			//Be good and use RMI remote object narrowing
			//as required by the EJB specification.
			HelloHome ejbHome = (HelloHome)
				PortableRemoteObject.narrow(obj,HelloHome.class);

			//Use the HelloHome to create a HelloObject
			HelloObject ejbObject = ejbHome.create();
    
			//The part we've all been wainting for...
			String message = ejbObject.sayHello();

			//A drum roll please.
			System.out.println( message );
    
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
