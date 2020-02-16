package iba.inst;

import iba.inst.serv.EmployeeForRmi;
import iba.inst.serv.RmiInterfaceExample;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

public class RmiClient {
    public static void main(String[] args) throws NamingException, RemoteException {

        Context context = new InitialContext();

        Enumeration<NameClassPair> e = context.list("rmi://localhost/");
//        while (e.hasMoreElements())
//            System.out.println(e.nextElement().getName());

        String url = "rmi://localhost/emp";
        RmiInterfaceExample rmiInt = (RmiInterfaceExample) context.lookup(url);
        EmployeeForRmi emp = rmiInt.getEmployee();
        System.out.println(emp.getName());

    }
}
