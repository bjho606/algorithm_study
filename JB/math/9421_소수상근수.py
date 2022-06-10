import math
import sys

input = sys.stdin.readline


N = int(input())

isPrime = [True] * (N+1)
primes = []

def setPrime():
    isPrime[0] = False
    isPrime[1] = False

    for i in range(2, N+1):
        if isPrime[i]:
            primes.append(i)
            for j in range(i * i, N+1, i):
                isPrime[j] = False

def isSangun(n):
    isWrong = []
    while True:
        if n == 1:
            return True
        elif isWrong.count(n) > 1:
            return False
        
        temp = str(n)
        n = 0
        for i in range(len(temp)):
            n += int(temp[len(temp) - 1 - i]) ** 2
        
        isWrong.append(n)
        # print(n)

setPrime()
# print(primes)

for i in primes:
    if isSangun(i):
        print(i)