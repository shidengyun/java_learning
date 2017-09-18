package demo;

public class DrunkException extends Exception{
	
	public DrunkException() {
		
	}
	public DrunkException(String message) {
		System.out.println(message);
	}
}