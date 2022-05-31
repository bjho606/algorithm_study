import sys

input = sys.stdin.readline

def lcm(n1, n2):
    gcd = 1

    for i in range(min(n1, n2), 0, -1):
        if n1 % i == 0 and n2 % i == 0:
            gcd = i
            break
    val = n1 * n2 // gcd

    # for i in range(max(n1, n2), n1*n2 + 1):
    #     if i % n1 == 0 and i % n2 == 0:
    #         val = i
    #         break

    return val

n = int(input())
for _ in range(n):
    a, b = map(int, input().split())
    print(lcm(a, b))