package kyu_4;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HumanReadableDurationFormat {
    /*
        For the purpose of this Kata, a year is 365 days and a day is 24 hours.

        Note that spaces are important.

        Detailed rules
        The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and
        one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is
        greater than 1.

        The components are separated by a comma and a space (", "). Except the last component, which is separated by
        " and ", just like it would be written in English.

        A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1
        year is not correct, but 1 year and 1 second is.

        Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.

        A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid,
        but it should be just 1 minute.

        A unit of time must be used "as much as possible". It means that the function should not return 61 seconds,
        but 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater
        than any valid more significant unit of time.
     */

    public static void main(String[] args) {
        System.out.println(formatDuration(60));
    }

    public static String formatDuration(int seconds) {
        if(seconds < 0)return "";
        if(seconds == 0)return "now";

        LinkedHashMap<String,Integer> timeMap = new LinkedHashMap<>();
            timeMap.put((seconds/31536000) > 1 ? "years" : "year", (seconds/31536000));
            timeMap.put(((seconds/86400)%365) > 1 ? "days" : "day", (seconds/86400)%365);
            timeMap.put(((seconds/3600)%24) > 1 ? "hours" : "hour", ((seconds/3600)%60));
            timeMap.put(((seconds/60)%60) > 1 ? "minutes" : "minute", ((seconds/60)%60));
            timeMap.put((seconds%60) > 1 ? "seconds" : "second", (seconds%60));

        List<String> notNullResultValues = timeMap.entrySet().stream()
                .filter(x -> x.getValue() > 0)
                .map( x -> x.getValue() + " " + x.getKey())
                .collect(Collectors.toList());

        String valuesWithoutLast = IntStream.range(0,notNullResultValues.size()-1).boxed()
                .map(notNullResultValues::get)
                .collect(Collectors.joining(", "));

        String lastValue = notNullResultValues.get(notNullResultValues.size()-1);
        return valuesWithoutLast + (notNullResultValues.size() > 1 ? (" and " + lastValue) : lastValue);
    }

}
