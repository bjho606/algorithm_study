import sys

input = sys.stdin.readline

N = int(input())
A = set(list(map(int, input().split())))    # 중복을 제거하기 위해 set으로 바꿈!
# print(A)

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

sum = 1
for a in A:
    if is_prime(a):
        sum *= a

if sum == 1:
    print(-1)
else:
    print(sum)