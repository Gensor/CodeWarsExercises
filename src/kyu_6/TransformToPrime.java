package kyu_6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class TransformToPrime {
    /*
        Task :
        Given a List [] of n integers , find minimum number to be inserted in a list, so that sum of all elements of list
        should equal the closest prime number .

        Notes
        List size is at least 2 .

        List's numbers will only positives (n > 0) .

        Repetition of numbers in the list could occur .

        The newer list's sum should equal the closest prime number .

        Input >> Output Examples
        1- minimumNumber ({3,1,2}) ==> return (1)
        Explanation:
        Since , the sum of the list's elements equal to (6) , the minimum number to be inserted to transform the sum to
        prime number is (1) , which will make the sum of the List equal the closest prime number (7) .
        2-  minimumNumber ({2,12,8,4,6}) ==> return (5)
        Explanation:
        Since , the sum of the list's elements equal to (32) , the minimum number to be inserted to transform the sum to
        prime number is (5) , which will make the sum of the List equal the closest prime number (37) .
        3- minimumNumber ({50,39,49,6,17,28}) ==> return (2)
        Explanation:
        Since , the sum of the list's elements equal to (189) , the minimum number to be inserted to transform the sum to
        prime number is (2) , which will make the sum of the List equal the closest prime number (191) .
     */

    public static void main(String[] args) {
        int [] data = new int[]{3,1,2};             //1
        int [] data2 = new int[]{50,39,49,6,17,28}; //2
        System.out.println(minimumNumber(data2));

    }

    public static int minimumNumber(int[] numbers){
        int sum = Arrays.stream(numbers).sum();
        return IntStream.range(0,sum)
                .filter(x -> isPrime(x+sum))
                .findFirst()
                .orElse(-1);
    }

    private static boolean isPrime(int number) {
        return IntStream.range(2, number)
                .allMatch(n -> number % n != 0);
    }

}

