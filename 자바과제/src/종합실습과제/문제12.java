package 종합실습과제;

import java.util.Scanner;

public class 문제12 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int c=(a+b)/2;
		System.out.printf("두 과목: %d %d\n",a,b);
		if(c>=60 && (a>=40 && b>=40)) {
			System.out.printf("결과: 합격");
		}
		else if(c>=60 && (a<40 || b<40)) {
				System.out.printf("결과: 불합격(과락)");
		}
			
		else {
				System.out.printf("결과: 불합격");
		}
		
		sc.close();
	
	  }
		


}
