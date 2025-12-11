package comparable__comparator;

class Student implements Comparable<Student>{
	private int id ; 
	private String name;
	
	public Student() 
	 {
		 this(7 , "Onkar");
	 }
	 
	 public Student( int id , String name )
	 {
		 this.name = name;
		 this.id = id; 
	 }
	 
	 public void display()
	 {
		 System.out.println("Name : "+name + ", Id : "+ id );
	 }
	 
	 @Override
	public int compareTo(Student obj) {
		
//		 if(this.id == obj.id)
//		 {
//			 return 0;
//		 }
//		 if(this.id > obj.id)
//		 {
//			 return 1;
//		 }
//		 else {
//			 return -1;
//		 }
		return this.id - obj.id;
	}
}

public class Comparable_Class {
	public static void main(String[] args) {
		Student s1 = new Student(1, "Onkar");
		Student s2 = new Student(7 , "Omkar");
		
		System.out.println(s1.compareTo(s2));
	}
}
