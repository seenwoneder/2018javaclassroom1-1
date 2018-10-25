package 제18차시;

public class TrunckMain {

	public static void main(String[] args) {
		Trunk myTrunk = new Trunk();
		myTrunk.carName = "프로니어";
		myTrunk.ton = 3;
		System.out.println("나의 트럭은 " + myTrunk.color + "이다");
		System.out.println(myTrunk.carName + "는 " + myTrunk.ton + "톤을 실을 수 있다.");

	}

}
