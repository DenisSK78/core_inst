package iba.inst.serv;

import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiServer {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException, MalformedURLException, NamingException {

//        registry custom port
//        LocateRegistry.createRegistry(2020);
//        LocateRegistry.getRegistry(2020);
//        Registry registry = LocateRegistry.getRegistry();

        //by naming, default port 1099
        LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        RmiInterfaceExample employee = new RmiClassExample();
        Naming.bind("emp", employee);

//        //by context
//        Context context = new InitialContext();
//        context.bind("rmi:rmiint", rmiInt);
//        context.bind("rmi://localhost:1099/rmiint", rmiInt);
    }
}
