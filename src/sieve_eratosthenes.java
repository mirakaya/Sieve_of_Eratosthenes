package src;

import java.util.LinkedList;
import java.util.Properties;

public class sieve_eratosthenes {

    private static LinkedList sieve_eratosthenes(int max_val) {

        LinkedList results = new LinkedList();

        for (int i = 2; i < max_val; i++){

            results.add(i);

        }


        for (int i = 2; i <= max_val; i++){

            int removed = 0;

            for (int curr_iteration = 2; i * curr_iteration <= max_val; curr_iteration ++){

                if (results.contains(i * curr_iteration) ){
                    results.remove(Integer.valueOf(i * curr_iteration));
                    removed ++;
                }
            }

        }

        return results;

    }

    public static void main(String[] args) {

        int max = 500;

        LinkedList results = sieve_eratosthenes(max);

        System.out.println(results);


    }



}


