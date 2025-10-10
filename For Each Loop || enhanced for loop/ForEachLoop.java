package forEachLoop;

public class ForEachLoop {
	public static void main(String[] args) {
		int[] arr= {4,5656,47,05,5513,223510,5855,000,41,00,54154,4};
		
		for(int ele : arr)
		{
			System.out.println(ele);
			
			//System.out.println(ele[i];);  compile time error
		}
	}
}


/* output 
4
5656
47
5
5513
223510
5855
0
41
0
54154
4
*/
