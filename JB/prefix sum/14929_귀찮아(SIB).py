import sys

input = sys.stdin.readline

n = int(input())
xs = list(map(int, input().split()))
ans = 0

# for i in range(n-1):
#     for j in range(i+1,n):
#         ans += xs[i] * xs[j]

sums = [xs[0]]
for i in range(1, n):
    sums.append(xs[i] + sums[i-1])

for i in range(n):
    ans += xs[i] * (sums[n-1] - sums[i])

print(ans)