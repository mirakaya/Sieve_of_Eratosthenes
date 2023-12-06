package src;

import java.util.TreeSet;

public class sieve_eratosthenes {

    private static TreeSet<Integer> sieveOfEratosthenes (int n) {


        TreeSet<Integer> aux = new TreeSet<>();

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

        int max = 1000000;

        //long init_time = System.currentTimeMillis();

        TreeSet results = sieveOfEratosthenes(max);
        System.out.println(results.size());

        //long end_time = System.currentTimeMillis();
        //System.out.println("Time v2 " + (end_time - init_time));

    }

}


