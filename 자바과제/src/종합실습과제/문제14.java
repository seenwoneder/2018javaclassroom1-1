package 종합실습과제;

import java.util.Scanner;

public class 문제14 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
			int a =sc.nextInt();
			int day;
			System.out.printf("월: %d\n",a);
			switch(a) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			day = 31;  break;
			case 4: case 6: case 9: case 11:
			day = 30; break;
			default : day = 28;
			}
			System.out.println(a + "월의 마지막 날은" + day + "일입니다.");
				
			sc.close();
		}

	}

