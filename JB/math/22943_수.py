from itertools import permutations
import math
import sys

input = sys.stdin.readline

K, M = map(int ,input().split())
count = 0
max_range = 1000001
isPrime = [True] * max_range
primes = set()

# def is_prime(n):
#     if n <= 1:
#         return False
#     elif n == 2:
#         return True
#     else:
#         for i in range(2,n):
#             if i * i > n:
#                 break
#             if n % i == 0:
#                 return False
    
#     return True

# 소수 미리 찾아놓기
def prime_setting():
    isPrime[0] = False
    isPrime[1] = False
    isPrime[2] = True
    for i in range(2, int(math.sqrt(max_range)) + 1):
        if isPrime[i]:
            primes.add(i)
            for j in range(i * i, max_range, i):
                isPrime[j] = False

# 조건 1
def cond1(n):
    for prime in primes:
        # if prime + prime >= n: break
        if prime != n - prime and n-prime in primes:
    # for i in range(2, n // 2 + 1):
    #     if i != n - i and isPrime[i] and isPrime[n - i]:
            return True

    return False

def make_undividable(n, m):
    while n % m == 0:
        n //= m

    return n
    
# 조건2
def cond2(n):
    for prime in primes:
        # if prime*prime > n: break
        if n % prime == 0 and n//prime in primes:
    # for i in range(2, int(math.sqrt(n)) + 1):
    #     if  n % i == 0 and i in primes and n // i in primes:
            return True

    return False

# 소수 구해놓기
prime_setting()
# print(primes)

# 숫자 조합
for combi in permutations(['0','1','2','3','4','5','6','7','8','9'], K):
    # print(combi)
    if combi[0] == '0': continue
    num = int(''.join(combi))
    # print(num)

    # 조건 확인
    if cond1(num):
        # print(num)
        undividable_num = make_undividable(num, M)
        if cond2(undividable_num):
            # print(undividable_num)
            count += 1

    # if cond1(num) and cond2(num, M):
    #     count += 1

print(count)