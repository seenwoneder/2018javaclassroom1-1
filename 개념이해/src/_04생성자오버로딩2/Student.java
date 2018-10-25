package _04생성자오버로딩2;

public class Student {

	String name;
	int age;
	Student(){
		this("모름", -1);
	}
	Student(String sname){
		this(name, -1);
	}
	Student(int sage){
		String name"모름";
		this(name,age);
	}
	Student(String sname,int sage){
		
		this.name = sname;
		this.age = sage;
		
	}
	
	void print() {
		
		System.out.println(name + "," + age);
	}
	
}