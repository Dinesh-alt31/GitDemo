package InterviewQns;

public class StringCheckStrIsPalindromeOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        String s1 = "abc";
        String s2 = "";
        System.out.println(s1.length());
        for(int i = s1.length()-1;i>=0;i--)
        {
            s2 = s2 + s1.charAt(i);
        }
        
        if(s1.equals(s2))
        {
            System.out.println("Palindrome");
        }
        else
                {
            System.out.println("Not Palindrome");
        }
        //other way
        String s4 = "Madam";
        String s3 = s4.toLowerCase();
        boolean res = true;
        for(int i = 0;i<s3.length()/2; i++)
        {
            if(s3.charAt(i) != s3.charAt(s3.length()-i-1))
            {
                res = false;
                break;
            }
        }
        if(res)
                {
            System.out.println("Palindrome");
        }
        else
                {
            System.out.println("Not Palindrome");
        }
        
        //other way
        String ss = "abc";
        StringBuffer sb1 = new StringBuffer(ss);
        sb1.reverse();
        String s5 = sb1.toString();
        if(ss.equals(s5))
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not Palindrome");
        }
	}

}
