package InterviewQns;

public class StringNoOfOccurenceofChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "java";
        char ch = 'a';
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i) == ch)
            {
                count++;
            }
        }
        System.out.println(count);
	}

}
