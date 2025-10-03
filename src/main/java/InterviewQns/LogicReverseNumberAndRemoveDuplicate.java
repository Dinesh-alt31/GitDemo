package InterviewQns;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.checkerframework.checker.units.qual.s;

public class LogicReverseNumberAndRemoveDuplicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int n = 11255233;
        Set<Integer> s = new LinkedHashSet<Integer>();
        while(n>0)
        {
            int r = n%10;
            s.add(r);
            n=n/10;
        }
        System.out.println(s);
        Arrays.asList(s);
        for(Object o : s)
        {
            System.out.print(o+" ");
        }
        System.out.println();
        Iterator<Integer> it= s.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next() + " ");
        }
		
	}

}
