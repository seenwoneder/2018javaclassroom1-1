package 제03차시;

public class 실습02 {

	public static void main(String[] args) {
		String a= "통신과";
		
		String b[]= {"인천","전자","마이스터고"};
		
		String c[]= new String[3];
		c[0]="인천";
		c[1]="전자";
		c[2]="마이스터고";
		
		System.out.println(System.identityHashCode(a) + ":" + a);
		System.out.println(System.identityHashCode(b) + ":" + b[0] + b[1] + b[2]);
		System.out.println(System.identityHashCode(c) + ":" + c[0] + c[1] + c[2]);
		
	 }

}
