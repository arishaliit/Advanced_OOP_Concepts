public class Car {
    public double miles; // number of miles left to travel
    public double odometer; // total miles travelled by the car
    public String name; // the name of the car
    public double maxMiles; // the maximum number of miles when full.

    public Car(String name,double miles){
        this.miles = miles;
        odometer = 0;
        this.name = name;
        this.maxMiles = miles;
    }

    public void move(double miles){
        /* TODO 
move should subtract  'miles' from the miles left to travel and add 'miles' to the odometer. The miles to travel cannot be less than zero. */
    }

    public void charge(){
        this.miles = maxMiles;
    }

    public String toString(){
        return name+": odo:"+odometer+" - miles left:"+miles;
    }

}
