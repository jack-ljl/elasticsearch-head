package test;

import java.util.Hashtable;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class JNDITest {
	
	public static void main(String[] args) throws NamingException {
		Hashtable table = new Hashtable();
		table.put("java.naming.factory.initial", "com.ibm.ws.naming.java.javaURLContextFactory");
		InitialContext ic = new InitialContext(table);
		ic.bind("java:comp/env/ejb/missive/MissiveAdmin", new Object());
	}

}
