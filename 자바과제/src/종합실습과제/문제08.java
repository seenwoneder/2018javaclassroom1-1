package 종합실습과제;

import java.util.Scanner;

public class 문제08 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		sc.useDelimiter("\r|\n|,");
		int a=sc.nextInt();
		System.out.printf("정수: %d\n",a);
		System.out.printf("절댓값: %d", a<0 ? (a*-1) : a);
		
		sc.close();
	}

}
