package 종합실습과제;

import java.util.Scanner;

public class 문제22 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int cnt=0;
		System.out.printf("약수: ");
		for(int i=1; i<=n; i++) {
			if(n%i==0) {
				cnt++;
				System.out.printf("%d ",i);
			}
		}
		System.out.printf("\n");
		System.out.printf("약수의 갯수: %d",cnt);
		
		sc.close();

	}

}
