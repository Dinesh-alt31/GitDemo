package InterviewQns;

import java.util.HashMap;
import java.util.Map;

public class CollectionsMap_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map<String, Integer> m = new HashMap<>();
        m.put("A",4);
        m.put("B",1);
        m.put("c",5);
        
        for(Map.Entry<String, Integer> e : m.entrySet())
        {
            int i = e.getValue();
            String s = e.getKey();
            
            if(i>2)
            {
                System.out.println("Person "+s+ " mark = "+i);
            }
        }
	}

}
