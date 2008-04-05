package groovy.demo;

public class SimpleBean {
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
		SimpleBean bean = new SimpleBean();
		bean.setPropertyA("A");
		bean.setPropertyB(1);

		assert bean.getPropertyA().equals("A");
		assert bean.getPropertyB().equals(1);

		System.out.println("Property A: " + bean.getPropertyA());
		System.out.println("Property B: " + bean.getPropertyB());
	}
}
