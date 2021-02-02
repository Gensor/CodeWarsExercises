package kyu_6;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
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
        System.out.println(nthRank("Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden",new Integer[]{1, 3, 5, 5, 3, 6},2));

    }

    public static String nthRank(String st, Integer[] we, int n) {
        if(st.equals(""))
            return "No participants";

        String []names = st.split(",");

        if(names.length < n)
            return "Not enough participants";

        //for each name: take letters from name, make them lower case, convert them to asci number % 96 and count them
        int[] results = Arrays.stream(names)
                .map(String::chars)
                .map(x -> x.mapToObj(Character::toLowerCase)
                        .mapToInt(s->s%96)
                        .sum())
                .mapToInt(x -> x)
                .toArray();

        for (int i = 0 ; i < results.length ; i++){
            results[i] = (results[i]+names[i].length())*we[i];
        }
        //create map from names and values
        Map<String , Integer> mapOfNamesAndValues = IntStream.range(0, names.length)
                .boxed()
                .collect(Collectors.toMap( i -> names[i], i -> results[i]));

        //sort map by keys first then by value;
        mapOfNamesAndValues = mapOfNamesAndValues.entrySet().stream()
                .sorted((k1, k2) -> -k2.getKey().compareTo(k1.getKey()))
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        //get a keys as the array
        Object[] keys = mapOfNamesAndValues.keySet().toArray();

        return keys[n-1].toString();
    }



}
