package 종합실습과제;

import java.util.Scanner;

public class 문제15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.printf("프로 점수: %d\n",a);
		switch(a/10) {
		case 10:
		case 9:
		System.out.printf("등급: A");
		break;
		case 8:
		System.out.printf("등급: B");
		break;
		case 7:
		System.out.printf("등급: C");
		break;
		case 6:
		System.out.printf("등급: D");
		break;
		
		default:
		System.out.printf("등급: E");
		
		} sc.close();

	}

}
