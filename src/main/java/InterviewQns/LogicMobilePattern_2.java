package InterviewQns;

public class LogicMobilePattern_2 {

	public static void main(String[] args) {
	    int n = 5;
	    for(int i=1;i<=n;i++)
	    {
	        //System.out.println("i");
	        for(int j=1;j<=n;j++)
	        {
	            //System.out.println("j");
	            if(i==1||j==1||i==n || j==n)
	            {
	                System.out.print("* ");
	            }
	            else{
	                System.out.print("  ");
	            }
	        }
	        System.out.println();
	    }
	    System.out.println("===========================");
	    for(int i=1;i<=n;i++)
	    {
	        for(int j=1;j<=n;j++)
	        {
	            if(i==1||j==1||i==n||j==n||i==j)
	            {
	                System.out.print("* ");
	            }
	            else
	            {
	                System.out.print("  ");
	            }
	        }
	        System.out.println();
	    }
	    System.out.println("===========================");
	    for(int i=1;i<=n;i++)
	    {
	        for(int j=1;j<=n;j++)
	        {
	            if(i==1||j==1||i==n||j==n||i==j||i+j==n+1)
	            {
	                System.out.print("* ");
	            }
	            else
	            {
	                System.out.print("  ");
	            }
	        }
	        System.out.println();
	    }
	    System.out.println("===========================");
	    int kk = 1;
	    int n1 = 9;
	    for(int i=1;i<=n1;i++)
	    {
	        if(kk>9)
	        {
	            kk=1;
	        }
	        for(int j=1;j<=(n1/2)+1;j++)
	        {
	            if(i==1||j==1||i==n1 || j==(n1/2)+1 || i == (n1/2)+1)
	            {
	                System.out.print("* ");
	            }
	            else if(i>(n1/2)+1 && i<n1 && i!=1 && j!=1 )
	            {
	                if(kk>9)
	                {
	                    kk=0;
	                }
	                System.out.print(kk+" ");
	                kk++;
	            }
	            else
	            {
	                System.out.print("  ");
	            }
	        }
	        System.out.println();
	    }
	    System.out.println("===========================");   
	}

}
