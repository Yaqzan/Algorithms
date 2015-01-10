/* Yaqzan Ali - yali6
 * CS3340 Assignment 1
 * Calculates the first 300 Fiboancci Numbers using O(n) Time complexity
 */
public class asn1_b {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		for(int i=0;i<31;i++){
			System.out.println("F("+i*10+") = "+ fib2(i*10));
		}
		long endTime = System.nanoTime();
		long duration = endTime - startTime;
		System.out.println("This took "+ duration + " nanoseconds");
	}

	public static BigInt fib2 (int n){
		BigInt a = new BigInt(0);
		BigInt b = new BigInt(1);
		BigInt c = new BigInt(1);
		int i;
		  if( n == 0)
		    return a;
		  for (i = 2; i <= n; i++)
		  {

		     c = new BigInt(a.getValue() , b.getValue());
		     a.setValue(b.getValue());
		     b.setValue(c.getValue());
		  }
		  return c;
	}
}
