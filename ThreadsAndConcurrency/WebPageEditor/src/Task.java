public class Task {
    public static void main(String[] args){
        WebPageEditor wpe = new WebPageEditor("index.html");
        System.out.println("Write whatever you want. Type quit to finish.");
        System.out.println("Whatever you have entered so far will be saved periodically");
        System.out.println("To add a title, prefix the line with t:  (e.g. t:Chapter 1 )");
        System.out.println("You can always view the formatted text by clicking on index.html in the root directory of this project.");
        wpe.start();
    }
}