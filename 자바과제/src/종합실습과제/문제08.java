package 종합실습과제;

import java.util.Scanner;

public class 문제08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		if(a<0) {
			System.out.printf("절댓값: %d", a*-1);
		}
		else {
			System.out.printf("절댓값: %d", a);
		}

	}

}
