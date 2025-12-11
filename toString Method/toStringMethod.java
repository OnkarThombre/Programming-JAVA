package toStringMethod;

import java.util.Arrays;

class Student
{
	int age;
	String name;
	
	Student()
	{
		this(00, "null");
	}
	
	Student(int age , String name)
	{
		this.age = age;
		this.name = name;
	}
	
	public String toString()
	{
		return "Name : " + name + ", Age :" + age; 
	}
	
}

public class ToStringMethod {
	public static void main(String[] args) {
		Student s1 = new Student();
		
		System.out.println(s1);
		
		int arr[] = new int[1];
		
		System.out.println(Arrays.toString(arr)); // [0]  o/p in proper way
//		System.out.println(arr);  // o/p => [I@31befd9f
		
	}
}
