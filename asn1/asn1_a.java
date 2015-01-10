/* Yaqzan Ali - yali6
 * CS3340 Assignment 1
 * Calculates the first 30 Fiboancci Numbers using O(2^n) Time complexity
 */
public class asn1_a {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		for(int i=0;i<8;i++){
			System.out.println("F("+i*5+") = "+ fib1(i*5));
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("This took "+ duration + " nanoseconds");
	}
	public static int fib1 (int i){
		if (i==1 || i==2)
			return 1;
		else if(i==0)
			return 0;
		else
			return (fib1(i-1)+ fib1(i-2));
	}
	
}
