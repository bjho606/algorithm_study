import sys

input = sys.stdin.readline

N = int(input())
A = list(map(int, input().split()))
plus, minus, multi, div = map(int, input().split())

# 초기화
max_val = -1e9
min_val = 1e9

def dfs(depth, arr):
    global plus, minus, multi, div, max_val, min_val
    if depth == N:
        max_val = max(max_val, arr)
        min_val = min(min_val, arr)
    else:
        if plus > 0:
            plus -= 1
            dfs(depth + 1, arr + A[depth])
            plus += 1
        if minus > 0:
            minus -= 1
            dfs(depth + 1, arr - A[depth])
            minus += 1
        if multi > 0:
            multi -= 1
            dfs(depth + 1, arr * A[depth])
            multi += 1
        if div > 0:
            div -= 1
            dfs(depth + 1, int(arr / A[depth]))
            div += 1

dfs(1, A[0])

print(max_val)
print(min_val)