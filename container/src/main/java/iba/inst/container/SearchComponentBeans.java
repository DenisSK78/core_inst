package iba.inst.container;


import iba.inst.anotation.ComponentBean;
import org.reflections.Reflections;

import java.util.Set;

public class SearchComponentBeans {

    private String contextPath;
    private String packageName;

    public SearchComponentBeans(String packageName) {
        String cont  = (packageName == null) ? "" : packageName;
        this.packageName = cont;
        this.contextPath = cont.replace(".", "/");
    }

    public String getContextPath() {
        return contextPath;
    }

    public Set<Class<?>> getClassesByPackage() {
        Reflections reflections = new Reflections(packageName);
        return reflections.getTypesAnnotatedWith(ComponentBean.class);
    }

    public String getPackageName() {
        return packageName;
    }
}

