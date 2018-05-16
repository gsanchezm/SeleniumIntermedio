package org.titanium.intermedio;

import org.testng.annotations.*;

public class TestNGAnnotations {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Este método se ejecuta antes de una suite de pruebas");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Éste método se ejecuta antes de las pruebas @Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Éste método se ejecuta antes de la clase");
    }

    @BeforeMethod
    public void beforeMetod(){
        System.out.println("Se ejecuta antes de cada método de prueba @Test");
    }

    @Test
    public void testCase1(){
        System.out.println("Caso de prueba 1");
    }

    @Test
    public void testCase2(){
        System.out.println("Caso de prueba 2");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("Se ejecuta despues de cada método de prueba");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("ëste método se ejecuta despues de la clase");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("Éste método se ejecuta despues de todas las pruebas");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("Éste método se ejecuta despues de una suite de pruebas");
    }
}
