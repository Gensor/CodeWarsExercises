package kyu_6;

import java.util.ArrayList;

public class SplitStrings {
    /*
        Complete the solution so that it splits the string into pairs of two characters. If the string contains an odd number of characters then it should replace the missing second character of the final pair with an underscore ('_').

        Examples:

        StringSplit.solution("abc") // should return {"ab", "c_"}
        StringSplit.solution("abcdef") // should return {"ab", "cd", "ef"}
     */


    public static void main(String[] args) {
        for( String twoCharacters : solution("LovePizza")){
            System.out.print(twoCharacters+" ");
        }
    }

    private static String[] solution(String s) {
        ArrayList<String> result = new ArrayList<>();

        if(s.length()%2 == 1){
            s+="_";
        }

        for (int i = 0 ; i < s.length() ; i+=2){
            result.add(s.substring(i, i+2));
        }

        return result.toArray(new String[0]);
    }
}
