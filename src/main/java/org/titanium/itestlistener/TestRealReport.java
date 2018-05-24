package org.titanium.itestlistener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(RealTimeReport.class)
public class TestRealReport {
    @Test
    public void testOne(){
        Assert.assertTrue(true);
    }

    @Test
    public void testTwo(){
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = {"testTwo"})
    public void testThree(){
        Assert.assertTrue(true);
    }
}
