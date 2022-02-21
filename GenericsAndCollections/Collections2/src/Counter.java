import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Counter<E> {
    private HashMap<E, Integer> counts = new HashMap<>(); ;

    public Counter(E[] things){
        for(E e: things)
            if (counts.containsKey(e))
                counts.put(e, counts.get(e) + 1);
            else
                counts.put(e, 1);
    }

    public Integer getCount(E element){
      return counts.get(element);
    }

    public int getSize(){
        return this.counts.size();
    }

    public E mostFrequent(){

        Map.Entry<E, Integer> max = null;

        for (Map.Entry<E, Integer> entry : counts.entrySet())
            if (max == null || entry.getValue().compareTo(max.getValue()) > 0)
                max = entry;

        return max.getKey();
    }
}
