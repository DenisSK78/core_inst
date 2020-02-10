package iba.inst.container;

import iba.inst.anotation.InjectComponent;
import iba.inst.exception.ContainerException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiConfig {

    private Map<String, Object> mapBeans = new HashMap<>();
    private SearchComponentBeans compSet;
    private List<Object> listBeans;

    public DiConfig(String packageName) {
        this.compSet = new SearchComponentBeans(packageName);
        try {
            Set<Class<?>> classSet = compSet.getClassesByPackage();
            addClassesInContainer(classSet);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        addInjectComponent();
    }

    private void addClassesInContainer(Set<Class<?>> classesByPackage) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        for(Class<?> forInstClass: classesByPackage){
           addClassesInContainer(forInstClass);
        }
    }

    private void addInjectComponent() {
        for(Object o : listBeans){
            Field[] fields = o.getClass().getDeclaredFields();
            for (Field field : fields){
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                for (Annotation an : declaredAnnotations){
                    boolean equals = an.annotationType().equals(InjectComponent.class);
                    if (equals){
                        String simpleName = field.getType().getSimpleName();
                        field.setAccessible(true);
                        try {
                            field.set(o, mapBeans.get(simpleName));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private void addClassesInContainer(Class<?> insClass) throws IllegalAccessException,
            InstantiationException, InvocationTargetException {
        Constructor<?>[] constructors = insClass.getConstructors();
        boolean isHasEmptyCon = false;
        for (Constructor<?> cons: constructors){
            Parameter[] parameters = cons.getParameters();
            if (parameters.length == 0){
                isHasEmptyCon = true;
                mapBeans.put(insClass.getSimpleName(), cons.newInstance());
                break;
            }
        }
        if (!isHasEmptyCon) throw new ContainerException(
                String.format("Component class %s dos not have constructor without parameter", insClass.getName()));
        listBeans = new ArrayList<>(mapBeans.values());
    }


    @SuppressWarnings("unchecked")
    public <E> E  lookUpByClass(Class<?> componentClass) {
        if (listBeans.stream().anyMatch(componentClass::isInstance)){
            return (E) listBeans.stream().filter(componentClass::isInstance).findFirst().get();
        } else throw new ContainerException(
                String.format("Component class %s dos not exist", componentClass.getName()));
    }

    private String keyWithoutPackage(String keyWithPackage){
        return keyWithPackage.replace(compSet.getPackageName() + ".", "");
    }
}
