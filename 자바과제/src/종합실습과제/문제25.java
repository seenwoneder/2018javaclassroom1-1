package 종합실습과제;

import java.util.Scanner;

public class 문제25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int i,sum = 0;
		System.out.printf("자연수 n: %d\n",n);
		for(i=1 ; i<=n ; i++) {
			sum+=i;
			System.out.printf("%d ",sum);
		}

	}

}
