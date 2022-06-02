import sys

input = sys.stdin.readline

N = input().rstrip('\n')

def is_prime(n):
    if n <= 1:
        return False
    elif n == 2:
        return True
    else:
        for i in range(2,n):
            if i * i > n:
                break
            if n % i == 0:
                return False
    
    return True

while True:
    n1 = int(N)
    n2 = int(N[::-1])

    if is_prime(n1) and n1 == n2:
        print(n1)
        break

    N = str(int(N) + 1)