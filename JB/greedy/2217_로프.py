import sys

input = sys.stdin.readline

N = int(input())

rope_weights = []
for i in range(N):
    rope_weights.append(int(input()))

rope_weights.sort(reverse=True)

max_weights = []
for i, weight in enumerate(rope_weights):
    max_weights.append(weight * (i+1))

print(max(max_weights))