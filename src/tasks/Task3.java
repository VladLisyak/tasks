package tasks;
import java.math.BigInteger;


  public class Task3 {
   
	  //The number of 100! is too big for Integer, 
	  //it is better to use a BigInteger data type;  
	  public static int oneHundSumCounter(){
		  BigInteger fact = BigInteger.ONE;//variable for factorial count  
		  
		  //factorial counting loop
		  for (int i = 1; i <= 100; i++) {
			 fact = fact.multiply(BigInteger.valueOf(i));
		  }
		  //String value of factorial for easier counting of it's sum
		  String nums = fact.toString();
		  //variable for result - sum of numbers in 100!
		  int counter = 0;
		  //sum counting loop
		  for (int i = 0; i < nums.length(); i++) {
			counter+=Integer.parseInt(String.valueOf(nums.charAt(i)));
		  }
		  return counter;
	  }
	  
	  
	  public static void main(String[] args) {
		System.out.println(oneHundSumCounter());
	}
}

