import sys

input = sys.stdin.readline

x, y = map(int, input().split())

# 대각선이 점을 지날 때, 안 지날 때
def gcd(a, b):
    if b > a:
        a, b = b, a
    
    while True:
        if b == 0:
            break
        a, b = b, a % b
    return a

print(x + y - gcd(x, y))