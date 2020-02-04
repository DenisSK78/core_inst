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
        Assert.assertEquals(beans.getContextPath(), "iba/inst");
        Assert.assertEquals(classesByPackage.size(), 2);
    }
}
