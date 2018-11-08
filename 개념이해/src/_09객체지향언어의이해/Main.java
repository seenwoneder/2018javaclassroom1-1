package _09객체지향언어의이해;

public class Main {

	public static void main(String[] args) {
		자식 mySon1 = new 자식();
		부모 myFather1 = new 부모();
		
		mySon1.speak();
		myFather1.speak();
		
		myFather1 = mySon1;
		myFather1.speak();
		
		mySon1 = (자식)myFather1;
		mySon1.speak();
		
	}

}
