package 종합실습과제;

import java.util.Scanner;

public class 문제04 {
	public static void main(String[] args) {
			Scanner sc=new Scanner(System.in);
			String a=sc.next();
			System.out.println( (char)(a.charAt(0)-32)  );
			sc.close();
		}
	}
