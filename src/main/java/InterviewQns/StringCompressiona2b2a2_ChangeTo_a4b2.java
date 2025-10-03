package InterviewQns;

public class StringCompressiona2b2a2_ChangeTo_a4b2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "a30d4b3d2c5a3c40";
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
            int index = ch -'a';
            chars[index] = ch;
            freq[index] += count;
        }
        StringBuilder res = new StringBuilder();
        for(int j=0;j<26; j++)
        {
            if(freq[j] >0)
            {
                res.append(chars[j]).append(freq[j]);
            }
        }
        System.out.println(res);
	}

}
