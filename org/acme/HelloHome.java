package org.acme;

import java.rmi.*;
import javax.ejb.*;
import java.util.*;

public interface HelloHome extends EJBHome {
	public HelloObject create() throws RemoteException, CreateException;
}
