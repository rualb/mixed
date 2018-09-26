import java.io.BufferedWriter;
import java.io.Console;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.util.*;


public class Main {

         public static void coin_changing_number_of_ways() {

        int tot = 5;
        int[] cois = {1, 2, 3};


        int[][] buf = new int[cois.length][tot + 1];

        for (int c = 0; c < buf.length; ++c) {

            int[] tots_for_coin = buf[c];

            int coin = cois[c];

            for (int t = 0; t < tots_for_coin.length; ++t) {

                if(t == 0)
                {
                    //used as dummy
                    tots_for_coin[t] = 1;
                    continue;
                }
                if (coin == 1) {
                    tots_for_coin[t] = 1;
                    continue;
                }
                if(coin > t)
                {
                    tots_for_coin[t] = buf[c-1][t];
                    continue;
                }
                //
                tots_for_coin[t] = buf[c-1][t]+buf[c][t-coin];

            }

        }


        System.out.println(buf[cois.length-1][tot]);


    }
        public static void longest_increasing_subsequence_via_dyn() {

        Integer[] arr = {3, 4, -1, 0, 6, 2, 3};
        Integer[] buf = new Integer[arr.length];

        //init
        for (int i1 = 0; i1 < arr.length; ++i1) {
            if (buf[i1] == null)
                buf[i1] = 1;
        }

        for (int i1 = 0; i1 < arr.length-1; ++i1) {

            for (int i2 = 0; i2 <= i1; ++i2) {

                if (arr[i1+1] > arr[i2] && buf[i2] + 1 > buf[i1+1])
                    buf[i1+1] = buf[i2] + 1;

            }

        }

        int max = -1;
        for (Integer x : buf)
            max = Math.max(max, x);

        System.out.println(max);

    }
        
public static void longest_increasing_subsequence_via_stack(){

        Integer[] arr = {3, 4, -1, 0, 6, 2, 3};


        Stack<Integer> stack = new Stack<>();

        int max = -1;
        for (int i = 0; i < arr.length; ++i) {

            if (stack.isEmpty()) {
                stack.add(i);
                continue;
            }

            if (arr[i] > arr[stack.peek()]) {
                stack.add(i);
            }

            if (i == arr.length - 1) {
                if(stack.isEmpty())
                    break;

                max = Math.max(max, stack.size());
//
                for(Integer x:stack)
                    System.out.print(arr[x]+" ");

                System.out.println();
//
                int prev = stack.pop();
                i = prev;


            }
 
        }

    }

}
