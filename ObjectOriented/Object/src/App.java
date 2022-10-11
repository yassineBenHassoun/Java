import java.io.*;

public class App 
{
	public static void main(String[] args) throws Exception {

		BadNumberException r = new BadNumberException("l");
		System.out.println(r.g(0));
		System.out.println(r.g(-20));
		System.out.println(r.g(20));



	}




}

class BadNumberException extends Exception {
	public BadNumberException(String msg) {
	    super(msg);
	}


void f(int a) throws Exception {
	if (a < 0) {
	    throw new BadNumberException("Number is negative !");
	} else if (a == 0) {
	    throw new BadNumberException("Number is zero !");
	} else {
	    System.out.println("The provided number is OK!");
	}
}

boolean g(int a) {
	try {
		f(a);
	} catch(Exception e) {
		System.out.println("Error occured: " + e.getMessage());
		return false;
	} finally {
		System.out.println("Finally here !");
	}
	return true;
}
}
