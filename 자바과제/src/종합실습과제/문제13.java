package 종합실습과제;

import java.util.Scanner;

public class 문제13 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String a=sc.nextLine();
		
		System.out.printf("직원코드: %s\n",a);
		if(a.charAt(3)==1) {
			System.out.printf("부서: 총무부");
		}
		else if(a.charAt(3)==2) {
			System.out.printf("부서: 인사부");
		}	
		else {
			System.out.printf("부서: 영업부");
			}
		
		sc.close();
		
		}
		

	}

