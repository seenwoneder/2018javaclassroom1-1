package 종합실습과제;

import java.util.Scanner;

public class 문제16 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.printf("두 정수: %d %d\n",a,b);
			for(int i=a; i<=b; i++) {
				System.out.print(i + " ");
			}
			sc.close();
	}

}
