package InterviewQns;

import java.util.*;

public class ArrayFindSmallElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a = new int[]{1,2,3,5,2,3,1,2,5,3,6};
        int min = a[0];
        for(int x : a)
        {
            if(min > x)
            {
                min = x;
            }
        }
        System.out.println(min);
        
        //other way
        
        int[] b = {7,5,3,2,6};
        Arrays.sort(b);
        System.out.println(b[0]);

	}

}
