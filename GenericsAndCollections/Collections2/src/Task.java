public class Task {
    public static void main(String[] args){
        String text = "It would be nice if we could write a single sort method that could sort the elements in an Integer array, a String array, or an array of any type that supports ordering. "+
                "Java Generic methods and generic classes enable programmers to specify, with a single method declaration, a set of related methods, or with a single class declaration, a set of related types, respectively. "+
                "Generics also provide compile-time type safety that allows programmers to catch invalid types at compile time. "+
                "Using Java Generic concept, we might write a generic method for sorting an array of objects, then invoke the generic method with Integer arrays, Double arrays, String arrays and so on, to sort the array elements";
        Integer[] numbers = {1,3,4,2,4,5,7,4,8,9,4,7,4};
        Counter<Integer> c = new Counter<>(numbers);
        System.out.println("Most frequent:"+c.mostFrequent());
        System.out.println("With count "+c.getCount(c.mostFrequent()));

      /* TODO
Create a counter of String objects called words., and make it work for the words in the String text above. That way, the rest will compile. */);
        System.out.println("Most frequent word:"+words.mostFrequent());
        System.out.println("With "+words.getCount(words.mostFrequent())+" occurrences");
        System.out.println("The word sort appears "+words.getCount("sort")+" times");
    }
}