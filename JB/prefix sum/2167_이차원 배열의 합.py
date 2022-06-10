import sys

input = sys.stdin.readline

N, M = map(int, input().split())

# [input array]
arr = [[0 for _ in range(M+1)]] + [[0]+list(map(int, input().split())) for _ in range(N)]
sum_arr = [[0 for _ in range(M+1)] for _ in range(N+1)]
# for i in arr:
#     print(i)

# [prefix sum]
for i in range(1, N+1):
    for j in range(1, M+1):
        sum_arr[i][j] = sum_arr[i-1][j] + sum_arr[i][j-1] - sum_arr[i-1][j-1] + arr[i][j]
# for i in sum_arr:
#     print(i)

K = int(input())

for i in range(K):
    i,j,x,y = map(int, input().split())

    sum = sum_arr[x][y] - sum_arr[i-1][y] - sum_arr[x][j-1] + sum_arr[i-1][j-1]

    print(sum)