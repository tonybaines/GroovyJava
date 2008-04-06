package groovy.demo

public class SimpleGroovyBean {
	def propertyA, propertyB
}

// First with the Groovy bean
//   def gbean = new SimpleGroovyBean()
//   gbean.setPropertyA("A")
//   gbean.setPropertyB(1)
def gbean = new SimpleGroovyBean(propertyA: "A", propertyB: 1)


// Double equals equivalent to .equals()
assert gbean.propertyA == "A"
assert gbean.propertyB == 1

// GStrings support expansion
System.out.println("Property A: ${gbean.propertyA}");
System.out.println("Property B: ${gbean.propertyB}");

// Now with the Java bean
def jbean = new SimpleJavaBean(propertyA: "A", propertyB: 1)

assert jbean.propertyA == "A"
assert jbean.propertyB == 1

System.out.println("Property A: ${jbean.propertyA}");
System.out.println("Property B: ${jbean.propertyB}");
