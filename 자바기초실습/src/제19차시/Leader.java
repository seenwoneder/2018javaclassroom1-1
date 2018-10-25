package 제19차시;

public class Leader extends Student{

	Leader(String a, String b, boolean c) {
		super(a, b);
		name = a;
	}
	
	void isLeader() {
		System.out.println(name + "은 학생회장이다.");
	}
 
}
