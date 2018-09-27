package 종합실습과제;

public class 문제19 {

	public static void main(String[] args) {
		int sum = 0;
		int i;
		System.out.printf("1-2+3-4+5-6+7-8+9-10= ");
		for(i=1 ; i<=10 ; i++) {
			if(i%2==0) {
				sum-=i;
			}
			else {
				sum+=i;
			}
		}
		System.out.printf("%d",sum);

	}

}
