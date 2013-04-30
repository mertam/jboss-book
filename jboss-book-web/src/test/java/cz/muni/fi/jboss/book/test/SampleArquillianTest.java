package cz.muni.fi.jboss.book.test;


import java.math.BigInteger;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class SampleArquillianTest {

    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar =  ShrinkWrap.create(JavaArchive.class)
            .addClass(TestableBean.class)
            .addClass(TestableBean2.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        System.out.println(jar.toString(true));
        return jar;
    }
    
    @Inject
    TestableBean testable;

    @Test
    public void testInject() {
    	Assert.assertNotNull(testable);
    	Assert.assertTrue(testable.getModSquare(5).equals(BigInteger.valueOf(12)));
    }
    
    @Test
    public void sampleServerTest() {
        System.out.println("running on server");
    	Assert.assertTrue(true);
    }

    @Test
    public void testBeanInject() {
    	Assert.assertTrue(testable.getTrue());
    }
    
    @Test 
    @RunAsClient
    public void sampleLocalTest() {
    	System.out.println("running local");
    	Assert.assertFalse(false);
    }
    

}
