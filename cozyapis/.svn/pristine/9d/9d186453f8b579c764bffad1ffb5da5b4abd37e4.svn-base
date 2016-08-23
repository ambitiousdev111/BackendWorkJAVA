package in.cozynest.cozyapis.test;

import java.util.Scanner;

public class PrimeNumber {
	
	public static void main(String gg[]) {
		try {
			System.out.print("Enter an integer value : ");
			Scanner scan = new Scanner(System.in);
			int i = Integer.parseInt(scan.nextLine());
			scan.close();
			boolean found=false;
			for(int j=2;j<=i/2;j++) {
				if(i%j==0) {
					found=true;
					break;
				}
			}
			if(found) System.out.println("Not a prime number");
			else System.out.println("Prime number");
		}catch(NumberFormatException nfe) {
			System.out.println("Enter valid integer");
		}
	}

}
