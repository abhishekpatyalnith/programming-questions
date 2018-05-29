
public class IsPalindromeNumber {

	static int isIntPalindrome(int x)
	{
	    if (x < 0)
	    return 0;
	    int div = 1;
	    while (x / div >= 10)
	    {
	        div *= 10;
	    }
	 
	    while (x != 0)
	    {
	        int l = x / div;
	        int r = x % 10;
	        if (l != r)
	            return 0;
	        x = (x % div) / 10;
	        div /= 100;
	    }
	    return 1;
	}
	
	public static void main(String[] args) {
		System.out.println(isIntPalindrome(63236));
	}
}
