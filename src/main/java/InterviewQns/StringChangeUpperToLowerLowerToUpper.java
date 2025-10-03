package InterviewQns;

import java.util.LinkedList;

public class StringChangeUpperToLowerLowerToUpper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "PrOgRaMMGGgPOo";
        for(int i=0; i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch >=65 && ch <=90)
            {
                System.out.print((char)(ch+32));
            }
            else if(ch >=97 && ch <=122)
            {
                System.out.print((char)(ch-32));
            }
        }
        
	}

}
