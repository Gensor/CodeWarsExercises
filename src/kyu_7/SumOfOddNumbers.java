package kyu_7;

import java.util.ArrayList;

public class SumOfOddNumbers {


    /*
        Given the triangle of consecutive odd numbers:

                     1
                  3     5
               7     9    11
           13    15    17    19
        21    23    25    27    29
        ...
        Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:

        rowSumOddNumbers(1); // 1
        rowSumOddNumbers(2); // 3 + 5 = 8
     */

    public static void main(String[] args)
    {
        int row = 42;

        int result =0;
        int number = 1;
        for ( int i = 1 ; i <= row ; i++ )
        {
            for ( int rowNumbers = 0 ; rowNumbers < i ; rowNumbers++ )
            {
                if ( number%2 == 1 ){
                    if( i == row){
                        result+=number;
                    }
                    number ++;
                }
                number++;
            }
        }

        System.out.println(result);

    }




}
