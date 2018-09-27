package 종합실습과제;

public class 문제23 {

	public static void main(String[] args) {
		int cnt=0;
		int sum=0;
		for(int i=0; i<1000; i++) {
			if(i%3==0 || i%5==0) {
				cnt++;
				sum+=i;
			}
		}
		System.out.printf("갯수: %d\n",cnt);
		System.out.printf("합계: %d",sum);

	}

}
