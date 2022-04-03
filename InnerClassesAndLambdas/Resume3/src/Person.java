import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private LocalDate birthDate;

    private class Position{
        String name;
        double salary;

        Position(String name,double salary){
            this.name = name;
            this.salary = salary;
        }

        public String toString(){
            return name+":"+salary;
        }
    }

    private Position position;


    /**
     * Creates a Person with a name and a birthdate.
     */
    public Person(String name, String birthDate){
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
    }

    public int getAge(){
        return -1*Period.between(LocalDate.now(),this.birthDate).getYears();
    }

    public void setPosition(String name, double salary){
        this.position = new Position(name,salary);
    }

    public Position getPosition(){
        return this.position;
    }

    public String toString(){
        return name+" - "+getAge()+":"+this.position;
    }
}