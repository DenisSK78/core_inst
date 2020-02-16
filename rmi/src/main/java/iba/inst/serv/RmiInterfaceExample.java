package iba.inst.serv;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RmiInterfaceExample extends Remote {

    EmployeeForRmi getEmployee() throws RemoteException;
}
