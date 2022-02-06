import java.util.ArrayList;

public class Bag<T> {
    ArrayList<T> objects;
    public Bag(){
        /* TODO 
Initialize the objects variable*/
    }
    /* TODO 
code the add method described. It should be public and not 
return anything. Just take in a parameter and  throw an 
exception. Read the documentation for this.*/

 /* TODO 
Code the drawOne method here. It should not take any
parameters. It should return a generic object. More on the
task description.*/

    public /* return type?*/ drawMany(int howMany){
/* TODO
howMany is the number of elements to draw. 
Create an ArrayList of the generic type and "drawOne" as
many times as you need, putting the element drawn in the ArrayList.
Then return it. */
    }

    public void add(T element,double prob) throws BagException{
        /* TODO 
Check that the probability is between 0 and 1. Otherwise
throw an exception. */        // This is a way to add elements in a given proportion.
        int tot = (int)Math.round(objects.size()*prob);
        for(int i=0;i<tot;i++){
            System.out.println("Adding "+i);
            objects.add(element);
        }
    }
}
