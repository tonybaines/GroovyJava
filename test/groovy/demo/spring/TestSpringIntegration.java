package groovy.demo.spring;

import groovy.demo.BusinessClient;
import groovy.demo.ComplicatedBusinessInterface;
import junit.framework.TestCase;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpringIntegration extends TestCase {
	private ConfigurableApplicationContext ctx;

	public void setUp() {
		org.apache.log4j.BasicConfigurator.configure();
		this.ctx = new FileSystemXmlApplicationContext("spring-groovy.xml");
	}

	public void tearDown() {
		this.ctx.close();
	}

	public void testShouldAccessAnInlineGroovyBean() {
		ComplicatedBusinessInterface bean = (ComplicatedBusinessInterface) this.ctx.getBean("groovyBean");
		assertEquals(3, bean.addUp(1, 2));

		assertEquals("groovy.demo.GroovyAdder", bean.getClass().getCanonicalName());
	}

	public void testShouldUseASuccessfullyCreatedDependantJavaObject() {
		BusinessClient client = (BusinessClient) this.ctx.getBean("client");
		assertEquals(7, client.myComplicatedOperation(1, 2, 4));
	}
}
