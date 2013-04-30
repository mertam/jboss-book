package cz.muni.fi.jboss.book.test;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TestableBean2 implements Serializable {


	private static final long serialVersionUID = 1942434018575048420L;

	public TestableBean2() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean getTrue() {
		return true;
	}

}
