package InterviewQns;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LogicFibonacciSeries_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("fib(8) = "+ fib(8));
        int[] r = fib(2);
        for(int x:r)
        {
            System.out.print(x+" ");
        }
        int[] r1 = fib(8);
        System.out.println("\nArrays.toString() = "+ Arrays.toString(r1));
    }
    public static int[] fib(int n)
    {
        int a = 0,b=1,c=0;
        //int n = 8;
        int m;
        List<Integer> l = new LinkedList<>();
        int[] ar = new int[1];
        //System.out.println(ar.length);
        if(n==1)
        {
            l.add(0);
            ar[0]=0;
            //return Arrays.toString(ar);
            return ar;
        }
        else 
        {
            l.add(a);
            l.add(b);
            
        }
        int[] ar2 = new int[l.size()];
        for(int i=0;i<ar2.length;i++)
        {
            ar2[i] = l.get(i);
        }
        m=n-2;
        while(m>0)
        {
            c=a+b;
            l.add(c);
            a=b;
            b=c;
            m--;   
        }
        if(n>2)
        {
            int[] ar1 = new int[l.size()];
            //System.out.println(ar1.length);
            for(int i=0;i<l.size();i++)
            {
                ar1[i] = l.get(i);
            }
            for(int x: ar1)
            {
                //System.out.print(x+" ");
            }
            //return Arrays.toString(ar1);
            return ar1;
        }
    //return Arrays.toString(ar2);
        return ar2;
    }

}
