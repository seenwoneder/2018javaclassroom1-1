package 제07_1;

public class Main {

	public static void main(String[] args) {
		Car myCar = new Car();
		
		//myCar 객체의 필드(속성, 멤버변수)들을 지정하세요.
		myCar.제조사 = "람보르기니";
		myCar.차종 = "람보르기니 아벤타도르  S 로드스터";
		myCar.차량색상 = "파란색";
		myCar.차량번호 = "11도 0527";
		myCar.연비 = 18.4/100;
		myCar.배기량 = 6498;
		myCar.차량소유자 = "서예주";
		myCar.주행가능거리 = 100;
		myCar.현재속도 = 200;
		myCar.현재연비 = 15/100;
		
		//myCar 객체의 필드 값들을 모두 출력하세요.
		System.out.println(myCar.제조사);
		System.out.println(myCar.차종);
		System.out.println(myCar.차량번호);
		System.out.println(myCar.연비);
		System.out.println(myCar.배기량);
		System.out.println(myCar.차량소유자);
		System.out.println(myCar.주행가능거리);
		System.out.println(myCar.현재속도+"km"+"/"+"h");
		System.out.printf("%.2f",myCar.현재연비);
		
		//myCar 객체의 메소드를 호출하여 동작시키세요.
		myCar.시동건다();
		myCar.기어변속한다();
		myCar.속도조절한다();
		myCar.방향전환한다();
		myCar.방향지시등켠다();
		myCar.비상등켠다();
		myCar.경적울린다();
		myCar.연료주입구연다();
		myCar.후드연다();
		myCar.선루프연다();
		myCar.트렁크연다();
	}

}
