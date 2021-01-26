package kyu_6;

import java.util.ArrayList;

public class ValidBraces {
    /*
        Write a function that takes a string of braces, and determines if the order of the braces is valid. It should return true if the string is valid, and false if it's invalid.

        This Kata is similar to the Valid Parentheses Kata, but introduces new characters: brackets [], and curly braces {}. Thanks to @arnedag for the idea!

        All input strings will be nonempty, and will only consist of parentheses, brackets and curly braces: ()[]{}.

        What is considered Valid?
        A string of braces is considered valid if all braces are matched with the correct brace.

        Examples
        "(){}[]"   =>  True
        "([{}])"   =>  True
        "(}"       =>  False
        "[(])"     =>  False
        "[({})](]" =>  False
     */

    public static void main(String[] args) {
        System.out.println("1: "+isValid("(){}[]")); //true
        System.out.println("2: "+isValid("([{}{}])"));
        System.out.println("3: "+isValid("{{{{}}}}"));
        System.out.println("4: "+isValid("[(])"));
        System.out.println("5: "+isValid("[({})](]"));
        System.out.println("6: "+isValid("}{(}{)}{}{"));
        System.out.println("7: "+isValid("({})({})"));
    }

    public static boolean isValid(String braces) {
        ArrayList<Character> listOfBraces = new ArrayList<>();
        for(char c : braces.toCharArray()) {
            listOfBraces.add(c);
        }

        if(listOfBraces.size()%2 == 1)return false;

        int firstPosition = 0;
        int secondPosition = 1;

        while(listOfBraces.size() > 0) {
            char first = listOfBraces.get(firstPosition);
            char second = listOfBraces.get(secondPosition);
            char opposite;

            switch (first){
                case '(':
                    opposite = ')';
                    break;
                case '{':
                    opposite = '}';
                    break;
                case '[':
                    opposite = ']';
                    break;
                default:return false;
            }

            if(first == second) {
                firstPosition = secondPosition;
                secondPosition++;
                continue;
            }

            if(opposite == second){
                if((secondPosition-firstPosition)%2 == 0)return false;

                listOfBraces.remove(firstPosition);
                listOfBraces.remove(secondPosition-1);

                if(listOfBraces.size() == 0)return true;

                firstPosition = 0;
                secondPosition = 1;
                continue;
            }
            secondPosition++;
            if(secondPosition >= listOfBraces.size())return false;
        }
        return false;
    }

}
