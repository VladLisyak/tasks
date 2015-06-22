package tasks;
public class Task1 {

	public static int bracketsCounter(int n)
	{
		//The number of correct pairs of parentheses are expressed by Catalan number which is  
		//calculated by recursive formula of the form: Ñ(n) = sum(C(i)*C(n-i-1))
	    //When n <= 1, C(n) = 1, hence:
	    if (n <= 1) return 1;//Base case: n<=1.
	    
	    int res = 0;//Result variable.
	 
	    //Realization of main formula- sum(C(i)*C(n-i-1))
	    for (int i=0; i<n; i++)
	        res += bracketsCounter(i)*bracketsCounter(n-i-1);
	 
	    return res;
	}
	
	public static void main(String[] args) {
		System.out.println(bracketsCounter(2));
	}
}
