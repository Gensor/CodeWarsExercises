package kyu_6;

import java.util.Arrays;
import java.util.stream.Collectors;


public class CountingDuplicates {
        /*
        Count the number of Duplicates
        Write a function that will return the count of distinct case-insensitive alphabetic characters and numeric digits that occur more than once in the input string. The input string can be assumed to contain only alphabets (both uppercase and lowercase) and numeric digits.

        Example
        "abcde" -> 0 # no characters repeats more than once
        "aabbcde" -> 2 # 'a' and 'b'
        "aabBcde" -> 2 # 'a' occurs twice and 'b' twice (`b` and `B`)
        "indivisibility" -> 1 # 'i' occurs six times
        "Indivisibilities" -> 2 # 'i' occurs seven times and 's' occurs twice
        "aA11" -> 2 # 'a' and '1'
        "ABBA" -> 2 # 'A' and 'B' each occur twice
         */

    public static void main(String[] args) {
        System.out.println(duplicateCount("aAabcc"));
    }

    public static int duplicateCount(String text) {

        long result = Arrays.stream(text.replaceAll("([a-zA-Z0-9])([a-zA-Z0-9]|$)","$1;$2;").toLowerCase()
                .split(";"))
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .values().stream().filter(i -> i > 1).count();

        return (int)result;
    }

}
