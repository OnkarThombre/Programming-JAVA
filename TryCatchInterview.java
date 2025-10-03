
public class TryCatch {
	public static void main(String[] args) {
		try {
			int res = 5/0;
		}
		finally {
			System.out.println("onkar thombre");
		}
		// 1. Only writing try block is compile time error not allowed
		// 2. we can skip either catch or finally block
		
		
	}
}
/*
 * normally  
 * 
 * int res = 5/0; outside try catch block
 * 
 * Exception in thread "main" java.lang.ArithmeticException: / by zero
	at TryCatch.main(TryCatch.java:10)
 */

//-----------------------------------------------
/*
 	try {
			int res = 5/0;      // after exception program is not terminated control goes in catch block so program
								is successfully executed because exception is handled in catch block and then after 
								finally block get executed so see th output 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			System.out.println("onkar thombre");
		}
		output =>
		java.lang.ArithmeticException: / by zero
				at TryCatch.main(TryCatch.java:5)
		onkar thombre
	
	
	✅ Explanation:

5/0 → throws ArithmeticException.

catch(Exception e) catches it → prints stack trace.
(So program is not terminated abruptly, exception is handled.)

finally always executes → "onkar thombre".

Program ends normally.
  
 */

//-----------------------------------------------------
/*
 
 try {
			int res = 5/0;
		}
		finally {
			System.out.println("onkar thombre");
		}
		o/p =>
		onkar thombre
	Exception in thread "main" java.lang.ArithmeticException: / by zero
	at TryCatch.main(TryCatch.java:5)

✅ Explanation:

5/0 → throws ArithmeticException.

No catch → so exception is not handled.

Before propagating the exception, finally executes → "onkar thombre".

After that, exception goes up to JVM → program terminates abnormally.
 
 */


/*
 
 Main difference (termination vs no termination):

With catch:

Exception is handled, so program ends normally.

finally still executes before program exit.

Without catch:

Exception is not handled, JVM terminates the program after executing finally.
 
 */
