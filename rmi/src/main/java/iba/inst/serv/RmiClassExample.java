package iba.inst.serv;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RmiClassExample extends UnicastRemoteObject implements RmiInterfaceExample {

    protected RmiClassExample() throws RemoteException {
    }

    @Override
    public EmployeeForRmi getEmployee() throws RemoteException {
        return new EmployeeForRmi();
    }
}
