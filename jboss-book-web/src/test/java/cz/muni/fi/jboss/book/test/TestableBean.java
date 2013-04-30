package cz.muni.fi.jboss.book.test;

import java.io.Serializable;
import java.math.BigInteger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

@ApplicationScoped
@Named("testable")
public class TestableBean implements Serializable {


	private static final long serialVersionUID = -9210441178590159602L;

	private BigInteger superSecretModulus;
	
	@Inject
	TestableBean2 bean;
	
	public TestableBean() {
		// TODO Auto-generated constructor stub
	}
	
	@PostConstruct
	private void generateModulus() {
		superSecretModulus = BigInteger.valueOf(13);
	}
	
	public BigInteger getModSquare(long num) {
		return BigInteger.valueOf(num).modPow(BigInteger.valueOf(2), superSecretModulus);
		
	}
	public boolean getTrue() {
		return bean != null ? bean.getTrue() : false;
			
	}

}
