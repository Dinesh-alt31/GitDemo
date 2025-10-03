package InterviewQns;

public class StringFindStringInOtherString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s1 = "this is a program";
        String s2 = "orp ";
        String s3 = "";
        boolean flag = false;
        for(int i=s2.length()-1;i>=0;i--)
        {
            s3 = s3+s2.charAt(i);
        }
        //System.out.println(s3);
        for(int j=0;j<s1.length();j++)
        {
            //System.out.println(s1.charAt(j));
            System.out.println(s1);
            System.out.println(s3);
            if(s1.contains(s3))
            {
                flag = true;
                break;
            }
        }
        System.out.println(flag);
        
        //other way
        String ss1 = "this is a program";
        String ss2 = "si sih";
        StringBuffer sb1 = new StringBuffer(ss2);
        if(ss1.contains(sb1.reverse().toString()))
        {
            System.out.println("TRUE");
        }
        else
        {
            System.out.println("FALSE");
        }

	}

}
