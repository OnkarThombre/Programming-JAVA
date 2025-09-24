class Demo
{
    static private int x = 10;                                             //private int x = 10;
    public static void show()
    {                                       // non-static variable x cannot be referenced from a static context 
        System.out.println("Myself Onkar" + x);
    }
}
public class Main
{
	public static void main(String[] args) {
        // Demo d = new Demo();
		//d.show();// Works, but not recommended static method can be call using object also 
		Demo.show();  // static  method is get called without creating object of that class
		System.out.println(Demo.x);  // static field, so able to call on class name
		
// 		static private int x = 10;   // if we create private though it is static but it is private so not accessible
// 		System.out.println(Demo.x);  // x has private access in Demo
		
	}
}
