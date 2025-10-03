package InterviewQns;

public class StringChangea2b2TOaabb {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "a3c5b2a4b3";
        char[] chars = new char[26];
        int[] freq = new int[26];
        int i=0;
        while(i<s.length())
        {
            char ch = s.charAt(i);
            i++;
            StringBuilder nStr = new StringBuilder();
            while(i<s.length() && Character.isDigit(s.charAt(i)))
            {
                nStr.append(s.charAt(i));
                i++;
            }
            int count = Integer.parseInt(nStr.toString());
            int index = ch-'a';
            chars[index] = ch;
            freq[index] += count;
        }
        StringBuilder sres = new StringBuilder();
        for(int j=0;j<26;j++)
        {
            if(freq[j]>0)
            {
                sres.append(chars[j]).append(freq[j]);
            }
        }
        //System.out.println(sres);
        //System.out.println(sres.toString());
        String ss = new String(sres);
        System.out.println(ss);
        String res = "";
        for(int k=1;k<ss.length();k+=2)
        {
            int n = (ss.charAt(k)) - 48;
            for(int l=1;l<=n;l++)
            {
                res = res+ss.charAt(k-1);
            }
        }
        System.out.println(res);

	}

}
