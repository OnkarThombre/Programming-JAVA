package equals_method;

class Student
{
	 private String name;
	 private int age;
	 
	 public Student() 
	 {
		 this("Onkar" , 23);
	 }
	 
	 public Student(String name , int age)
	 {
		 this.name = name;
		 this.age = age; 
	 }
	 
	 public void display()
	 {
		 System.out.println("Name : "+name + ", Age : "+ age );
	 }
	 
	 public boolean equals(Object obj)
	 {
		 if(obj == null)
		 {
			 return false;
		 }
		 
		 if(obj == this)
		 {
			 return true;
		 }
		 
		 if(obj instanceof Student)
		 {
			 Student std = (Student)obj;
			 
			 if(this.age == std.age && this.name.equals(std.name))//this.name == std.name)  on String check on equals() bcz == compares references on string
			 {
				 return true;
			 }
		 }
		 
			 return false;
		 
				 
	 }
}

public class Equals_Method {
	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1.equals(s2));
		
	}
}
