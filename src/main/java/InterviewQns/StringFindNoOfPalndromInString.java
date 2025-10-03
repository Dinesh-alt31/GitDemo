package InterviewQns;

public class StringFindNoOfPalndromInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "this is Madam".toLowerCase();
        String[] sa = s.split(" ");
        boolean f = true;
        int c = 0;
        for(String x : sa)
        {
            for(int i=0;i<x.length()/2;i++)
            {
                if(x.charAt(i) != x.charAt(x.length()-i-1))
                {
                    f = false;
                    break;
                }
                else
                {
                    f = true;
                }
            }
            if(f)
            {
                c++;
            }
        }
        System.out.println(c);
	}

}
