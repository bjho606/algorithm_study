from collections import deque
import sys

input = sys.stdin.readline

N, M = map(int, input().split())

a = deque([i for i in range(1, N+1)])
pick = deque(map(int, input().split()))

count = 0
M_count = 0
while True:
    if not pick:
        break
    if a[0] == pick[0]:
        a.popleft()
        pick.popleft()
        continue

    if a.index(pick[0]) <= len(a) // 2:
        a.rotate(-1)
    else:
        a.rotate(1)
    count += 1
    
print(count)