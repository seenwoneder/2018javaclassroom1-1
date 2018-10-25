package 제10차시;

public class MemberExam {

	public static void main(String[] args) {
		Student kim = new Student();
		kim.name = "김현우";
		kim.grade = 2;
		kim.telephone = "111-1111";
		System.out.println("학생의 이름은 " + kim.name + "이고, " + "학년은" + kim.grade + "이고, 전화번호는 " + kim.telephone + "입니다.");

	}

}
