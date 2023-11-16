package src;

import java.util.LinkedList;
import java.util.Properties;

public class sieve_eratosthenes {

    private static LinkedList sieve_eratosthenes(int max_val) {

        LinkedList <Integer> aux = new LinkedList();

        for (int i = 2; i < max_val; i++){

            aux.add(i);

        }


        for (int i = 0; i < aux.size(); i++){

            for (int curr_iteration = 2; aux.get(i) * curr_iteration <= max_val; curr_iteration ++){

                if (aux.contains(aux.get(i) * curr_iteration) ){
                    aux.remove(Integer.valueOf(i * curr_iteration));
                }
            }

        }

        return aux;

    }


    private static LinkedList sieveOfEratosthenes_v2 (int n) {


        LinkedList<Integer> aux = new LinkedList();

        //Create a list of consecutive integers from 2 through n: (2, 3, 4, ..., n).
        for (int i = 2; i < n; i++) {
            aux.add(i);
        }

        //Initially, let p equal 2, the smallest prime number
        for (int p = 2; p <= n; p++) {

            if (aux.contains(p)) { //then its prime

                //Enumerate the multiples of p by counting in increments of p from 2p to n, and mark them in the list
                for (int i = p * 2; i <= n; i += p) {
                    aux.remove(Integer.valueOf(i));
                }
            }
        }

        return aux;
    }

    public static void main(String[] args) {

        int max = 10000;

        LinkedList results = sieveOfEratosthenes_v2(max);

        System.out.println(results);


    }



}


