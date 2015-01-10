/* Yaqzan Ali - yali6
 * CS3340 Assignment 1
 * This class is meant only for holding big numbers, that exceed the integer capacity
 * The only operation it can do is add two numbers. That is all that is required for the Fibonacci Sequence
 */
public class BigInt {
	
	private int[] integers;
	private int length;
	private int longNumLength;
	private int shortNumLength;
	public BigInt(int[] x){
		integers = x;
	}
	public BigInt (int x){
		
		String strNum = Integer.toString(x);
		length= strNum.length();
		integers = new int[length];
		char c;
		int j = strNum.length()-1;
		for(int i = 0; i< length ;i++){
			 
			c = strNum.charAt(i);
			integers[j] = c - 48;
			j--;
		}
		
	}
	
	public BigInt (int[] x, int[]y){
		int r=0;
			
		if ((x.length == y.length) && (x[x.length-1]+y[y.length-1] >8)){
//			System.out.println("a");
			for (int i=0; i<x.length ; i++){
				if ((x[i]+y[i] + r) > 9){
					r = 1;
				}else{r = 0;}
			}
			
			if (r ==0){	length= x.length;}
			else{length= x.length+1;}
			
		}else if ((x.length == y.length) && ((x[x.length-1]+y[y.length-1]) <=8)){
//			System.out.println("b");
			length = x.length;
		}else if ((x.length> y.length) && x[x.length-1]< 8){
			length = x.length;
//			System.out.println("c");
		}else if ((y.length> x.length) && y[y.length-1]<= 8){
			length = y.length;
//			System.out.println("d");
		}else if ((x.length> y.length) && x[x.length-1]> 8){
//			System.out.println("e");
			int i;
			for (i=0; i<y.length ; i++){
				if ((x[i]+y[i] + r) > 9){
					r = 1;
				}else{r = 0;}
			}
			for(i=i; i<x.length; i++){
				if ((x[i] + r) > 9){
					r = 1;
				}else{r = 0;}
			}
			if (r ==0){	length= x.length;}
			else{length= x.length+1;}
			
		}else if ((y.length> x.length) && y[y.length-1]> 8){
//			System.out.println("f");
			int i;
			for (i=0; i<x.length ; i++){
				if ((x[i]+y[i] + r) > 9){
					r = 1;
				}else{r = 0;}
			}
			for(i=i; i<y.length; i++){
				if ((y[i] + r) > 9){
					r = 1;
				}else{r = 0;}
			}
			if (r ==0){	length= y.length;}
			else{length= y.length+1;}
		}
		
		integers = new int[length];
		r=0;
		int sum;
		int i;
		for (i=0; i<(Math.min(x.length, y.length));i++){
			if ((x[i]+y[i] + r) > 9){
				sum =(x[i]+y[i] + r);
				integers[i] = (sum % 10);
				r = 1;
			}else{
//				System.out.println(i);
//				System.out.println(x[i]);
//				System.out.println(y[i]);
				integers[i] = x[i] + y[i] + r;
				r = 0;
			}
		}
		if (x.length>y.length){
			for(i=i; i<x.length; i++){
				if ((x[i] + r) > 9){
					integers[i] = 0;
					r = 1;
				}else{
					integers[i] = x[i] + r;
					r = 0;
				}
			}
		}else if (x.length<y.length){
			for(i=i; i<y.length; i++){
				if ((y[i] + r) > 9){
					integers[i] = 0;
					r = 1;
				}else{
					integers[i] = y[i] + r;
					r = 0;
				}
			}	
		}
		if (r==1)
			integers[i]=1;
		
	}

	public String toString(){
		String output = "";
		for(int i = 0; i < length; i++){
			output = integers[i]+output ;
		}
		return output;
		
	}
	
	public void setValue(int[] x){
		integers = x;
	}
	
	public int[] getValue(){
		return integers;
	}

	public int getLength(){
		return length;
	}
	public int toInteger(){
		String output = "";
		for(int i = 0; i < length; i++){
			output = integers[i]+output ;
		}
		return Integer.parseInt(output);
	}

}
