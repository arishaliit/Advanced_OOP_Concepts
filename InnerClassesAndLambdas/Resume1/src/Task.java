public class Task {
    public static void main(String[] args){
        Person p = new Person("Kim Possible","2000-01-01");
        p.setPosition("Associate", 34000);
        Resume r = new Resume(p);
        /* TODO */
Create an education object. Schoo is NEIU, major is Computer Science.
       /* TODO */
add this education object to the resume "r"
        /* TODO */
Create a new Experience object and add it to the resume.
        r.addExperience(/* TODO */
Create a new experience object on the fly, inside the addExperiece call.);
        r.addExperience(/* TODO */
Add another experience object on the fly as you add it.);
        System.out.println(r); //watch the resume print.

    }
}