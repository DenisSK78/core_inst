package iba.inst;

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
        Assert.assertEquals(classesByPackage.size(), 2);

        SearchComponentBeans beans1 = new SearchComponentBeans("iba.inst");
        Set<Class<?>> classesByPackage1 = beans.getClassesByPackage();
        Assert.assertEquals(beans1.getContextPath(), "iba/inst");
        Assert.assertEquals(classesByPackage1.size(), 2);

        SearchComponentBeans beans2 = new SearchComponentBeans("");
        Set<Class<?>> classesByPackage2 = beans.getClassesByPackage();
        Assert.assertEquals(beans2.getContextPath(), "");
        Assert.assertEquals(classesByPackage2.size(), 2);
    }
}
