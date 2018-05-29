package org.titanium.reports;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(JyperionListener.class)
public class PdfEmail extends BaseClass {

    @Test
    public void testOne(){
        getDriver().get("https://www.google.com.mx");
        Assert.assertTrue(false);
    }

    @Test
    public void testTwo(){
        getDriver().get("https://www.facebook.com/");
        Assert.assertTrue(true);
    }

     @Test
    public void testThree(){
        getDriver().get("https://titaniumsolutions.org/");
        Assert.assertTrue(false);
     }

     @AfterTest
    public void closeBrowser(){
        getDriver().close();
     }

     @AfterSuite
    public void sendEmail(){
        sendPdfReportByEmail("titaniumsoltest@gmail.com", "titanium619", "titaniumsoltest@gmail.com", "Gilberto PDF Report", "Please Find Attached the pdf report");
     }
}
