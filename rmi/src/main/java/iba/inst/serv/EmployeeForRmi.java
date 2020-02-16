package iba.inst.serv;

import java.io.Serializable;

public class EmployeeForRmi implements Serializable {
    private String name;

    public String getName() {
        return "This name!";
    }
}
