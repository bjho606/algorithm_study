import sys

input = sys.stdin.readline

N = int(input())
dp = [0 for _ in range(N+1)]

ts = []
ps = []

for i in range(N):
    T, P = map(int, input().split())
    ts.append(T)
    ps.append(P)

for i in range(N):
    for j in range(i + ts[i], N+1):
        if dp[j] < dp[i] + ps[i]:
            dp[j] = dp[i] + ps[i]
    # print(dp)

print(dp[N])

# 이게 뭐죠..?
# for i in range(N-1, -1, -1):
#     if i + ts[i] > N:
#         dp[i] = dp[i+1]
#     else:
#         dp[i] = max(dp[i+1], ps[i] + dp[i+ts[i]])

# print(dp[0])