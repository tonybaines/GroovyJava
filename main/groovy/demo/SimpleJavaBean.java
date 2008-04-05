package groovy.demo;

public class SimpleJavaBean {
	private String propertyA;
	private Integer propertyB;

	public String getPropertyA() {
		return propertyA;
	}

	public void setPropertyA(String propertyA) {
		this.propertyA = propertyA;
	}

	public Integer getPropertyB() {
		return propertyB;
	}

	public void setPropertyB(Integer propertyB) {
		this.propertyB = propertyB;
	}


	public static void main(String[] args) {
		// First with the Java bean
		SimpleJavaBean jbean = new SimpleJavaBean();
		jbean.setPropertyA("A");
		jbean.setPropertyB(1);

		assert jbean.getPropertyA().equals("A");
		assert jbean.getPropertyB().equals(1);

		System.out.println("Property A: " + jbean.getPropertyA());
		System.out.println("Property B: " + jbean.getPropertyB());

		// Now with the Groovy bean
		SimpleGroovyBean gbean = new SimpleGroovyBean();
		gbean.setPropertyA("A");
		gbean.setPropertyB(1);

		assert gbean.getPropertyA().equals("A");
		assert gbean.getPropertyB().equals(1);

		System.out.println("Property A: " + gbean.getPropertyA());
		System.out.println("Property B: " + gbean.getPropertyB());
	}
}
