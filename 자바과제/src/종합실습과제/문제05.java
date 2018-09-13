package 종합실습과제;

import java.util.Scanner;

public class 문제05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt(); 
		int h = a/3600;
		int m = (a%3600)/60;
		int s = (a%3600)%60;
		
		
		System.out.printf("%02d시 %02d분 %02d초", h, m, s);

		sc.close();
	}

}
