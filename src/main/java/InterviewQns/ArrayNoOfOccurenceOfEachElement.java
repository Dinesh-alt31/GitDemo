package InterviewQns;

public class ArrayNoOfOccurenceOfEachElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[]{1,2,3,5,2,3,1,2,5,3,6};
        //int[] a = {1,2,3,5,2,3,1,2,5,3,6};
        for(int i=0;i<a.length;i++)
        {
            int num = a[i];
            int c = 0;
            if(num !=0)
            {
                for(int j=0;j<a.length;j++)
                {
                    if(num == a[j])
                    {
                        a[j] = 0;
                        c++;
                    }
                } 
                System.out.println(a[i] +"--->"+c);
            }
        }
	}

}
