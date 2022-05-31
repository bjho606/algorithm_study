import sys

input = sys.stdin.readline

def check_prime(num):
    if num <= 1:
        return False
    elif num == 2:
        print(num)
        return True
    else:
        for i in range(2, (int)(num ** (1/2))+1):
            if num % i == 0:
                return False
    print(num)
    return True

n = int(input())
for _ in range(n):
    val = int(input())
    while True:
        if check_prime(val) == True:
            break
        val += 1