package dzsw;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
	
   public static void main(String args[]) {
		/*
		 * String a="a"; for(int i=0;i<26;i++) { a=a+1; System.out.print("'"+a+"',"); }
		 */
	   System.out.println("mima:");
	   System.out.println(new BCryptPasswordEncoder().encode("1234"));
	   
   }
}
