package _03객체지향언어의특징_다형성;

import java.awt.Color;

import javax.swing.JFrame;

public class Main {
	public static void main (String[] args) {
		Test1 t = new Test1();
		t.print(1, 1);
		t.print(1, "1");
		t.print("1", 1);
		t.print("1", "1");
		t.bark();
	}

}
