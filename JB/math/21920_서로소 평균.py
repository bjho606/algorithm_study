import sys

input = sys.stdin.readline

def gcd(n1, n2):
    if n2 == 0:
        return n1
    if n1 < n2:
        n1, n2 = n2, n1
    return gcd(n2, n1 % n2)

def check_disjoint(n1, n2):
    if gcd(n1, n2) == 1:
        return True

    return False

N = int(input())
A = list(map(int, input().split()))
X = int(input())

sums = 0
count = 0

for a in A:
    if check_disjoint(X, a):
        sums += a
        count += 1

print(sums / count)