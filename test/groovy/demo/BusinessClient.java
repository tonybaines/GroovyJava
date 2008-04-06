package groovy.demo;

public class BusinessClient {
	private final ComplicatedBusinessInterface logic;

	public BusinessClient(ComplicatedBusinessInterface logic) {
		this.logic = logic;
	}

	public int myComplicatedOperation(int a, int b, int c) {
		int tempResult = this.logic.addUp(a, b);
		return this.logic.addUp(tempResult, c);
	}
}
