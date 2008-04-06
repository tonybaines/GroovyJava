package groovy.demo.spring;

import static org.junit.Assert.*;

import org.junit.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestSpringIntegration {
	private ConfigurableApplicationContext ctx;

	@Before
	public void setUp() {
		org.apache.log4j.BasicConfigurator.configure();
		this.ctx = new FileSystemXmlApplicationContext("spring-groovy.xml");
	}

	@After
	public void tearDown() {
		this.ctx.close();
	}

	@Test
	public void shouldAccessAnInlineGroovyBean() {
		ComplicatedBusinessInterface bean = (ComplicatedBusinessInterface) this.ctx.getBean("groovyBean");
		assertEquals(3, bean.add(1, 2));

		assertEquals("groovy.demo.spring.GroovyAdder", bean.getClass().getCanonicalName());
	}
}
