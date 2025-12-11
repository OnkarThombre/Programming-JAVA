package comparator;

import java.util.Arrays;
import java.util.Comparator;

class Employee implements Comparable<Employee>
{
	private int id ;
	private String name;
	private double salary;
	
	public Employee(int id , String name , double salary)
	{
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {
		return this.id - o.id;
	}
	
	@Override
	public String toString() {
		
		return "Employee : [ id : " + id + ", name : " + name + ", sal : " +salary + "]" ;
	}
}

class EmpComparator implements Comparator<Employee>
{
	@Override
	public int compare(Employee o1, Employee o2) {
		
		return  o1.getId() - o2.getId();
	}
}


public class ComparatorClass {
	public static void main(String[] args) {
		Employee[] arr = new Employee[4];
		arr[0] = new Employee(100, "Bnkar", 4500.40);	
		arr[1] = new Employee(2, "Zamesh", 45500.07);
		arr[2] = new Employee(40, "Auresh", 4570.08);
		arr[3] = new Employee(10, "Iinesh", 4575.40);
		
//		Arrays.sort(arr , (a , b) -> a.getName().compareTo(b.getName()));//a.getId() - b.getId());  by lambda
		
//		for (Employee employee : arr) {
//			System.out.println(employee);
//		}
		EmpComparator ecmp = new EmpComparator();
		
		print(arr , ecmp);
		
		
	}
	public static void print(Employee[] arr ,EmpComparator ecmp)
	{
		Arrays.sort(arr , ecmp);
		
		for (Employee employee : arr) {
			System.out.println(employee);
		}
		
	}
	
}

/*
 
 //		Arrays.sort(arr , (a , b) -> a.getName().compareTo(b.getName()));//a.getId() - b.getId());  by lambda
		
//		for (Employee employee : arr) {
//			System.out.println(employee);
//		}

 	we can do directly by lambda here 
 	
 	we are doing sorting so sorting needs that array and the custom sorting logic that means comparator and () it has compare method it infers internally 
 	
 */
