package InterviewQns;

import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionsMap_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Map<String, Integer> original = new LinkedHashMap<>();
        original.put("A",4);
        original.put("B",1);
        original.put("c",5);
        
        Map<String, Integer> insert = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> e : original.entrySet())
        {
            insert.put(e.getKey(),e.getValue());
            if(e.getKey() == "B")
            {
                insert.put("BB",11);
                insert.put("bbb",111);
            }
        }
        for(Map.Entry<String,Integer> e:original.entrySet())
        {
            System.out.println(e.getKey()+" => "+e.getValue());
            System.out.println(original.entrySet());
        }
        for(Map.Entry<String, Integer> e:insert.entrySet())
        {
            System.out.println(e.getKey() +" => "+e.getValue());
            System.out.println(insert.entrySet());
        }
	}

}
