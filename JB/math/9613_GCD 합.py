import sys

input = sys.stdin.readline

def get_gcd(n1, n2):
    if n2 == 0:
        return n1
    if n1 < n2:
        n1, n2 = n2, n1
    return get_gcd(n2, n1%n2)

t = int(input())
for _ in range(t):
    ip = list(map(int, input().split()))
    n = ip[0]
    sum = 0
    for i in range(1, n):
        for j in range(i+1, n+1):
            sum += get_gcd(ip[i], ip[j])

    print(sum)