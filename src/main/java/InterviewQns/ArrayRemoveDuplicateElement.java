package InterviewQns;

import java.util.*;

public class ArrayRemoveDuplicateElement {

    public static void main(String[] args) {
        int[] a = {10,20,10,10,30,10,20,40,20};
        for(int i=0;i<a.length;i++)
        {
            if(a[i] !=0)
            {
                int num = a[i];
                int pos = -1;
                for(int j=i+1;j<a.length;j++)
                {
                    if(num == a[j])
                    {
                        pos = j;
                        for(int k=pos;k<a.length-1;k++)
                        {
                            a[k] = a[k+1];
                        }
                        a[a.length-1]=0;
                        j--;
                    }
                }
            }
        }
        List<Integer> l = new ArrayList<Integer>();
        for(int x : a)
        {
            if(x!=0)
            {
                l.add(x);
            }
        }
        System.out.println(l);
        int[] b;
        Set<Integer> s = new HashSet<Integer>();
        b = new int[]{4,6,3,4,6,2,5,3,2};
        for(int x:b)
        {
            s.add(x);
        }
        System.out.println(s);
    }
}

