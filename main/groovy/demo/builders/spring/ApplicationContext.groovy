package groovy.demo.builders.spring

import org.apache.commons.dbcp.BasicDataSource
import org.codehaus.groovy.grails.orm.hibernate.ConfigurableLocalSessionFactoryBean;
import org.codehaus.groovy.grails.commons.spring.GrailsApplicationContext;
import org.hibernate.SessionFactory

def bb = new grails.spring.BeanBuilder()

bb.beans {
	dataSource(BasicDataSource) {
		driverClassName = "org.hsqldb.jdbcDriver"
		url = "jdbc:hsqldb:mem:grailsDB"
		username = "sa"
		password = ""
	}

    sessionFactory(ConfigurableLocalSessionFactoryBean) {
          dataSource = dataSource
          hibernateProperties = [ "hibernate.hbm2ddl.auto":"create-drop",
                                  "hibernate.show_sql":true  ]
    }

}

GrailsApplicationContext appContext = bb.createApplicationContext()

// Retrieve and use a bean (no need to cast)
def sessionFactory = appContext.getBean('sessionFactory')

def session = sessionFactory.openSession();
assert session.open
session.close()
assert session.closed

/*
Roughly equivalent to:
<beans>
	<bean id="dataSource" class="org.apache.commons.dbcp.BasicDataSource">
		<property name="driverClassName" value="org.hsqldb.jdbcDriver" />
		<property name="url" value="jdbc:hsqldb:mem:grailsDB" />
		<property name="username" value="sa" />
		<property name="password" value="" />
	</bean>

	<bean id="sessionFactory" class="org.codehaus.groovy.grails.orm.hibernate.ConfigurableLocalSessionFactoryBean">
		<property name="dataSource" value="dataSource" />
		<property name="hibernateProperties">
			<props>
				<prop key="hibernate.hbm2ddl.auto">create-drop</prop>
				<prop key="hibernate.show_sql">true</prop>
			</props>
		</property>
	</bean>
</beans>
 */
