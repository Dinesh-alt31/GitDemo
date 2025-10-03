package InterviewQns;

import java.util.Arrays;

public class StringFindAnagramOrNot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1 = "java";
        String s2 = "aavj";
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        boolean f = true;
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for(int i=0;i<ch1.length;i++)
        {
            if(ch1[i] != ch2[i])
            {
                f = false;
                break;
            }
        }
        if(f)
        {
            System.out.println("Anagram");
        }
        else
        {
            System.out.println("Not Anagram");
        }
        //other waya
        String ss1 = "java";
        String ss2 = "vaaj";
        if(ss1.length() == ss2.length())
        {
            char[] ch3 = ss1.toCharArray();
            char[] ch4 = ss2.toCharArray();
            Arrays.sort(ch3);
            Arrays.sort(ch4);
            String sa1 = Arrays.toString(ch3);
            String sa2 = Arrays.toString(ch4);
            if(Arrays.equals(ch3,ch4))
            {
                System.out.println("Anagram");
            }
            else
            {
                System.out.println("Not Anagram");
            }
        }
	}

}
