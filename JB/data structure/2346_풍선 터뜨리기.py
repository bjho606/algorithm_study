from collections import deque
import sys

input = sys.stdin.readline

N = int(input())

balloon = deque(map(int, input().split()))
order = deque([i for i in range(1, N+1)])
# print(balloon, order)

for i in range(N):
    next_rotation = balloon.popleft()
    balloon_number = order.popleft()
    print(balloon_number, end=' ')

    if next_rotation > 0:
        balloon.rotate(-next_rotation+1)
        order.rotate(-next_rotation+1)
    else:
        balloon.rotate(-next_rotation)
        order.rotate(-next_rotation)
