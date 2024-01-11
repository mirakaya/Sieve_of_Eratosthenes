#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov 15 20:28:47 2023

@author: Pooyan


Pseudocode

Ref: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes

algorithm Sieve of Eratosthenes is

    input: an integer n > 1.
    output: all prime numbers from 2 through n.

    let A be an array of Boolean values, indexed by integers 2 to n,
    initially all set to true.
    
    for i = 2, 3, 4, ..., not exceeding √n do
        if A[i] is true
            for j = i2, i2+i, i2+2i, i2+3i, ..., not exceeding n do
                set A[j] := false

    return all i such that A[i] is true.
"""

import multiprocessing
from math import sqrt
import time
import argparse 
import sys



def segment_process(segment_start, segment_end, is_prime, lock) -> None:
    for i in range(2, int(sqrt(segment_end)) + 1):
        if is_prime[i]:
            for j in range(max(i*i, (segment_start // i) * i), segment_end + 1, i):
                with lock:
                    is_prime[j] = False

def sieve_of_eratosthenes(limit, num_segments=4)  -> None:
    
    is_prime = multiprocessing.Array('b', [True] * (int(limit) + 1))
    is_prime[0] = is_prime[1] = False  

    lock = multiprocessing.Lock()
    segment_size = (int(limit) + 1) // num_segments
    segments = [(i * segment_size, (i + 1) * segment_size) for i in range(num_segments)]
    

    
    processes = []
    for (start, end) in segments:
        process = multiprocessing.Process(target=segment_process, args=(start, end, is_prime, lock))
        processes.append(process)
        process.start()

    for process in processes:
        process.join()
        
    
   
    primes = [i for i in range(2, int(limit) + 1) if is_prime[i]]

if __name__ == '__main__':
    sieve_of_eratosthenes(limit=100000)
