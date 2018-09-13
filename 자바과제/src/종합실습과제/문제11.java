package 종합실습과제;

import java.util.Scanner;

public class 문제11 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		sc.useDelimiter("\r|\n|,");
		
		int x1,y1,z1,x2,y2,z2;
		System.out.printf("원(x1,y1,z1): ");
		x1=sc.nextInt();
		y1=sc.nextInt();
		z1=sc.nextInt();
		
		System.out.printf("원(x2,y2,z2): ");
		x2=sc.nextInt();
		y2=sc.nextInt();
		z2=sc.nextInt();
	}

}
