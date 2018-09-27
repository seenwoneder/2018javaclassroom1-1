package 종합실습과제;

import java.util.Scanner;

public class 문제21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int sum=0;
		System.out.printf("자연수 n: %d\n",n);
		for(int i=1 ; i<=n ; i++) {
			sum+=i*i;
		}
		System.out.printf("결과: %d",sum); 
		sc.close();
	}

}
