package InterviewQns;

public class StringNoOfVowelsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "ProgrammerJava".toLowerCase();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' ||
            s.charAt(i) == 'o' || s.charAt(i) == 'u')
            {
                count++;
            }
        }
        System.out.println(count);
        
        String s1 = "Java".toLowerCase();
	}

}
