package kyu_6;

import java.util.stream.IntStream;


public class DetectPangram {
    /*
        A pangram is a sentence that contains every single letter of the alphabet at least once. For example,
        the sentence "The quick brown fox jumps over the lazy dog" is a pangram, because it uses the letters A-Z
        at least once (case is irrelevant).

        Given a string, detect whether or not it is a pangram. Return True if it is, False if not. Ignore numbers
        and punctuation.
     */

    public static void main(String[] args) {
        System.out.println(check("jozo"));  //false
        System.out.println(check("the quick brown fox jumps over the lazy dog"));   //true
    }


    public static boolean check(String sentence){
        return IntStream.range(0,26)
                 .mapToObj(x -> Character.toString('a'+x))
                 .allMatch(sentence.toLowerCase()::contains);
    }



}
