package iba.inst;

import iba.inst.anotation.ComponentBean;

@ComponentBean
public class SuperTestClass implements SayWhatIAm {

    private String say;

    public SuperTestClass() {
        this.say = "I am super";
    }

    @Override
    public void whatIAm() {
        System.out.print(say);
    }
}
