from collections import deque
import sys

input = sys.stdin.readline

N, K = map(int, input().split())

queue = deque()
for i in range(N):
    queue.append(i+1)

print('<', end='')

for i in range(N):
    queue.rotate(-K+1)
    out = queue.popleft()
    if i == N-1:
        print(out, end='')
    else:
        print(out, end=', ')

print('>')