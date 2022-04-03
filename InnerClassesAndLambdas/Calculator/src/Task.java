import java.util.ArrayList;
import java.util.List;

public class Task {
/* TODO */
    public static class Triplet<T,U,V>{
        public T t;
        public U u;
        public V v;
        public Triplet(T t, U u, V v){
            this.t = t;
            this.u = u;
            this.v = v;
        }
    }

    public static String result;
    public static void main(String[] args){
        Calculator c = new Calculator();
        List<Triplet<Double,Double,String>> t = new ArrayList<>();
        t.add(new Triplet<>(3.4,5.2,"+"));
        t.add(new Triplet<>(2.3,1.23,"-"));
        t.add(new Triplet<>(12.4,0.0,"/"));
        t.add(new Triplet<>(56.0,28.0,"/"));
        t.add(new Triplet<>(4.5,5.4,"*"));


        t.forEach(x->result+="\n"+c.compute(x.t,x.u,x.v));
        System.out.println(result);
    }
}