package _04생성자오버로딩2;

public class Student {

	String name;
	int age;
	
	
	Student(){
		name = "모름"
		age = -1;
		//this("모름", -1);
	}
	
	Student(String name){
		this(name, -1);
	}
	
	Student(int age){
		this("모름", age);
	}
	
	Student(String name,int age){
		
		this.name = name;
		this.age = age;
		
	}
	
	void print() {
		
		System.out.println(name + "," + age);
		
	}
	
}