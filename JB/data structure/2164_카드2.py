from collections import deque
import sys

input = sys.stdin.readline

N = int(input())

q = deque()

for i in range(N):
    q.append(i+1)

while len(q) > 1:
    q.popleft()
    q.rotate(-1)

print(q.pop())