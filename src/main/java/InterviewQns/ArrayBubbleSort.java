package InterviewQns;
import java.util.*;

public class ArrayBubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] a = new int[]{4,5,2,9,7,6,1};
        
        for(int i=0;i<a.length;i++)
        {
            for(int j=0;j<a.length-1;j++)
            {
                if(a[j] > a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

}
