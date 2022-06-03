import math
import sys

input = sys.stdin.readline


A, B = map(int, input().split())
max_range = 10000001
isPrime = [True] * max_range
# almostPrime = [False] * max_range

def set_primes():
    isPrime[0] = False
    isPrime[1] = False
    isPrime[2] = True
    for i in range(2, int(math.sqrt(max_range)) + 1):
        if isPrime[i]:
            for j in range(i * i, max_range, i):
                isPrime[j] = False

            # temp = i * i
            # while temp < max_range:
            #     almostPrime[temp] = True
            #     temp *= i

set_primes()
count = 0

for i in range(2, max_range):
    if not isPrime[i]: continue
    multi = i * i
    while multi <= B:
        count += (A <= multi)
        multi *= i

# for i in range(A, B+1):
#     if almostPrime[i]:
#         # print(i)
#         count += 1

print(count)