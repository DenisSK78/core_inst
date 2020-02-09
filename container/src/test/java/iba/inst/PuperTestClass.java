package iba.inst;

import iba.inst.anotation.ComponentBean;
import iba.inst.anotation.InjectComponent;

@ComponentBean
public class PuperTestClass implements SayWhatIAm{

    @InjectComponent
    private SuperTestClass superTestClass;

    private String say;

    public PuperTestClass() {
        this.say = "-puper class";
    }

    @Override
    public void whatIAm() {
        superTestClass.whatIAm();
        System.out.println(say);
    }

    public SuperTestClass getSuperTestClass() {
        return superTestClass;
    }
}
