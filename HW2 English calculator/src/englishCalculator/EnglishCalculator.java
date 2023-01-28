package englishCalculator;
import java.util.Scanner;

public class EnglishCalculator {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n1, n2, result=1;
		char cal;
		String s1=null, s2=null;
		
		n1 = scanner.nextInt();
		n2 = scanner.nextInt();
		cal = scanner.next().charAt(0);
		
		switch(n1) {
		case 0: s1 = "zero"; break;
		case 1: s1 = "one"; break;
		case 2: s1 = "two"; break;
		case 3: s1 = "three"; break;
		case 4: s1 = "four"; break;
		case 5: s1 = "five"; break;
		case 6: s1 = "six"; break;
		case 7: s1 = "seven"; break;
		case 8: s1 = "eight"; break;
		case 9: s1 = "nine"; break;
		}switch(n2) {
		case 0: s2 = "zero"; break;
		case 1: s2 = "one"; break;
		case 2: s2 = "two"; break;
		case 3: s2 = "three"; break;
		case 4: s2 = "four"; break;
		case 5: s2 = "five"; break;
		case 6: s2 = "six"; break;
		case 7: s2 = "seven"; break;
		case 8: s2 = "eight"; break;
		case 9: s2 = "nine"; break;
		}
		
		if(n1>9 || n2>9) {
			System.out.println("invalid number");
		}else if(n1<0 || n2<0){
			System.out.println("invalid number");
		}else {
			if(cal=='+') {
				result = n1+n2;
				System.out.println(s1+" plus "+s2+" is "+result);
			}
			else if(cal=='-') {
				result = n1-n2;
				System.out.println(s1+" minus "+s2+" is "+result);
			}
			else if(cal=='*') {
				result = n1*n2;
				System.out.println(s1+" multiplied by "+s2+" is "+result);
			}
			else if(cal=='/') {
				if(n2==0) {
					System.out.println("division by zero is not allowed");
				}
				else {
					result = n1/n2;
					System.out.println(s1+" divided by "+s2+" is "+result);
				}
			}
			else if(cal=='^') {
				if(n2==0) {
					result = 1;
				}else if(n1==0) {
					result = 0;
				}else {
					for(int i=1; i<=n2; i++) {
						result*=n1;
					}
				}
				System.out.println(s1+" to the power "+s2+" is "+result);
			}
		}	
	}

}
