package iba.inst;

import iba.inst.anotation.ComponentBean;

@ComponentBean
public class BadConstructor {
    String badbadbad;

    public BadConstructor(String badbadbad) {
        this.badbadbad = badbadbad;
    }

    public BadConstructor() {
    }
}
