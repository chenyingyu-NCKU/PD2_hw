package primeNum;
import java.util.Scanner;

//you got a 60/100 in this program, this is the corrected version. _(:3」z)_

public class PrimeNumber {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
        int number = keyboard.nextInt();
        boolean check = true;
        int primeNumber = 0;
        
        for(int i = number-1; i>1; i--, check = true) {
        	for(int j = 2; j<i; j++) {
        		if(i%j == 0) {
        			check = false;
        		}
        	}
        	if(check) {
        		primeNumber = i;
        		break;
        	}
        }
        System.out.println(primeNumber);
	}

}
