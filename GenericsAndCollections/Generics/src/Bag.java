import java.util.ArrayList;

public class Bag<T> {
    ArrayList<T> objects;
    public Bag(){
        objects = new ArrayList<>();
    }

    public void add(T t) throws BagException {
        if(t == null)
            throw new BagException("Cannot add null to a Bag");
        else
            objects.add(t);
    }

 /* TODO
Code the drawOne method here. It should not take any
parameters. It should return a generic object. More on the
task description.*/
    public T drawOne(){
        int index = (int) ((Math.random() * (objects.size() - 0)) + 0);
        return objects.get(index);
    }

    public ArrayList<T> drawMany(int howMany){

        ArrayList<T> list = new ArrayList<>();
        for(int i = 0;i<howMany;i++){
            list.add(drawOne());
        }
        return list;
    }

    public void add(T element,double prob) throws BagException{
        if(element == null)
            throw new BagException("Cannot add null to a Bag");
        else if(prob < 0 || prob > 1)
            throw new BagException("Probability should be between 0 and 1");        // This is a way to add elements in a given proportion.

        int tot = (int)Math.round(objects.size()*prob);
        for(int i=0;i<tot;i++){
            System.out.println("Adding "+i);
            objects.add(element);
        }
    }
}
