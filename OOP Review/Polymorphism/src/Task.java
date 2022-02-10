public class Task {
    Person[] patients = new Person[5];
    public static void main(String[] args) {
        Task t = new Task();
        t.run();
    }

    public void run(){
        Person bart = new ChildPatient();
        Diagnosable lisa = new ChildPatient();
        ChildPatient maggie = new ChildPatient();
        AdultPatient homer = new AdultPatient();
        Employable marge = new AdultPatient();

        // Set the temperature of each child.
        /* TODO */
        //Set the tmeperature of bart to 101.2, maggie 100.1, and lisa 100.6
        ((ChildPatient) bart).setTemperature(101.2);
        maggie.setTemperature(100.1);
        lisa.setTemperature(100.6);

        // set the jobs
        /* TODO */
        //Add the following jobs for homer: Nuclear Engineer, Major and Bar Owner.
        //For marge only one job: Hose Keeper.
        homer.addJob("Nuclear Engineer");
        homer.addJob("Major");
        homer.addJob("Bar Owner");

        marge.addJob("Hose Keeper");

        //insert all of the sympsons in the patients array.
        /* TODO */
        //Insert the Simpsons in the Patients' array: in the following order:
        //bart, lisa, maggie, homer and marge.
        patients[0] = bart;
        patients[1] = (Person) lisa;
        patients[2] = maggie;
        patients[3] = homer;
        patients[4] = (Person) marge;
    }

    public boolean isAdult(Person p){
        return p instanceof Employable;
    }
}