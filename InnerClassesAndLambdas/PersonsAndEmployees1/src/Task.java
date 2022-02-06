import java.util.ArrayList;
import java.util.List;

public class Task {
    public static void main(String[] args){
        Person p1 = new Person("John Doe","2001-05-23");
        Person p2 = new Person("Kate Park","2000-04-28");
        Person p3 = new Person("Kim Tracy","1998-11-04");
        Person p4 = new Person("Stacy Marks","2002-08-15");
        p1.setPosition("Associate",45000);
        p2.setPosition("Senior Associate", 75000);
        p3.setPosition("VP",120000);
        p4.setPosition("VP", 123000);

        List<Person> employees = new ArrayList<>();
        employees.add(p1);
        employees.add(p2);
        employees.add(p3);
        employees.add(p4);

        for(Person p : employees){
            System.out.println(p);
        }
    }
}