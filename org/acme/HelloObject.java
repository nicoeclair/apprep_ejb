package org.acme;

import java.rmi.*;
import javax.ejb.*;
import java.util.*;

public interface HelloObject extends EJBObject {
	public String sayHello() throws RemoteException;
}
