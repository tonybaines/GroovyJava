package groovy.demo

class SimpleBean {
	def propertyA
	def propertyB
}

SimpleBean bean = new SimpleBean();
bean.setPropertyA("A");
bean.setPropertyB(1);

assert bean.getPropertyA().equals("A");
assert bean.getPropertyB().equals(1);

System.out.println("Property A: " + bean.getPropertyA());
System.out.println("Property B: " + bean.getPropertyB());