package 종합실습과제;

import java.util.Scanner;

public class 문제26 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i,sum = 0;
		int mul = 1;
		System.out.printf("수열: ");
		for(i=1;i<=n;i++) {
			mul*=i;
			System.out.printf("%d ", mul);
			sum+=mul;
		}
		System.out.printf("\n");
		System.out.printf("수열의 합: %d", sum);
		
		sc.close();
	}

}
