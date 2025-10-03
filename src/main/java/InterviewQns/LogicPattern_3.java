package InterviewQns;

public class LogicPattern_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int n = 5;
	    for(int i=n;i>=1;i--)
	    {
	        for(int j = 1;j<=i;j++)
	        {
	            System.out.print("* ");
	        }
	        System.out.println();
	    }
	    System.out.println("=====================================");
	    for(int i=n;i>=1;i--)
	    {
	        int k=0;
	        for(int s=1;s<i;s++)
	        {
	            System.out.print("  ");
	            k++;
	        }
	        //System.out.print("k = "+k);
	        for(int j=1;j<=n-k;j++)
	        {
	            System.out.print("* ");
	        }
	        System.out.println();
	        //for()
	    }
	    System.out.println("=====================================");
	    for(int i=1;i<=n;i++)
	    {
	        for(int s=n;s>i;s--)
	        {
	            System.out.print("  ");
	        }
	        for(int j=1;j<=2*i-1;j++)
	        {
	            System.out.print("* ");
	        }
	        System.out.println();
	    }
	    System.out.println("=====================================");
	    for(int i=1;i<=n;i++)
	    {
	        int k=1;
	        for(int s=n;s>i;s--)
	        {
	            System.out.print("  ");
	        }
	        for(int j=1;j<=2*i-1;j++)
	        {
	            if(j<i)
	            {
	            System.out.print(k+" ");
	            k++;                
	            }
	            else
	            {
	            System.out.print(k+" ");
	            k--;                 
	            }
	        }
	        System.out.println();
	    }

	}

}
