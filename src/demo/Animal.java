package demo;

public class Animal{

	public void test(int i) {
		if(i==0) {
			throw new DrunkException("i not = 0");
		}
	}
	
	public void eat() {
		System.out.println("Animal eat");
	}
}




