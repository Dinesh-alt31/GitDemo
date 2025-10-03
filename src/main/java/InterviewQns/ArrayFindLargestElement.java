package InterviewQns;

import java.util.*;

public class ArrayFindLargestElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a = new int[]{1,2,3,5,2,3,1,2,5,3,6};
        int max = 0;
        for(int m : a)
        {
            if(max < m)
            {
                max = m;
            }
        }
        System.out.println(max);
        
        int[] b = new int[]{1,2,3,520,2,5,3,6};
        Arrays.sort(b);
        System.out.println("b = "+b);
        System.out.println("To string = "+Arrays.toString(b));
        System.out.println(b[b.length-1]);
        
         
    }

}
