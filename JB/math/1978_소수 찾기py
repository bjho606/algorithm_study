import sys

input = sys.stdin.readline

N = int(input())

def find_prime(n):
    if n <= 1:
        return False
    elif n == 2:
        return True
    else:
        for i in range(2,n):
            if n % i == 0:
                return False
    
    return True

nums = list(map(int, input().split()))
count = 0

for i in nums:
    if find_prime(i) == True:
        count += 1

print(count)