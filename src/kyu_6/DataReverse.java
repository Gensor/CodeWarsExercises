package kyu_6;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DataReverse {
    /*
        A stream of data is received and needs to be reversed.

        Each segment is 8 bits long, meaning the order of these segments needs to be reversed, for example:

        11111111  00000000  00001111  10101010
         (byte1)   (byte2)   (byte3)   (byte4)
        should become:

        10101010  00001111  00000000  11111111
         (byte4)   (byte3)   (byte2)   (byte1)
        The total number of bits will always be a multiple of 8.

        The data is given in an array as such:

        [1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0]
        Note: In the C and NASM languages you are given the third parameter which is the number of segment blocks.
    */

    public static void main(String[] args) {
        int[] data1= {1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,0,1,0,1,0,1,0};
        Arrays.stream(dataReverse(data1)).forEach(System.out::print);
    }

    public static int[] dataReverse(int[] data) {

        List<Integer> intList = Arrays.stream(data).boxed().collect(Collectors.toList());

        int[][] intArrays = new int[intList.size()/8][8];

        int position = 0;
        for(int i = 0 ; i < intList.size()/8 ; i++) {
            for (int j = 0 ; j < 8 ; j++){
                intArrays[i][j] = intList.get(position);
                position++;
            }
        }
        position = 0 ;
        Collections.reverse(Arrays.asList(intArrays));
        int[] result = new int[intList.size()];
        for (int []array : intArrays){
            for(int number : array){
                result[position] = number;
                position++;
            }
        }
        return result;
    }
}
