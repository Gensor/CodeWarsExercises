package kyu_6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrizeDraw {
    /*
        Task:
        parameters: st a string of firstnames, we an array of weights, n a rank

        return: the firstname of the participant whose rank is n (ranks are numbered from 1)

        Example:
        names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
        weights: [1, 4, 4, 5, 2, 1]
        n: 4

        The function should return: "PauL"
        Notes:
        The weight array is at least as long as the number of names, it can be longer.

        If st is empty return "No participants".

        If n is greater than the number of participants then return "Not enough participants".

        See Examples Test Cases for more examples.
     */

    public static void main(String[] args) {
        System.out.println(nthRank("Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin",new Integer[]{4, 2, 1, 4, 3, 1, 2},4));

    }
//addison = 1 + 4+ 4+ 9 +19 +15 +14

    public static String nthRank(String st, Integer[] we, int n) {
        if(st.equals(""))
            return "No participants";

        String []names = st.split(",");

        if(names.length < n)
            return "Not enough participants";

        int[] results = Arrays.stream(names).map(String::chars)
                    .map(x -> x.mapToObj(Character::toLowerCase)
                            .mapToInt(s->s%96)
                            .sum())
                .mapToInt(x -> x)
                .toArray();

            for (int i = 0 ; i < results.length ; i++){
                results[i] = (results[i]+names[i].length())*we[i];
            }

        Map<String , Integer> resulto = IntStream.range(0, names.length)
                .boxed()
                .collect(Collectors.toMap( i -> names[i], i -> results[i]));
        Collections.sort(ha);
        return "";
    }



}
