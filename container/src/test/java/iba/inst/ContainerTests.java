package iba.inst;

import iba.inst.container.DiConfig;
import iba.inst.container.SearchComponentBeans;
import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class ContainerTests {

    @Test
    public void SearchComponentsTest(){
        SearchComponentBeans beans = new SearchComponentBeans(null);
        Set<Class<?>> classesByPackage = beans.getClassesByPackage();
        Assert.assertEquals(beans.getContextPath(), "");
        Assert.assertEquals(classesByPackage.size(), 3);

        SearchComponentBeans beans1 = new SearchComponentBeans("iba.inst");
        Set<Class<?>> classesByPackage1 = beans1.getClassesByPackage();
        Assert.assertEquals(beans1.getContextPath(), "iba/inst");
        Assert.assertEquals(classesByPackage1.size(), 3);

        SearchComponentBeans beans2 = new SearchComponentBeans("");
        Set<Class<?>> classesByPackage2 = beans2.getClassesByPackage();
        Assert.assertEquals(beans2.getContextPath(), "");
        Assert.assertEquals(classesByPackage2.size(), 3);
    }

    @Test
    public void InjectComponentTest(){
        DiConfig conf = new DiConfig("iba.inst");
        PuperTestClass pup = conf.lookUpByClass(PuperTestClass.class);
        Assert.assertEquals(pup.getSuperTestClass(), conf.lookUpByClass(SuperTestClass.class));
    }


}
